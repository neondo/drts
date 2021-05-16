package com.neon.rtp.uitl;

import com.neon.rtp.model.OrderWide;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.util.List;
import java.util.Properties;

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

    public static <T> void clickHouseBatchInsert(List<T> list) {
        SparkSession session = SparkSession.builder().appName("insert-clickhouse").getOrCreate();
        T t = list.get(0);
        String simpleName = t.getClass().getSimpleName();
        Dataset<Row> dataFrame = session.createDataFrame(list, OrderWide.class);
        dataFrame.write().mode(SaveMode.Append)
                .option("batchSize", "1000")
                .option("isolation", "NONE")
                .option("numPartitions", "4")
                .option("driver", "ru.yandex.clickhouse.ClickHouseDriver")
                .jdbc("jdbc:clickhouse://neon.com/dw_www", simpleName, new Properties());
    }
}
