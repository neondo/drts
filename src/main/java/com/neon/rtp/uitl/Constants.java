package com.neon.rtp.uitl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Neon
 * @date 2021/5/9 16:05
 */
public class Constants{

    private final static Properties PROPERTIES = new Properties();

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        try {
            PROPERTIES.load(new FileInputStream("kafka.properties"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public interface KafkaTopicName{

        String ORDER_DETAIL_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_",
                ORDER_PREVENT_REPLICATE_CACHE_KEY = "ORDER_PREVENT_REPLICATE_CACHE_KEY",
                ORDER_CACHE_KEY = "ORDER_WIDE_APP_FULL_JOIN_KEY_ORDER_TAIL_";

        String ODS_ORDER_TOPIC = "ODS_ORDER_TOPIC",
                ODS_ORDER_DETAIL_TOPIC = "ODS_ORDER_DETAIL_TOPIC",
                DWD_ORDER_WIDE_TOPIC = "DWD_ORDER_WIDE_TOPIC";
    }

    public interface KafkaGroupName{

        String CONSUMER_GROUP = "REAL_TIME_PANEL";
    }

    public interface RedisKeyName{

        String CONSUMER_GROUP = "REAL_TIME_PANEL";

        String CITY_MAP = "CITY_MAP";

        String ORDER_STATISTIC_ORDER_TYPE_0_1_STATUS_10001 = "ORDER_STATISTIC_ORDER_TYPE_0_1_STATUS_10001";

        String ORDER_STATISTIC_ORDER_TYPE_0_1_TOTAL = "ORDER_STATISTIC_ORDER_TYPE_0_1_TOTAL";
    }
}
