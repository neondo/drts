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
import com.neon.rtp.uitl.Constants.KafkaGroupName;
import com.neon.rtp.uitl.Constants.KafkaTopicName;
import com.neon.rtp.uitl.Constants.RedisKeyName;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.HasOffsetRanges;
import org.apache.spark.streaming.kafka010.OffsetRange;
import redis.clients.jedis.Jedis;
import ru.yandex.clickhouse.ClickHouseUtil;
import scala.Tuple2;

import java.util.*;
/**
 * @author Neon
 * @date 2021/5/15 15:10
 */

/**
 * @author Neon
 * @date 2021/5/14 11:50
 */
public class OrderWideApp{

    private static OrderWideService orderWideService = new OrderWideServiceImpl();

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
        Map<TopicPartition, Long> orderOffsetMap = KafkaUtil
                .getOffsetMap(KafkaTopicName.ODS_ORDER_TOPIC, KafkaGroupName.CONSUMER_GROUP);
        //获取订单流
        JavaInputDStream<ConsumerRecord<String, String>> orderDirectStream = KafkaUtil
                .createDirectStream(ssc, KafkaTopicName.ODS_ORDER_TOPIC,
                        KafkaGroupName.CONSUMER_GROUP, orderOffsetMap);
        //获取订单详情流
        Map<TopicPartition, Long> orderDetailOffsetMap = KafkaUtil
                .getOffsetMap(KafkaTopicName.ODS_ORDER_DETAIL_TOPIC, KafkaGroupName.CONSUMER_GROUP);
        JavaInputDStream<ConsumerRecord<String, String>> orderDetailDirectStream = KafkaUtil
                .createDirectStream(ssc, KafkaTopicName.ODS_ORDER_DETAIL_TOPIC,
                        KafkaGroupName.CONSUMER_GROUP,
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
                    Map<String, String> cityMap = RedisClient.hgetAll(RedisKeyName.CITY_MAP);
                    List<OrderWide> orderWideList = new ArrayList<>();
                    StringBuffer vinBuffer = new StringBuffer();
                    StringBuffer userIdBuffer = new StringBuffer();
                    Jedis jedis = RedisClient.getJedis();
                    iterator.forEachRemaining(val->{
                        String orderNo = val._1;
                        //去重
                        Long existV = jedis.sadd(KafkaTopicName.ORDER_PREVENT_REPLICATE_CACHE_KEY, orderNo);
                        if(existV == 0) {
                            return;
                        }
                        Order order = val._2._1.get();
                        OrderDetail orderDetail = val._2._2.get();
                        OrderWide orderWide = createOrderWide(orderNo, order, orderDetail, jedis);
                        if(orderWide == null)
                            return;
                        vinBuffer.append(",").append("'").append(orderWide.getVin()).append("'");
                        userIdBuffer.append(",").append(orderWide.getUserId());
                        orderWideList.add(orderWide);
                    });
                    jedis.close();
                    String vinStrArr = vinBuffer.toString().substring(1);
                    String userIdStrArr = userIdBuffer.toString().substring(1);
                    wrapperBrand8sendMessage2dwd(orderWideList, vinStrArr, userIdStrArr, cityMap);
                    //save to rds
                    JdbcPoolUtil.batchInsert(orderWideList);
                    //
                    return orderWideList.iterator();
                });
        //save offset
        orderWideStream
                .foreachRDD(rdd->{
                    //保存到clickhouse
                    List<OrderWide> collect = rdd.map(orderWide->orderWide).collect();
                    SparkUtil.clickHouseBatchInsert(collect);
                    KafkaUtil
                            .saveOffset(KafkaTopicName.ODS_ORDER_TOPIC, KafkaGroupName.CONSUMER_GROUP,
                                    newOrderOffsetList);
                    KafkaUtil.saveOffset(KafkaTopicName.ODS_ORDER_DETAIL_TOPIC, KafkaGroupName.CONSUMER_GROUP,
                            newOrderDetailOffsetList);
                });
    }

    private static void wrapperBrand8sendMessage2dwd(List<OrderWide> orderWideList,
                                                     String vinStrArr, String userIdStrArr,
                                                     Map<String, String> cityMap) {
        List<JSONObject> vinBrandResultList = JdbcPoolUtil.select(
                String.format("SELECT brand_id,brand_name,vin FROM t_car_vin WHERE vin IN(%s)", vinStrArr));
        List<JSONObject> userDetailResultList = JdbcPoolUtil.select(
                String.format("SELECT user_id,city_id FROM t_user_detail WHERE vin IN(%s)", userIdStrArr));
        Map<String, String> vinBrandInfoMap = CollectUtil.toMap(vinBrandResultList, o->o.getString("vin"),
                o->o.getString("brandId") + StringUtil.line + o.getString("brandName"));
        Map<Long, Long> userIdCityIdMap = CollectUtil.toMap(userDetailResultList, o->o.getLong("userId"),
                o->o.getLong("cityId"));
        orderWideList.forEach(orderWide->{
            String brandIdName = vinBrandInfoMap.get(orderWide.getVin());
            if(brandIdName != null) {
                String[] brandIdNameArr = brandIdName.split(StringUtil.line);
                orderWide.setBrandId(Long.valueOf(brandIdNameArr[0]));
                orderWide.setBrandName(brandIdNameArr[1]);
                orderWide.setCityId(userIdCityIdMap.get(orderWide.getUserId()));
                String cityName = cityMap.get(String.valueOf(orderWide.getCityId()));
                orderWide.setCityName(cityName);
            }
            KafkaCanalProducer.send(KafkaTopicName.DWD_ORDER_WIDE_TOPIC, JSON.toJSONString(orderWide));
        });
    }

    private static OrderWide createOrderWide(String orderNo, Order order, OrderDetail orderDetail,
                                             Jedis jedis) {
        if(order == null) {
            String orderStr = jedis.hget(KafkaTopicName.ORDER_CACHE_KEY, orderNo);
            if(orderStr == null) {
                jedis.hset(KafkaTopicName.ORDER_CACHE_KEY, orderNo, JSON.toJSONString(orderDetail));
                return null;
            } else {
                order = JSON.parseObject(orderStr, Order.class);
            }
        } else if(orderDetail == null) {
            String orderStr = RedisClient.hget(KafkaTopicName.ORDER_DETAIL_CACHE_KEY, orderNo);
            if(orderStr == null) {
                RedisClient.hset(KafkaTopicName.ORDER_DETAIL_CACHE_KEY, orderNo, JSON.toJSONString(order));
                return null;
            } else {
                orderDetail = JSON.parseObject(orderStr, OrderDetail.class);
            }
        }
        return new OrderWide(order, orderDetail);
    }
}
