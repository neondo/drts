package com.neon.rtp.dwd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neon.rtp.entity.Order;
import com.neon.rtp.entity.OrderDetail;
import com.neon.rtp.kafka.producer.KafkaCanalProducer;
import com.neon.rtp.model.OrderWide;
import com.neon.rtp.service.OrderWideService;
import com.neon.rtp.service.impl.OrderWideServiceImpl;
import com.neon.rtp.uitl.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.HasOffsetRanges;
import org.apache.spark.streaming.kafka010.OffsetRange;
import redis.clients.jedis.Jedis;
import scala.Tuple2;

import java.util.*;

/**
 * @author Neon
 * @date 2021/5/14 11:50
 */
public class OrderWideApp{

    private final static String ORDER_DETAIL_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_",
            ORDER_PREVENT_REPLICATE_CACHE_KEY = "ORDER_PREVENT_REPLICATE_CACHE_KEY",
            ORDER_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_";

    private final static String ODS_ORDER_TOPIC = "ODS_ORDER_TOPIC",
            ODS_ORDER_DETAIL_TOPIC = "ODS_ORDER_DETAIL_TOPIC",
            DWD_ORDER_WIDE_TOPIC = "DWD_ORDER_WIDE_TOPIC";

    private final static String CONSUMER_GROUP = "REAL_TIME_PANEL";

    private static OrderWideService orderWideService = new OrderWideServiceImpl();

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
        Map<TopicPartition, Long> orderOffsetMap = KafkaUtil.getOffsetMap(ODS_ORDER_TOPIC, CONSUMER_GROUP);
        //获取订单流
        JavaInputDStream<ConsumerRecord<String, String>> orderDirectStream = KafkaUtil
                .createDirectStream(ssc, OrderWideApp.ODS_ORDER_TOPIC, OrderWideApp.CONSUMER_GROUP, orderOffsetMap);
        //获取订单详情流
        Map<TopicPartition, Long> orderDetailOffsetMap = KafkaUtil.getOffsetMap(ODS_ORDER_DETAIL_TOPIC, CONSUMER_GROUP);
        JavaInputDStream<ConsumerRecord<String, String>> orderDetailDirectStream = KafkaUtil
                .createDirectStream(ssc, OrderWideApp.ODS_ORDER_DETAIL_TOPIC, OrderWideApp.CONSUMER_GROUP,
                        orderDetailOffsetMap);
        //读取offset
        List<OffsetRange> newOrderOffsetList = new ArrayList<>();
        JavaDStream<ConsumerRecord<String, String>> orderTransformStream = orderDirectStream.transform(rdd->{
            OffsetRange[] offsetRanges = ((HasOffsetRanges) rdd).offsetRanges();
            newOrderOffsetList.addAll(Arrays.asList(offsetRanges));
            return rdd;
        });
        List<OffsetRange> newOrderDetailOffsetList = new ArrayList<>();
        JavaDStream<ConsumerRecord<String, String>> orderDetailTransformStream = orderDetailDirectStream
                .transform(rdd->{
                    OffsetRange[] offsetRanges = ((HasOffsetRanges) rdd).offsetRanges();
                    newOrderDetailOffsetList.addAll(Arrays.asList(offsetRanges));
                    return rdd;
                });
        //开窗
        JavaDStream<ConsumerRecord<String, String>> orderWindowStream = orderTransformStream.
                window(Durations.seconds(20), Durations.seconds(5));
        JavaDStream<ConsumerRecord<String, String>> orderDetailWindowStream = orderDetailTransformStream
                .window(Durations.seconds(20), Durations.seconds(5));
        //转化
        JavaPairDStream<String, Order> orderJoinStream = orderWindowStream.mapToPair(cr->{
            String value = cr.value();
            Order order = JSON.parseObject(value, Order.class);
            return new Tuple2<>(order.getOrderNo(), order);
        });
        JavaPairDStream<String, OrderDetail> orderDetailJoinStream = orderDetailWindowStream.mapToPair(cr->{
            String value = cr.value();
            OrderDetail order = JSON.parseObject(value, OrderDetail.class);
            return new Tuple2<>(order.getOrderNo(), order);
        });
        //full join
        JavaPairDStream<String, Tuple2<Optional<Order>, Optional<OrderDetail>>> fullJoinResultStream = orderJoinStream
                .fullOuterJoin(orderDetailJoinStream);
        JavaDStream<OrderWide> orderWideStream = fullJoinResultStream.mapPartitions(
                (iterator)->{
                    List<OrderWide> orderWideList = new ArrayList<>();
                    StringBuffer buffer = new StringBuffer();
                    Jedis jedis = RedisClient.getJedis();
                    iterator.forEachRemaining(val->{
                        String orderNo = val._1;
                        //去重
                        Long existV = jedis.sadd(ORDER_PREVENT_REPLICATE_CACHE_KEY, orderNo);
                        if(existV == 0) {
                            return;
                        }
                        Order order = val._2._1.get();
                        OrderDetail orderDetail = val._2._2.get();
                        OrderWide orderWide = createOrderWide(orderNo, order, orderDetail, jedis);
                        if(orderWide == null)
                            return;
                        buffer.append(",").append("'").append(orderWide.getVin()).append("'");
                        orderWideList.add(orderWide);
                    });
                    jedis.close();
                    String vinStrArr = buffer.toString().substring(1);
                    wrapperBrand8sendMessage2dwd(orderWideList, vinStrArr);
                    //save to rds
                    JdbcPoolUtil.batchInsert(orderWideList);
                    return orderWideList.iterator();
                });
        //save offset
        orderDirectStream.foreachRDD(rdd->KafkaUtil.saveOffset(ODS_ORDER_TOPIC, CONSUMER_GROUP, newOrderOffsetList));
        orderDirectStream
                .foreachRDD(
                        rdd->KafkaUtil.saveOffset(ODS_ORDER_DETAIL_TOPIC, CONSUMER_GROUP, newOrderDetailOffsetList));
    }

    private static void wrapperBrand8sendMessage2dwd(List<OrderWide> orderWideList, String vinStrArr) {
        List<JSONObject> vinBrandResultList = JdbcPoolUtil.select(
                String.format("SELECT brand_id,brand_name,vin FROM t_car_vin WHERE vin IN(%s)", vinStrArr));
        Map<String, String> vinBrandInfoMap = CollectUtil.toMap(vinBrandResultList, o->o.getString("vin"),
                o->o.getString("brandId") + StringUtil.line + o.getString("brandName"));
        orderWideList.forEach(orderWide->{
            String brandIdName = vinBrandInfoMap.get(orderWide.getVin());
            if(brandIdName != null) {
                String[] brandIdNameArr = brandIdName.split(StringUtil.line);
                orderWide.setBrandId(Long.valueOf(brandIdNameArr[0]));
                orderWide.setBrandName(brandIdNameArr[1]);
            }
            KafkaCanalProducer.send(DWD_ORDER_WIDE_TOPIC, JSON.toJSONString(orderWide));
        });
    }

    private static OrderWide createOrderWide(String orderNo, Order order, OrderDetail orderDetail,
                                             Jedis jedis) {
        if(order == null) {
            String orderStr = jedis.hget(ORDER_CACHE_KEY, orderNo);
            if(orderStr == null) {
                jedis.hset(ORDER_CACHE_KEY, orderNo, JSON.toJSONString(orderDetail));
                return null;
            } else {
                order = JSON.parseObject(orderStr, Order.class);
            }
        } else if(orderDetail == null) {
            String orderStr = RedisClient.hget(ORDER_DETAIL_CACHE_KEY, orderNo);
            if(orderStr == null) {
                RedisClient.hset(ORDER_DETAIL_CACHE_KEY, orderNo, JSON.toJSONString(order));
                return null;
            } else {
                orderDetail = JSON.parseObject(orderStr, OrderDetail.class);
            }
        }
        return new OrderWide(order, orderDetail);
    }
}
