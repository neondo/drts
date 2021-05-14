package com.neon.rtp.dws;

import com.alibaba.fastjson.JSON;
import com.neon.rtp.entity.Order;
import com.neon.rtp.entity.OrderDetail;
import com.neon.rtp.model.OrderWide;
import com.neon.rtp.uitl.KafkaUtil;
import com.neon.rtp.uitl.RedisClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.HasOffsetRanges;
import org.apache.spark.streaming.kafka010.OffsetRange;
import redis.clients.jedis.Jedis;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Neon
 * @date 2021/5/14 11:50
 */
public class OrderWideApp{

    private final static String ORDER_DETAIL_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_",
            ORDER_PREVENT_REPLICATE_CACHE_KEY = "ORDER_PREVENT_REPLICATE_CACHE_KEY",
            ORDER_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_";

    public static void main(String[] args) {
        String topicOrderDetail = "topic_order_detail", topicOrder = "topicOrder", groupId = "group_rtp";
        SparkConf sparkConf = new SparkConf();
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
        Map<TopicPartition, Long> orderOffsetMap = KafkaUtil.getOffsetMap(topicOrder, groupId);
        //获取订单流
        JavaInputDStream<ConsumerRecord<String, String>> orderDirectStream = KafkaUtil.createDirectStream(ssc, "dwd_", "rtp_dwd", orderOffsetMap);
        //获取订单详情流
        Map<TopicPartition, Long> orderDetailOffsetMap = KafkaUtil.getOffsetMap(topicOrderDetail, groupId);
        JavaInputDStream<ConsumerRecord<String, String>> orderDetailDirectStream = KafkaUtil
                .createDirectStream(ssc, topicOrderDetail, groupId, orderDetailOffsetMap);
        //读取offset
        List<OffsetRange> newOrderOffsetList = new ArrayList<>();
        JavaDStream<ConsumerRecord<String, String>> orderTransformStream = orderDirectStream.transform(rdd->{
            OffsetRange[] offsetRanges = ((HasOffsetRanges) rdd).offsetRanges();
            newOrderOffsetList.addAll(Arrays.asList(offsetRanges));
            return rdd;
        });
        List<OffsetRange> newOrderDetailOffsetList = new ArrayList<>();
        JavaDStream<ConsumerRecord<String, String>> orderDetailTransformStream = orderDetailDirectStream.transform(rdd->{
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
                        if(order == null) {
                            String orderStr = jedis.hget(ORDER_CACHE_KEY, orderNo);
                            if(orderStr == null) {
                                jedis.hset(ORDER_CACHE_KEY, orderNo, JSON.toJSONString(orderDetail));
                                return;
                            } else {
                                order = JSON.parseObject(orderStr, Order.class);
                            }
                        } else if(orderDetail == null) {
                            String orderStr = RedisClient.hget(ORDER_DETAIL_CACHE_KEY, orderNo);
                            if(orderStr == null) {
                                RedisClient.hset(ORDER_DETAIL_CACHE_KEY, orderNo, JSON.toJSONString(order));
                                return;
                            } else {
                                orderDetail = JSON.parseObject(orderStr, OrderDetail.class);
                            }
                        }
                        OrderWide orderWide = new OrderWide(order, orderDetail);
                        buffer.append(",").append(orderWide.getVin());
                        orderWideList.add(orderWide);
                    });
                    jedis.close();
                    String vinStrArr = buffer.toString().substring(1);
                    return orderWideList.iterator();
                });
        //save to rds mysql
        orderWideStream.foreachRDD((rdd)->{
            SparkSession sparkSession = SparkSession
                    .builder().appName("Java Spark SQL basic example").config("spark.some.config.option", "some-value").getOrCreate();
            Dataset<Row> load = sparkSession.read()
                    .format("jdbc")
                    .option("url", "jdbc:postgresql:dbserver")
                    .option("dbtable", "schema.tablename")
                    .option("user", "username")
                    .option("password", "password")
                    .load();
        });
    }
}
