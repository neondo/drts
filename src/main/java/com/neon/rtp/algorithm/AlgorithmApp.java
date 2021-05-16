package com.neon.rtp.algorithm;

import com.neon.rtp.uitl.CollectUtil;
import com.neon.rtp.uitl.SparkUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import javax.management.StandardEmitterMBean;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Neon
 * @date 2021/5/15 22:29
 */
public class AlgorithmApp{

    public static void main(String[] args) {
        SparkConf sc = new SparkConf();
        sc.set("spark.streaming.kafka.maxRatePerPartition", "5");
        sc.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        sc.set("spark.ui.port", "4042");
        sc.setMaster("local[2]").setAppName("ALGORITHM_TEST");
        System.setProperty("hadoop.home.dir", "E:\\Program Files\\hadoop");
        JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(5));
        ssc.checkpoint("./test");
        JavaSparkContext javaSparkContext = ssc.sparkContext();
        javaSparkContext.setLogLevel("WARN");
        String s1 = "file:///E:/project/Idea/RTP/src/main/resources/data";
        JavaDStream<String> txtStream = ssc
                .socketTextStream("localhost", 9991);
        JavaPairDStream<String, List<String>> stream = txtStream.mapToPair(s->{
            String[] split = s.split("\\t");
            String element = CollectUtil.getElement(split, 0);
            return new Tuple2<>(element, Arrays.asList(split));
        }).reduceByKey((v1, v2)->CollectUtil.addAll(v1, v2));
        stream.print();
        //ssc.start();
        SparkUtil.start(ssc);
    }
}
