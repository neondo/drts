package com.neon.rtp.uitl;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * @author Neon
 * @date 2021/5/9 21:29
 */
public class SparkUtil{

    public static JavaStreamingContext getStreamingContext(String appName) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName(appName);
        sparkConf.setMaster("local[*]");
        return new JavaStreamingContext(sparkConf, Durations.seconds(1));
    }

    public static void start(JavaStreamingContext ssc) {
        ssc.start();
        try {
            ssc.awaitTermination();
        } catch(InterruptedException e) {
            throw new OperateException(e);
        }
    }
}
