package com.neon.rtp.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis客户端
 * @author Neon
 * @date 2018/6/14 11:42
 */
public class RedisClient{

    private static final Logger logger = LoggerFactory.getLogger(RedisClient.class);

    private static final JedisClient redisClient = new JedisClient();

    private static final String packageName = "com.chaboshi.tools.backend.util";

    /**
     * <p>通过key获取储存在redis中的value</p>
     * <p>并释放连接</p>
     * @return 成功返回value 失败返回null
     */
    public static Object get(String key) {
        try {
            String value = redisClient.get(key);
            if(value != null && !NumberUtil.isNumeric(value)) {
                return deserializeToObject(value);
            }
            return value;
        } catch(Exception e) {
            logger.error("redis value get error,key:{}", key, e);
        }
        return null;
    }

    public static Jedis getJedis() {
        return redisClient.getJedis();
    }

    public static <T> T get(String key, Class<T> clazz) {
        Object value = get(key);
        if(value != null) {
            if(!NumberUtil.NUM_TYPE.contains(clazz.getSimpleName())) {
                return (T) value;
            } else {
                return NumberUtil.transfer2numberType(value.toString(), clazz);
            }
        }
        return null;
    }

    public static <T> T get(String key, CacheCallback<T> cacheCallback, int seconds) {
        Object result = get(key);
        if(result != null) {
            if(logger.isDebugEnabled()) {
                logger.debug("hit cache, cacheKey : " + key);
            }
            return (T) result;
        }
        if(logger.isDebugEnabled()) {
            logger.debug("miss hit cache, cacheKey : " + key);
        }
        result = cacheCallback.get();
        if(result != null) {
            set(key, result, seconds);
        }
        return result != null ? (T) result : null;
    }

    public static <T> T get(String key, CacheCallback<T> cacheCallback) {
        Object result = get(key);
        if(result != null) {
            if(logger.isDebugEnabled()) {
                logger.debug("hit cache, cacheKey : " + key);
            }
            return (T) result;
        }
        if(logger.isDebugEnabled()) {
            logger.debug("miss hit cache, cacheKey : " + key);
        }
        result = cacheCallback.get();
        if(result != null) {
            set(key, result, (int) TimeUnit.MINUTES.toSeconds(30));
        }
        return (T) result;
    }

    /**
     * <p>向redis存入key和value,并释放连接资源</p>
     * <p>如果key已经存在 则覆盖</p>
     * @return 成功 返回OK 失败返回 0
     */
    public static Boolean set(String key, Object value, int seconds) {
        try {
            String msg = redisClient.set(key, serializeToString(value));
            redisClient.expire(key, seconds);
            return "OK".equalsIgnoreCase(msg);
        } catch(Exception e) {
            logger.error("redis set error value:{}!", value, e);
        }
        return false;
    }

    public static Boolean set(String key, Object value) {
        return set(key, value, (int) TimeUnit.MINUTES.toSeconds(30));
    }

    /**
     * 更新缓存过期时间，单位：秒 从运行该方法开始，为相应的key-value设置缓存过期时间expire 类似于memcached中的touch命令
     */
    public static Long expire(String key, int value) {
        return redisClient.expire(key, value);
    }

    public static Long pexpire(String key, long milliseconds) {
        return redisClient.pexpire(key, milliseconds);
    }

    /**
     * <p>删除指定的key,也可以传入一个包含key的数组</p>
     * @param key 一个key  也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public static Long del(String key) {
        return redisClient.del(key);
    }

    public static ScanResult<Entry<String, String>> hscan(String key, String cursor) {
        return redisClient.hscan(key, cursor);
    }

    public static ScanResult<Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        return redisClient.hscan(key, cursor, params);
    }

    private static String contact(String sign, Object... o) {
        StringBuilder str = new StringBuilder();
        for(Object temp : o) {
            str.append(sign).append(temp);
        }
        return str.toString().replaceFirst(sign, "");
    }

    /**
     * 以下划线"_"连接
     * @param o 对象数组
     * @see this#deleteKeys(String)
     * @see this#deleteKeys(String, String)
     */
    public static String generateKey(Object... o) {
        return RedisClient.contact("_", o);
    }

    /**
     * @param o 以{@code o[0] }生成Key的前缀,并作为后缀与{@code packageName}连接作为新的key值,将生成的key作为value进行标记,以便在删除时一次性
     * @see this#generateKey(Object...)
     * @see this#deleteKeys(String)
     * @see this#deleteKeys(String, String)
     */
    public static String signKey(Object... o) {
        Object prefix = o[0];
        String contact = RedisClient.generateKey(o);
        RedisClient.sadd(packageName + prefix, contact);
        return contact;
    }

    /**
     * @param prefix  需要删除的所有Key的集合的key值
     * @param pattern 匹配正则
     * @see this#signKey(Object...)
     */
    public static long deleteKeys(String prefix, String pattern) {
        String key = packageName + prefix;
        Boolean exists = RedisClient.exists(key);
        long i = 0;
        if(exists) {
            ScanParams params = new ScanParams();
            params.count(1000);
            params.match(pattern);
            ScanResult<String> set = RedisClient.sscan(key, ScanParams.SCAN_POINTER_START, params);
            if(set != null && Check.notNull(set.getResult())) {
                for(String k : set.getResult()) {
                    RedisClient.srem(key, k);
                    i += RedisClient.del(k);
                }
            }
        }
        return i;
    }

    public static long deleteKeys(String prefix) {
        String key = packageName + prefix;
        Boolean exists = RedisClient.exists(key);
        long i = 0;
        if(exists) {
            Set<String> smembers = RedisClient.smembers(key);
            if(Check.notNull(smembers)) {
                for(String k : smembers) {
                    i += RedisClient.del(k);
                }
            }
            RedisClient.del(key);
        }
        return i;
    }

    /**
     * 返回一个key还能活多久，单位为秒
     * @return 如果该key本来并没有设置过期时间，则返回-1，如果该key不存在，则返回-2
     */
    public static Long ttl(String key) {
        return redisClient.ttl(key);
    }

    public static Set<String> keys(String pattern) {
        return redisClient.keys(pattern);
    }

    /**
     * <p>通过key向指定的value值追加值</p>
     * @return 成功返回 添加后value的长度 失败 返回 添加的 value 的长度  异常返回0L
     */
    public static Long append(String key, String str) {
        return redisClient.append(key, str);
    }

    /**
     * <p>判断key是否存在</p>
     * @return true OR false
     */
    public static Boolean exists(String key) {
        return redisClient.exists(key);
    }

    /**
     * <p>设置key value,如果key已经存在则返回0,nx==> not exist</p>
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public static Long setnx(String key, String value) {
        return redisClient.setnx(key, value);
    }

    /**
     * <p>设置key value并制定这个键值的有效期</p>
     * @param seconds 单位:秒
     * @return 成功返回OK 失败和异常返回null
     */
    public static String setex(String key, String value, int seconds) {
        return redisClient.setex(key, seconds, value);
    }

    /**
     * <p>通过key 和offset 从指定的位置开始将原先value替换</p>
     * <p>下标从0开始,offset表示从offset下标开始替换</p>
     * <p>如果替换的字符串长度过小则会这样</p>
     * <p>example:</p>
     * <p>value : bigsea@zto.cn</p>
     * <p>str : abc </p>
     * <P>从下标7开始替换  则结果为</p>
     * <p>RES : bigsea.abc.cn</p>
     * @param offset 下标位置
     * @return 返回替换后  value 的长度
     */
    public static Long setrange(String key, String str, int offset) {
        return redisClient.setrange(key, offset, str);
    }

    /**
     * <p>通过批量的key获取批量的value</p>
     * @param keys string数组 也可以是一个key
     * @return 成功返回value的集合, 失败返回null的集合 ,异常返回空
     */
    public static List<String> hmget(String... keys) {
        return redisClient.hmget("", keys);
    }
    /**
     * <p>批量的设置key:value,可以一个,如果key已经存在则会失败,操作会回滚</p>
     * <p>example:</p>
     * <p>  obj.msetnx(new String[]{"key2","value1","key2","value2"})</p>
     * @param keysvalues
     * @return 成功返回1 失败返回0
     */
   /* public static Long msetnx(String... keysvalues) {
        return redisClient.set(keysvalues);O

    }*/

    /**
     * <p>批量的设置key:value,可以一个</p>
     * <p>example:</p>
     * <p>  obj.mset(new String[]{"key2","value1","key2","value2"})</p>
     * @return 成功返回OK 失败 异常 返回 null
     */
    public static String mset(String key, Map<String, String> keysvalues) {
        return redisClient.hmset(key, keysvalues);
    }

    /**
     * <p>设置key的值,并返回一个旧值</p>
     * @return 旧值 如果key不存在 则返回null
     */
    public static String getset(String key, String value) {
        return redisClient.getSet(key, value);
    }

    /**
     * <p>通过下标 和key 获取指定下标位置的 value</p>
     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
     * @return 如果没有返回null
     */
    public static String getrange(String key, int startOffset, int endOffset) {
        return redisClient.getrange(key, startOffset, endOffset);
    }

    /**
     * <p>通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1</p>
     * @return 加值后的结果
     */
    public static Long incr(String key) {
        return redisClient.incr(key);
    }

    /**
     * <p>通过key给指定的value加值,如果key不存在,则这是value为该值</p>
     */
    public static Long incrBy(String key, Long integer) {
        return redisClient.incrBy(key, integer);
    }

    /**
     * <p>对key的值做减减操作,如果key不存在,则设置key为-1</p>
     */
    public static Long decr(String key) {
        return redisClient.decr(key);
    }

    /**
     * <p>减去指定的值</p>
     */
    public static Long decrBy(String key, Long integer) {
        return redisClient.decrBy(key, integer);
    }

    /**
     * <p>通过key获取value值的长度</p>
     * @return 失败返回null
     */
    public static Long serlen(String key) {
        return redisClient.strlen(key);
    }

    /**
     * <p>通过key给field设置指定的值,如果key不存在,则先创建</p>
     * @param field 字段
     * @return 如果存在返回0 异常返回null
     */
    public static Long hset(String key, String field, String value) {
        return redisClient.hset(key, field, value);
    }

    /**
     * <p>通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0</p>
     */
    public static Long hsetnx(String key, String field, String value) {
        return redisClient.hsetnx(key, field, value);
    }

    /**
     * <p>通过key同时设置 hash的多个field</p>
     * @return 返回OK 异常返回null
     */
    public static String hmset(String key, Map<String, String> hash) {
        return redisClient.hmset(key, hash);
    }

    /**
     * <p>通过key 和 field 获取指定的 value</p>
     * @return 没有返回null
     */
    public static String hget(String key, String field) {
        return redisClient.hget(key, field);
    }

    /**
     * <p>通过key 和 field 获取指定的 value</p>
     */
    public static <T> T hget(String key, String field, CacheCallback<T> cacheCallback) {
        Object result = hget(key, field);
        if(result != null) {
            if(logger.isDebugEnabled()) {
                logger.debug("hit cache, cacheKey : " + key);
            }
            return (T) result;
        }
        if(logger.isDebugEnabled()) {
            logger.debug("miss hit cache, cacheKey : " + key);
        }
        result = cacheCallback.get();
        if(result != null) {
            hset(key, field, String.valueOf(result));
        }
        return (T) result;
    }

    /**
     * <p>通过key 和 fields 获取指定的value 如果没有对应的value则返回null</p>
     * @param fields 可以使 一个String 也可以是 String数组
     */
    public static List<String> hmget(String key, String... fields) {
        return redisClient.hmget(key, fields);
    }

    /**
     * <p>通过key给指定的field的value加上给定的值</p>
     */
    public static Long hincrby(String key, String field, Long value) {
        return redisClient.hincrBy(key, field, value);
    }

    /**
     * <p>通过key和field判断是否有指定的value存在</p>
     */
    public static Boolean hexists(String key, String field) {
        return redisClient.hexists(key, field);
    }

    /**
     * <p>通过key返回field的数量</p>
     */
    public static Long hlen(String key) {
        return redisClient.hlen(key);
    }

    /**
     * <p>通过key 删除指定的 field </p>
     * @param fields 可以是 一个 field 也可以是 一个数组
     */
    public static Long hdel(String key, String... fields) {
        return redisClient.hdel(key, fields);
    }

    /**
     * <p>通过key返回所有的field</p>
     */
    public static Set<String> hkeys(String key) {
        return redisClient.hkeys(key);
    }

    /**
     * <p>通过key返回所有和key有关的value</p>
     */
    public static List<String> hvals(String key) {
        return redisClient.hvals(key);
    }

    /**
     * <p>通过key获取所有的field和value</p>
     */
    public static Map<String, String> hgetAll(String key) {
        return redisClient.hgetAll(key);
    }

    /**
     * <p>通过key向list头部添加字符串</p>
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public static Long lpush(String key, String... strs) {
        return redisClient.lpush(key, strs);
    }

    /**
     * <p>通过key向list尾部添加字符串</p>
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public static Long rpush(String key, String... strs) {
        return redisClient.rpush(key, strs);
    }

    /**
     * <p>通过key在list指定的位置之前或者之后 添加字符串元素</p>
     * @param where LIST_POSITION枚举类型
     * @param pivot list里面的value
     * @param value 添加的value
     */
    public static Long linsert(String key, ListPosition where,
                               String pivot, String value) {
        return redisClient.linsert(key, where, pivot, value);
    }

    /**
     * <p>通过key设置list指定下标位置的value</p>
     * <p>如果下标超过list里面value的个数则报错</p>
     * @param index 从0开始
     * @return 成功返回OK
     */
    public static String lset(String key, Long index, String value) {
        return redisClient.lset(key, index, value);
    }

    /**
     * <p>通过key从对应的list中删除指定的count个 和 value相同的元素</p>
     * @param count 当count为0时删除全部
     * @return 返回被删除的个数
     */
    public static Long lrem(String key, long count, String value) {
        return redisClient.lrem(key, count, value);
    }

    /**
     * <p>通过key保留list中从strat下标开始到end下标结束的value值</p>
     * @return 成功返回OK
     */
    public static String ltrim(String key, long start, long end) {
        return redisClient.ltrim(key, start, end);
    }

    /**
     * <p>通过key从list的头部删除一个value,并返回该value</p>
     */
    synchronized public static String lpop(String key) {
        return redisClient.lpop(key);
    }

    /**
     * BLPOP 是阻塞式列表的弹出原语。 它是命令 LPOP 的阻塞版本，这是因为当给定列表内没有任何元素可供弹出的时候， 连接将被 BLPOP 命令阻塞。 当给定多个 key 参数时，按参数
     * key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。 {@link  ://www.redis.cn/commands/blpop.html}
     */
    synchronized public static List<String> blpop(int timeout, String key) {
        return redisClient.blpop(timeout, key);
    }

    /**
     * BRPOP 是一个阻塞的列表弹出原语。 它是 RPOP 的阻塞版本，因为这个命令会在给定list无法弹出任何元素的时候阻塞连接。 该命令会按照给出的 key 顺序查看
     * list，并在找到的第一个非空 list 的尾部弹出一个元素。
     * 请在 BLPOP 文档 中查看该命令的准确语义，因为 BRPOP 和 BLPOP 基本是完全一样的，除了它们一个是从尾部弹出元素，而另一个是从头部弹出元素。 {@link
     * ://www.redis.cn/commands/brpop.html}
     */
    synchronized public static List<String> brpop(int timeout, String key) {
        return redisClient.brpop(timeout, key);
    }

    /**
     * <p>通过key从list尾部删除一个value,并返回该元素</p>
     */
    synchronized public static String rpop(String key) {
        return redisClient.rpop(key);
    }

    /**
     * <p>通过key获取list中指定下标位置的value</p>
     * @return 如果没有返回null
     */
    public static String lindex(String key, long index) {
        return redisClient.lindex(key, index);
    }

    /**
     * <p>通过key返回list的长度</p>
     */
    public static Long llen(String key) {
        return redisClient.llen(key);
    }

    /**
     * <p>通过key获取list指定下标位置的value</p>
     * <p>如果start 为 0 end 为 -1 则返回全部的list中的value</p>
     */
    public static List<String> lrange(String key, long start, long end) {
        return redisClient.lrange(key, start, end);
    }

    /**
     * <p>通过key向指定的set中添加value</p>
     * @param members 可以是一个String 也可以是一个String数组
     * @return 添加成功的个数
     */
    public static Long sadd(String key, String... members) {
        return redisClient.sadd(key, members);
    }

    /**
     * <p>通过key删除set中对应的value值</p>
     * @param members 可以是一个String 也可以是一个String数组
     * @return 删除的个数
     */
    public static Long srem(String key, String... members) {
        return redisClient.srem(key, members);
    }

    /**
     * <p>通过key随机删除一个set中的value并返回该值</p>
     */
    public static String spop(String key) {
        return redisClient.spop(key);
    }

    /**
     * <p>通过key获取set中value的个数</p>
     */
    public static Long scard(String key) {
        return redisClient.scard(key);
    }

    /**
     * <p>通过key判断value是否是set中的元素</p>
     */
    public static Boolean sismember(String key, String member) {
        return redisClient.sismember(key, member);
    }

    /**
     * <p>通过key获取set中随机的value,不删除元素</p>
     */
    public static String srandmember(String key) {
        return redisClient.srandmember(key);
    }

    /**
     * <p>通过key获取set中所有的value</p>
     */
    public static Set<String> smembers(String key) {
        return redisClient.smembers(key);
    }

    /**
     * <p>通过key向zset中添加value,score,其中score就是用来排序的</p>
     * <p>如果该value已经存在则根据score更新元素</p>
     */
    public static Long zadd(String key, double score, String member) {
        return redisClient.zadd(key, score, member);
    }

    /**
     * <p>通过key删除在zset中指定的value</p>
     * @param members 可以使一个string 也可以是一个string数组
     */
    public static Long zrem(String key, String... members) {
        return redisClient.zrem(key, members);
    }

    /**
     * <p>通过key增加该zset中value的score的值</p>
     */
    public static Double zincrby(String key, double score, String member) {
        return redisClient.zincrby(key, score, member);
    }

    /**
     * <p>通过key返回zset中value的排名</p>
     * <p>下标从小到大排序</p>
     */
    public static Long zrank(String key, String member) {
        return redisClient.zrank(key, member);
    }

    /**
     * <p>通过key返回zset中value的排名</p>
     * <p>下标从大到小排序</p>
     */
    public static Long zrevrank(String key, String member) {
        return redisClient.zrevrank(key, member);
    }

    /**
     * <p>通过key将获取score从start到end中zset的value</p>
     * <p>socre从大到小排序</p>
     * <p>当start为0 end为-1时返回全部</p>
     */
    public static Set<String> zrevrange(String key, long start, long end) {
        return redisClient.zrevrange(key, start, end);
    }

    /**
     * <p>通过key返回指定score内zset中的value</p>
     */
    public static Set<String> zrangebyscore(String key, String max, String min) {
        return redisClient.zrevrangeByScore(key, max, min);
    }

    /**
     * <p>通过key返回指定score内zset中的value</p>
     */
    public static Set<String> zrangeByScore(String key, double max, double min) {
        return redisClient.zrevrangeByScore(key, max, min);
    }

    /**
     * <p>返回指定区间内zset中value的数量</p>
     */
    public static Long zcount(String key, String min, String max) {
        return redisClient.zcount(key, min, max);
    }

    /**
     * <p>通过key返回zset中的value个数</p>
     */
    public static Long zcard(String key) {
        return redisClient.zcard(key);
    }

    /**
     * <p>通过key获取zset中value的score值</p>
     */
    public static Double zscore(String key, String member) {
        return redisClient.zscore(key, member);
    }

    /**
     * <p>通过key删除给定区间内的元素</p>
     */
    public static Long zremrangeByRank(String key, long start, long end) {
        return redisClient.zremrangeByRank(key, start, end);
    }

    /**
     * <p>通过key删除指定score内的元素</p>
     */
    public static Long zremrangeByScore(String key, double start, double end) {
        return redisClient.zremrangeByScore(key, start, end);
    }

    /**
     * <p>通过key判断值得类型</p>
     */
    public static String type(String key) {
        return redisClient.type(key);
    }

    public static ScanResult<String> sscan(String key, String cursor) {
        return redisClient.sscan(key, cursor);
    }

    public static ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        return redisClient.sscan(key, cursor, params);
    }

    public static ScanResult<Tuple> zscan(String key, String cursor) {
        return redisClient.zscan(key, cursor);
    }

    public static ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        return redisClient.zscan(key, cursor, params);
    }

    /**
     * 对一个集合或者一个列表排序 对集合，有序集合，或者列表的value进行排序。默认情况下排序只对数字排序，双精度浮点数。
     * @return 假设集合或列表包含的是数字元素，那么返回的将会是从小到大排列的一个列表。
     */
    public static List<String> sort(String key) {
        return redisClient.sort(key);
    }

    public static List<String> sort(String key, SortingParams sortingParameters) {
        return redisClient.sort(key, sortingParameters);
    }

    //序列化
    public static String serializeToString(Object obj) throws Exception {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(obj);
        return byteOut.toString("ISO-8859-1");
    }

    //反序列化
    public static Object deserializeToObject(String str) throws Exception {
        ByteArrayInputStream byteIn = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        ObjectInputStream objIn = new ObjectInputStream(byteIn);
        return objIn.readObject();
    }

    public static int day(int n) {
        return (int) java.util.concurrent.TimeUnit.DAYS.toSeconds(n);
    }

    public static int hour(int n) {
        return (int) TimeUnit.HOURS.toSeconds(n);
    }

    public static int min(int n) {
        return (int) TimeUnit.MINUTES.toSeconds(n);
    }
}
