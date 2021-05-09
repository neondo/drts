package com.neon.uitl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;

/**
 * @author Neon
 * @date 2021/5/9 16:11
 */
public class RedisClient{

    private static JedisPool jedisPool;

    private static final String REDIS_HOST = Constants.getProperty("redis.host"), REDIS_PORT = Constants
            .getProperty("redis.port");

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);//最大连接数
        jedisPoolConfig.setMaxIdle(20);//最大空闲
        jedisPoolConfig.setMinIdle(20);
        //最小空闲
        jedisPoolConfig.setBlockWhenExhausted(true);
        //忙碌时是否等待jedisPoolConfig.setMaxWaitMillis (5000)//忙碌时等待时长毫秒jedisPoolConfig.setTestonBorrow (true)/ /每次获得连接的进行测试
        jedisPool = new JedisPool(jedisPoolConfig, REDIS_HOST, Integer.parseInt(REDIS_PORT));
    }

    private static Jedis getClient() {
        return jedisPool.getResource();
    }

    private static void close(Jedis jedis) {
        jedis.close();
    }

    public static String get(String key) {
        Jedis client = getClient();
        String s = client.get(key);
        close(client);
        return s;
    }

    public static Map<String, String> hgetAll(String key) {
        return getClient().hgetAll(key);
    }

    public static String hget(String key, String field) {
        return getClient().hget(key, field);
    }

    public static Long hset(String key, String field, String value) {
        return getClient().hset(key, field, value);
    }

    public static Long sadd(String key, String... value) {
        return getClient().sadd(key, value);
    }

    public static Long srem(String key, String... value) {
        return getClient().srem(key, value);
    }

    public static Long scard(String key) {
        return getClient().scard(key);
    }

    public static Set<String> smembers(String key) {
        return getClient().smembers(key);
    }

    public static Long hset(String key, Map<String, String> val) {
        return getClient().hset(key, val);
    }

    public static String set(String key, String value) {
        return getClient().set(key, value);
    }

    public static long expire(String key, int value) {
        return getClient().expire(key, value);
    }

    public static boolean set(String key, String value, int seconds) {
        getClient().set(key, value);
        expire(key, seconds);
        return true;
    }
}
