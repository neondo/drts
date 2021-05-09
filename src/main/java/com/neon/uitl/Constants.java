package com.neon.uitl;

import java.io.FileInputStream;
import java.io.FileReader;
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
}
