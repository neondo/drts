package com.neon.kafka;

import com.neon.uitl.KafkaUtil;
import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

/**
 * @author Neon
 * @date 2021/5/9 17:07
 */
public class KafkaCanalProducer{

    private static org.apache.kafka.clients.producer.KafkaProducer<String, String> producer;

    public final static String TOPIC = "test5";

    private KafkaCanalProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaUtil.BROKER_LIST);//xxx服务器ip
        props.put(ProducerConfig.ACKS_CONFIG, -1);//所有follower都响应了才认为消息提交成功，即"committed"
        //retries = MAX 无限重试，直到你意识到出现了问题:)
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        //batch.size当批量的数据大小达到设定值后，就会立即发送，不顾下面的linger.ms
        //producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        //延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //producer可以用来缓存数据的内存大小。
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
    }

    public static void send() {
        int messageNo = 1;
        final int COUNT = 5;
        while(messageNo < COUNT) {
            String key = String.valueOf(messageNo);
            String data = String.format("hello KafkaProducer message %s from hubo 06291018 ", key);
            try {
                producer.send(new ProducerRecord<String, String>(TOPIC, data));
            } catch(Exception e) {
                e.printStackTrace();
            }
            messageNo++;
        }
        producer.close();
    }

    public static void send(String message) {
        try {
            producer.send(new ProducerRecord<String, String>(TOPIC, message));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
