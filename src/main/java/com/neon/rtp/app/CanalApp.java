package com.neon.rtp.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neon.uitl.KafkaUtil;
import com.neon.uitl.SparkUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.rdd.RDD;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.HasOffsetRanges;
import org.apache.spark.streaming.kafka010.OffsetRange;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Neon
 * @date 2021/5/9 14:45
 */
public class CanalApp{

    public static void main(String[] args) {
        String topic = "canal_t_order", topic_order = "canal_t_order_", groupId = "real_time_panel", appName = "ods_canal_kafka";
        JavaStreamingContext ssc = SparkUtil.getStreamingContext(appName);
        Map<TopicPartition, Long> offsetMap = KafkaUtil.getOffsetMap(topic, groupId);
        JavaInputDStream<ConsumerRecord<String, String>> directStream = KafkaUtil
                .createDirectStream(ssc, topic, groupId, offsetMap);
        //保存offset
        List<OffsetRange> offsetRanges = new ArrayList<>();
        JavaDStream<ConsumerRecord<String, String>> dStream = directStream.transform(v1->{
            OffsetRange[] a = ((HasOffsetRanges) v1.rdd()).offsetRanges();
            offsetRanges.addAll(Arrays.asList(a));
            return v1;
        });
        JavaDStream<ConsumerRecord<String, String>> dStreamFilter = dStream.filter(v1->{
            String value = v1.value();
            JSONObject json = JSON.parseObject(value);
            String type = json.getString("type");
            return "7".equals(type);
        });
        JavaDStream<JSONObject> map = dStreamFilter.map(v1->{
            //订单类型
            String value = v1.value();
            //总数
            return new JSONObject();
        });
        dStreamFilter.foreachRDD((v1, v2)->KafkaUtil.saveOffset(topic, groupId, offsetRanges));
        SparkUtil.start(ssc);
    }
}
