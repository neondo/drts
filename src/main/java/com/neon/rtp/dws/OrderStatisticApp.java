package com.neon.rtp.dws;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neon.rtp.entity.Order;
import com.neon.rtp.entity.OrderDetail;
import com.neon.rtp.kafka.producer.KafkaCanalProducer;
import com.neon.rtp.model.OrderInfo;
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
 * @date 2021/5/15 15:10
 */

/**
 * @author Neon
 * @date 2021/5/14 11:50
 */
public class OrderStatisticApp{

    private static OrderWideService orderWideService = new OrderWideServiceImpl();

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
        Map<TopicPartition, Long> orderOffsetMap = KafkaUtil
                .getOffsetMap(KafkaTopicName.DWD_ORDER_WIDE_TOPIC, KafkaGroupName.CONSUMER_GROUP);
        //获取订单流
        JavaInputDStream<ConsumerRecord<String, String>> orderDirectStream = KafkaUtil
                .createDirectStream(ssc, KafkaTopicName.DWD_ORDER_WIDE_TOPIC,
                        KafkaGroupName.CONSUMER_GROUP, orderOffsetMap);
        List<OffsetRange> offsetList = new ArrayList<>();
        orderDirectStream.foreachRDD(rdd->{
            OffsetRange[] offsetRanges = ((HasOffsetRanges) rdd).offsetRanges();
            offsetList.addAll(Arrays.asList(offsetRanges));
            rdd.foreachPartition(partition->{
                List<OrderInfo> orderInfoList = new ArrayList<>();
                partition.forEachRemaining(sr->{
                    String value = sr.value();
                    OrderInfo orderInfo = JSON.parseObject(value, OrderInfo.class);
                    String brandName = orderInfo.getBrandName();
                    String orderType = orderInfo.getOrderType();
                    RedisClient.hincrby(RedisKeyName.ORDER_STATISTIC_ORDER_TYPE_0_1_STATUS_10001,
                            StringUtil.concat_(orderType, brandName), 1L);
                    RedisClient.hincrby(RedisKeyName.ORDER_STATISTIC_ORDER_TYPE_0_1_TOTAL,
                            StringUtil.concat_(orderType, brandName), 1L);
                    orderInfoList.add(orderInfo);
                });
                JdbcPoolUtil.batchInsert(orderInfoList);
            });
            KafkaUtil.saveOffset(KafkaTopicName.DWD_ORDER_WIDE_TOPIC, KafkaGroupName.CONSUMER_GROUP, offsetList);
        });
        SparkUtil.start(ssc);
    }
}
