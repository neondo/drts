package com.neon.rtp.algorithm;

import com.neon.rtp.uitl.CollectUtil;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Neon
 * @date 2021/5/16 13:07
 */
public class FileW{

    public static void main(String[] args) {
        SparkConf sc = new SparkConf();
        sc.set("spark.streaming.kafka.maxRatePerPartition", "5");
        sc.setAppName("TEST").setMaster("local[*]");
        System.setProperty("hadoop.home.dir", "E:\\Program Files\\hadoop");
        sc.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        sc.set("spark.ui.port", "4042");
        String s1 = "file:///E:/project/Idea/RTP/src/main/resources/data/order.txt";
        JavaSparkContext sparkContext = new JavaSparkContext(sc);
        JavaRDD<String> stringRDD = sparkContext.textFile(s1, 2);
        long count = stringRDD.mapPartitions(v1->{
            List<Tuple2<String, List<String>>> result = new ArrayList<>();
            v1.forEachRemaining(s->{
                String[] split = s.split("\\t");
                String element = CollectUtil.getElement(split, 0);
                result.add(new Tuple2<>(element, Arrays.asList(split)));
            });
            return result.iterator();
        }).count();
        System.out.println(count);
    }
}
