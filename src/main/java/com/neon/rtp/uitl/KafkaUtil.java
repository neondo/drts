package com.neon.rtp.uitl;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.apache.spark.streaming.kafka010.OffsetRange;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Neon
 * @date 2021/5/9 14:45
 */
public class KafkaUtil{

    public final static String BROKER_LIST = Constants.getProperty("broker.list");

    public final static String OFFSET_KEY_FORMAT = "kafka_offset_topic_%s_groupId_%s";

    public static JavaInputDStream<ConsumerRecord<String, String>> createDirectStream(JavaStreamingContext ssc,
                                                                                      String topic,
                                                                                      String groupId,
                                                                                      Map<TopicPartition, Long> offset) {
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);//多个可用ip可用","隔开
        kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, false);//"auto.offset.reset"
        kafkaParams.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        if(offset == null)
            offset = Collections.emptyMap();
        return KafkaUtils.createDirectStream(
                ssc,
                LocationStrategies.PreferConsistent(),
                ConsumerStrategies.Subscribe(Collections.singletonList(topic), kafkaParams, offset)
        );
    }

    public static Map<TopicPartition, Long> getOffsetMap(String topic, String groupId) {
        String key = String.format(OFFSET_KEY_FORMAT, topic, groupId);
        Map<String, String> offsetSourceMap = RedisClient.hgetAll(key);
        Map<TopicPartition, Long> offsetMap = new HashMap<>();
        offsetSourceMap.forEach((partition, offset)->offsetMap
                .put(new TopicPartition(topic, Integer.parseInt(partition)), Long.parseLong(offset)));
        return offsetMap;
    }

    public static void saveOffset(String topic, String groupId, List<OffsetRange> offsetRanges) {
        String key = String.format(OFFSET_KEY_FORMAT, topic, groupId);
        Map<String, String> offsetMap = CollectUtil
                .toMap(offsetRanges, os->String.valueOf(os.partition()), os->String.valueOf(os.untilOffset()));
        RedisClient.hmset(key, offsetMap);
    }
}
