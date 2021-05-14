/**
 *
 */

package com.neon.rtp.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;
import redis.clients.jedis.params.GeoRadiusParam;
import redis.clients.jedis.params.ZAddParams;
import redis.clients.jedis.params.ZIncrByParams;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JedisClient{

    private static JedisPool jedisClientPool;

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
        jedisClientPool = new JedisPool(jedisPoolConfig, REDIS_HOST, Integer.parseInt(REDIS_PORT));
    }

    private String prefix;

    private static final Logger logger = LoggerFactory.getLogger(JedisClient.class);

    /**
     * 实例化Redis 客户端
     *
     *            key前缀，例如：prefix：INFO-， set(key,value)时会自动在key前加上INFO-
     */

    public String getPrefix() {
        return prefix;
    }

    public Jedis getJedis() {
        return jedisClientPool.getResource();
    }

    public String getPrefixKey(String key) {
        if(prefix == null) {
            return key;
        }
        return prefix + key;
    }

    public String[] getPrefixKey(String... key) {
        if(prefix == null) {
            return key;
        }
        for(int i = 0; i < key.length; i++) {
            key[i] = getPrefixKey(key[i]);
        }
        return key;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private <T> T execute(RedisTemplate<T> template) {
        Jedis jedis = null;
        try {
            jedis = jedisClientPool.getResource();
            template.setJedis(jedis);
            return template.get();
        } finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    public static abstract class RedisTemplate<T>{

        public abstract T get();

        private Jedis jedis;

        public void setJedis(Jedis jedis) {
            this.jedis = jedis;
        }

        public Jedis getJedis() {
            return jedis;
        }
    }

    /**
     * 获取key存储的数据类型
     *
     * @param key
     * @return none (key不存在) string (字符串) list (列表) set (集合) zset (有序集) hash (哈希表)
     */
    public String type(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().type(getPrefixKey(key));
            }
        });
    }

    /**
     * 更新缓存过期时间，单位：秒 从运行该方法开始，为相应的key-value设置缓存过期时间expire 类似于memcached中的touch命令
     */
    public Long expire(final String key, final int seconds) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().expire(getPrefixKey(key), seconds);
            }
        });
    }

    /**
     * expireAt设置的时间不是能存活多久，而是固定的UNIX时间（从1970年开始算起），单位为秒。
     *
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(final String key, final long unixTime) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().expireAt(getPrefixKey(key), unixTime);
            }
        });
    }

    /**
     * 返回一个key还能活多久，单位为秒
     *
     * @param key
     * @return 如果该key本来并没有设置过期时间，则返回-1，如果该key不存在，则返回-2
     */
    public Long ttl(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().ttl(getPrefixKey(key));
            }
        });
    }

    /**
     * 只是时间单位改为毫秒。
     *
     * @param key
     * @param milliseconds
     * @return
     */
    public Long pexpire(final String key, final long milliseconds) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().pexpire(getPrefixKey(key), milliseconds);
            }
        });
    }

    public Long pexpireAt(final String key, final long millisecondsTimestamp) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().pexpireAt(getPrefixKey(key), millisecondsTimestamp);
            }
        });
    }

    public Long pttl(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().pttl(getPrefixKey(key));
            }
        });
    }

    public String psetex(final String key, final long milliseconds, final String value) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().psetex(getPrefixKey(key), milliseconds, value);
            }
        });
    }

    /**
     * 将指定key的值减少某个值
     *
     * @param key
     * @param integer
     * @return 返回减少后的新值
     */
    public Long decrBy(final String key, final long integer) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().decrBy(getPrefixKey(key), integer);
            }
        });
    }

    /**
     * 将指定Key的值减少1
     *
     * @param key
     * @return 返回减少后的新值
     */
    public Long decr(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().decr(getPrefixKey(key));
            }
        });
    }

    /**
     * 将指定的key的值增加指定的值
     *
     * @param key
     * @param integer
     * @return 返回增加后的新值
     */
    public Long incrBy(final String key, final long integer) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().incrBy(getPrefixKey(key), integer);
            }
        });
    }

    /**
     * 将指定的key的值增加指定的值(浮点数)
     *
     * @param key
     * @param value
     * @return 返回增加后的新值
     */
    public Double incrByFloat(final String key, final double value) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().incrByFloat(getPrefixKey(key), value);
            }
        });
    }

    /**
     * 将指定的key的值增加1
     *
     * @param key
     * @return 返回增加后的新值
     */
    public Long incr(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().incr(getPrefixKey(key));
            }
        });
    }

    /**
     * 如果一个key设置了过期时间，则取消其过期时间，使其永久存在。
     *
     * @param key
     * @return 返回1或者0, 1代表取消过期时间成功，0代表不成功(只有当key不存在时这种情况才会发生)
     */
    public Long persist(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().persist(getPrefixKey(key));
            }
        });
    }

    /**
     * 回显
     *
     * @param string
     * @return 回显输入的字符串
     */
    public String echo(final String string) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().echo(string);
            }
        });
    }
    // 存储String类型的数据

    /**
     * 设置缓存 类似于memcached的set，不管是否已经有相同的key，都成功
     */
    public String set(final String key, final String value) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().set(getPrefixKey(key), value);
            }
        });
    }

    public Set<String> keys(final String pattern) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().keys(pattern);
            }
        });
    }

    /**
     * 设置缓存，并指定缓存过期时间，单位是秒
     */
    public String setex(final String key, final int seconds, final String value) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().setex(getPrefixKey(key), seconds, value);
            }
        });
    }

    /**
     * 设置缓存，如果设置的key不存在，直接设置，如果key已经存在了，则什么操作都不做，直接返回 类似于memcached的add
     */
    public Long setnx(final String key, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().setnx(getPrefixKey(key), value);
            }
        });
    }

    public Long setnx(final String key, final byte[] value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().setnx(getPrefixKey(key).getBytes(), value);
            }
        });
    }

    /**
     * 从缓存中根据key取得其String类型的值，如果key不存在则返回null，如果key存在但value不是string类型的，
     * 则返回一个error。这个方法只能从缓存中取得value为string类型的值。
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().get(getPrefixKey(key));
            }
        });
    }

    public byte[] get(final byte[] key) {
        return execute(new RedisTemplate<byte[]>(){

            @Override
            public byte[] get() {
                return this.getJedis().get(getPrefixKey(new String(key)).getBytes());
            }
        });
    }

    /**
     * 检查某个key是否在缓存中存在，如果存在返回true，否则返回false；
     *
     * @param key
     * @return
     */
    public Boolean exists(final String key) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().exists(getPrefixKey(key));
            }
        });
    }

    /**
     * 删除一个Key,如果删除的key不存在，则直接忽略。
     *
     * @param key
     * @return 被删除的keys的数量
     */
    public Long del(final String key) {
        logger.info("delete redis key : {}", key);
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().del(getPrefixKey(key));
            }
        });
    }

    /**
     * 设置key的值,并返回一个旧值.如果key存在但是对应的value不是字符串，就返回错误。
     *
     * @param key
     * @param value
     * @return
     */
    public String getSet(final String key, final String value) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().getSet(getPrefixKey(key), value);
            }
        });
    }

    /**
     * 若key存在，将value追加到原有字符串的末尾。若key不存在，则创建一个新的空字符串。
     *
     * @param key
     * @param value
     * @return 返回字符串的总长度
     */
    public Long append(final String key, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().append(getPrefixKey(key), value);
            }
        });
    }

    /**
     * 返回start - end 之间的子字符串(start 和 end处的字符也包括在内)
     *
     * @param key
     * @param start
     * @param end
     * @return 返回子字符串
     */
    public String substr(final String key, final int start, final int end) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().substr(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 这个命令的作用是覆盖key对应的string的一部分，从指定的offset处开始，覆盖value的长度。 如果offset比当前key对应string还要长，
     * 那这个string后面就补0以达到offset。不存在的keys被认为是空字符串，所以这个命令可以确保key有一个足够大的字符串 能在offset处设置value。
     *
     * @param key
     * @param offset
     * @param value
     * @return 该命令修改后的字符串长度
     */
    public Long setrange(final String key, final long offset, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().setrange(getPrefixKey(key), offset, value);
            }
        });
    }

    /**
     * 获得start - end之间的子字符串，若偏移量为负数，代表从末尾开始计算，例如-1代表倒数第一个，-2代表倒数第二个
     *
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    public String getrange(final String key, final long startOffset, final long endOffset) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().getrange(getPrefixKey(key), startOffset, endOffset);
            }
        });
    }

    /**
     * 获取字符串的长度
     *
     * @param key
     * @return
     */
    public Long strlen(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().strlen(getPrefixKey(key));
            }
        });
    }
    // hashMap 的存取

    /**
     * 添加单个缓存key-value到map中 如果key不存在则先创建,如果field已经存在,返回0
     */
    public Long hset(final String key, final String field, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().hset(getPrefixKey(key), field, value);
            }
        });
    }

    /**
     * 从map中获取相应key的缓存value
     */
    public String hget(final String key, final String field) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().hget(getPrefixKey(key), field);
            }
        });
    }

    /**
     * 添加单个缓存key-value到map中 若已经存在于指定key相同的key，那么就不操作
     */
    public Long hsetnx(final String key, final String field, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().hsetnx(getPrefixKey(key), field, value);
            }
        });
    }

    /**
     * 在map中添加hash，即一次性添加多条缓存
     *
     * @param key
     * @param hash
     * @return 返回OK 异常返回null
     */
    public String hmset(final String key, final Map<String, String> hash) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().hmset(getPrefixKey(key), hash);
            }
        });
    }

    /**
     * 从map中获取多个key的value，并放在List集合中
     */
    public List<String> hmget(final String key, final String... fields) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().hmget(getPrefixKey(key), fields);
            }
        });
    }

    /**
     * 对hash中指定字段的值增加指定的值
     *
     * @param key
     * @param field
     * @param value
     * @return 返回增加后的新值
     */
    public Long hincrBy(final String key, final String field, final long value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().hincrBy(getPrefixKey(key), field, value);
            }
        });
    }

    public Double hincrByFloat(final String key, final String field, final double value) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().hincrByFloat(getPrefixKey(key), field, value);
            }
        });
    }

    /**
     * map中是否存在键为key的缓存
     */
    public Boolean hexists(final String key, final String field) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().hexists(getPrefixKey(key), field);
            }
        });
    }

    /**
     * 从map中删除多个缓存
     */
    public Long hdel(final String key, final String... fields) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().hdel(getPrefixKey(key), fields);
            }
        });
    }

    /**
     * 获取map中的key-value数
     */
    public Long hlen(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().hlen(getPrefixKey(key));
            }
        });
    }

    /**
     * 获取map中key的集合
     *
     * @param key
     * @return
     */
    public Set<String> hkeys(final String key) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().hkeys(getPrefixKey(key));
            }
        });
    }

    /**
     * 获取map中的所有key的value
     */
    public List<String> hvals(final String key) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().hvals(getPrefixKey(key));
            }
        });
    }

    /**
     * 从map中获取全部的缓存key-value对
     */
    public Map<String, String> hgetAll(final String key) {
        return execute(new RedisTemplate<Map<String, String>>(){

            @Override
            public Map<String, String> get() {
                return this.getJedis().hgetAll(getPrefixKey(key));
            }
        });
    }

    /**
     * 迭代hash里面的元素
     *
     * @param key
     * @param cursor
     * @return
     */
    public ScanResult<Entry<String, String>> hscan(final String key, final String cursor) {
        return execute(new RedisTemplate<ScanResult<Entry<String, String>>>(){

            @Override
            public ScanResult<Entry<String, String>> get() {
                return this.getJedis().hscan(getPrefixKey(key), cursor);
            }
        });
    }

    public ScanResult<Entry<String, String>> hscan(final String key, final String cursor, final ScanParams params) {
        return execute(new RedisTemplate<ScanResult<Entry<String, String>>>(){

            @Override
            public ScanResult<Entry<String, String>> get() {
                return this.getJedis().hscan(getPrefixKey(key), cursor, params);
            }
        });
    }
    // 读取List类型数据

    /**
     * 从右边（尾部）加入列表
     */
    public Long rpush(final String key, final String... strings) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().rpush(getPrefixKey(key), strings);
            }
        });
    }

    /**
     * 从左边（首部）加入列表 1、可以一次性入队n个元素（这里使用了不定参数,当然可以换做数组）
     * 2、左边入队，相当于在队头插入元素，则之后的元素都要后移一位；而右边入队的话元素直接插在队尾，之前的元素的索引不变
     *
     * @param key
     * @param strings
     * @return 返回插入后集合的size
     */
    public Long lpush(final String key, final String... strings) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().lpush(getPrefixKey(key), strings);
            }
        });
    }

    /**
     * 只有当 key 已经存在并且存着一个 list 的时候，在这个 key 下面的 list 的头部插入 value。 与 LPUSH 相反，当 key 不存在的时候不会进行任何操作。
     *
     * @param key
     * @param string
     * @return 在 push 操作后的 list 长度。
     */
    public Long lpushx(final String key, final String... string) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().lpushx(getPrefixKey(key), string);
            }
        });
    }

    /**
     * 将值 value 插入到列表 key 的表尾, 当且仅当 key 存在并且是一个列表。 和 RPUSH 命令相反, 当 key 不存在时，RPUSHX 命令什么也不做。
     *
     * @param key
     * @param string
     * @return 在Push操作后List的长度
     */
    public Long rpushx(final String key, final String... string) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().rpushx(getPrefixKey(key), string);
            }
        });
    }

    /**
     * 返回list中共有多少个元素
     */
    public Long llen(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().llen(getPrefixKey(key));
            }
        });
    }

    /**
     * 返回list指定区间[start,end]内的元素
     *
     * @param key
     * @param start
     * @param end
     *            -1 表示返回所有列表数据
     * @return
     */
    public List<String> lrange(final String key, final long start, final long end) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().lrange(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 让list只保留指定区间[start,end]内的元素，不在指定区间内的元素都将被删除
     */
    public String ltrim(final String key, final long start, final long end) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().ltrim(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 返回list中index位置的元素
     */
    public String lindex(final String key, final long index) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().lindex(getPrefixKey(key), index);
            }
        });
    }

    /**
     * 设置list中index位置的元素 index==-1表示最后一个元素
     */
    public String lset(final String key, final long index, final String value) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().lset(getPrefixKey(key), index, value);
            }
        });
    }

    /**
     * 删除list中所有与value相等的元素 注意： count ==0 ：删除表中所有与value相等的元素 >0：从表头开始向表尾搜索，移除count个与value相等的元素
     * <0：从表尾开始向表头搜索，移除count个与value相等的元素
     */
    public Long lrem(final String key, final long count, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().lrem(getPrefixKey(key), count, value);
            }
        });
    }

    /**
     * 从左边（首部）出列表
     */
    public String lpop(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().lpop(getPrefixKey(key));
            }
        });
    }

    /**
     * 从右边出列表
     */
    public String rpop(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().rpop(getPrefixKey(key));
            }
        });
    }

    /**
     * BLPOP 是阻塞式列表的弹出原语。 它是命令 LPOP 的阻塞版本，这是因为当给定列表内没有任何元素可供弹出的时候， 连接将被 BLPOP 命令阻塞。 当给定多个 key 参数时，按参数
     * key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     *
     * @param timeout
     * @param key
     * @return
     */
    public List<String> blpop(final int timeout, final String key) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().blpop(timeout, getPrefixKey(key));
            }
        });
    }

    /**
     * BRPOP 是一个阻塞的列表弹出原语。 它是 RPOP 的阻塞版本，因为这个命令会在给定list无法弹出任何元素的时候阻塞连接。 该命令会按照给出的 key 顺序查看
     * list，并在找到的第一个非空 list 的尾部弹出一个元素。
     *
     * 请在 BLPOP 文档 中查看该命令的准确语义，因为 BRPOP 和 BLPOP 基本是完全一样的，除了它们一个是从尾部弹出元素，而另一个是从头部弹出元素。
     *
     * @param timeout
     * @param key
     * @return
     */
    public List<String> brpop(final int timeout, final String key) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().brpop(timeout, getPrefixKey(key));
            }
        });
    }

    /**
     * 把 value 插入存于 key 的列表中在基准值 pivot 的前面或后面。 当 key 不存在时，这个list会被看作是空list，任何操作都不会发生。 当 key
     * 存在，但保存的不是一个list的时候，会返回error。
     *
     * @param key
     * @param where
     * @param pivot
     *            前或后
     * @param value
     * @return 在 insert 操作后的 list 长度。
     */
    public Long linsert(final String key, final ListPosition where, final String pivot, final String value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().linsert(getPrefixKey(key), where, pivot, value);
            }
        });
    }
    // 读取set无序集合

    /**
     * @param key
     * @param members
     * @return 1：添加元素成功 0：set中已经有要添加的元素了
     */
    public Long sadd(final String key, final String... members) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().sadd(getPrefixKey(key), members);
            }
        });
    }

    /**
     * 获取set集合中的所有缓存
     */
    public Set<String> smembers(final String key) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().smembers(getPrefixKey(key));
            }
        });
    }

    /**
     * 删除缓存
     *
     * @param key
     * @param members
     * @return
     */
    public Long srem(final String key, final String... members) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().srem(getPrefixKey(key), members);
            }
        });
    }

    /**
     * 移除并返回一个集合中的随机元素 该命令与 SRANDMEMBER相似,不同的是srandmember命令返回一个随机元素但是不移除.
     *
     * @param key
     * @return 被移除的元素, 当key不存在的时候返回 nil .
     */
    public String spop(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().spop(getPrefixKey(key));
            }
        });
    }

    /**
     * 移除并返回多个集合中的随机元素
     *
     * @param key
     * @param count
     * @return 被移除的元素, 当key不存在的时候值为 nil .
     */
    public Set<String> spop(final String key, final long count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().spop(getPrefixKey(key), count);
            }
        });
    }

    /**
     * 仅提供key参数,那么随机返回key集合中的一个元素.该命令作用类似于SPOP命令, 不同的是SPOP命令会将被选择的随机元素从集合中移除,
     * 而SRANDMEMBER仅仅是返回该随记元素,而不做任何操作.
     *
     * @param key
     * @return 返回随机的元素, 如果key不存在则返回nil
     */
    public String srandmember(final String key) {
        return execute(new RedisTemplate<String>(){

            @Override
            public String get() {
                return this.getJedis().srandmember(getPrefixKey(key));
            }
        });
    }

    /**
     * 如果count是整数且小于元素的个数，返回含有 count 个不同的元素的数组,如果count是个整数且大于集合中元素的个数时,仅返回整个集合的所有元素
     * ,当count是负数,则会返回一个包含count的绝对值的个数元素的数组 ，如果count的绝对值大于元素的个数,则返回的结果集里会出现一个元素出现多次的情况.
     *
     * @param key
     * @param count
     * @return 返回一个随机的元素数组, 如果key不存在则返回一个空的数组.
     */
    public List<String> srandmember(final String key, final int count) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().srandmember(getPrefixKey(key), count);
            }
        });
    }

    /**
     * 返回set集合的元素个数
     */
    public Long scard(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().scard(getPrefixKey(key));
            }
        });
    }

    /**
     * set集合是否包含value
     *
     * @param key
     * @param member
     * @return
     */
    public Boolean sismember(final String key, final String member) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().sismember(getPrefixKey(key), member);
            }
        });
    }

    /**
     * 迭代set里面的元素
     *
     * @param key
     * @param cursor
     * @return
     */
    public ScanResult<String> sscan(final String key, final String cursor) {
        return execute(new RedisTemplate<ScanResult<String>>(){

            @Override
            public ScanResult<String> get() {
                return this.getJedis().sscan(getPrefixKey(key), cursor);
            }
        });
    }

    public ScanResult<String> sscan(final String key, final String cursor, final ScanParams params) {
        return execute(new RedisTemplate<ScanResult<String>>(){

            @Override
            public ScanResult<String> get() {
                return this.getJedis().sscan(getPrefixKey(key), cursor, params);
            }
        });
    }
    // 有序集合的存取

    /**
     * 添加缓存(一个)
     *
     * @param key
     *            添加入的集合
     * @param score
     *            权重
     * @param member
     *            值
     */
    public Long zadd(final String key, final double score, final String member) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zadd(getPrefixKey(key), score, member);
            }
        });
    }

    /**
     * 该命令添加指定的成员到key对应的有序集合中，每个成员都有一个分数。你可以指定多个分数/成员组合。如果一个指定的成员已经在对应的有序集合中了， 那么其分数就会被更新成最新的
     * ，并且该成员会重新调整到正确的位置，以确保集合有序。如果key不存在，就会创建一个含有这些成员的有序集合，就好像往一个空的集合中添加一样
     * 。如果key存在，但是它并不是一个有序集合，那么就返回一个错误。 分数的值必须是一个表示数字的字符串，并且可以是double类型的浮点数。
     *
     * @param key
     * @param score
     * @param member
     * @param params
     * @return 返回添加到有序集合中元素的个数，不包括那种已经存在只是更新分数的元素。
     */
    public Long zadd(final String key, final double score, final String member, final ZAddParams params) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zadd(getPrefixKey(key), score, member, params);
            }
        });
    }

    /**
     * 添加缓存(一次可添加多个)
     *
     *            添加入的集合
     *            加入集合的元素集
     */
    public Long zadd(final String key, final Map<String, Double> scoreMembers) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zadd(getPrefixKey(key), scoreMembers);
            }
        });
    }

    public Long zadd(final String key, final Map<String, Double> scoreMembers, final ZAddParams params) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zadd(getPrefixKey(key), scoreMembers, params);
            }
        });
    }

    /**
     * 返回key内[start,end]索引的元素set 1、在sortedSet中，元素是按照score从小到大排列的， 此方法从前向后获取元素（即按元素的score从小到大排列）
     */
    public Set<String> zrange(final String key, final long start, final long end) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrange(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 删除多个缓存
     */
    public Long zrem(final String key, final String... members) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zrem(getPrefixKey(key), members);
            }
        });
    }

    /**
     * 为有序集key的成员member的score值加上增量increment。如果key中不存在member，就在key中添加一个member，
     * score是increment（就好像它之前的score是0.0）。如果key不存在，就创建一个只含有指定member成员的有序集合。 当key不是有序集类型时，返回一个错误。
     * score值必须整数值或双精度浮点数。也有可能给一个负数来减少score的值。
     *
     * @param key
     * @param score
     * @param member
     * @return member成员的新score值.
     */
    public Double zincrby(final String key, final double score, final String member) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().zincrby(getPrefixKey(key), score, member);
            }
        });
    }

    public Double zincrby(final String key, final double score, final String member, final ZIncrByParams params) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().zincrby(getPrefixKey(key), score, member, params);
            }
        });
    }

    /**
     * 返回有序集key中成员member的排名。其中有序集成员按score值递增(从小到大)顺序排列。排名以0为底，也就是说， score值最小的成员排名为0。
     * 使用ZREVRANK命令可以获得成员按score值递减(从大到小)排列的排名。
     *
     * @param key
     * @param member
     * @return 如果member是有序集key的成员，返回member的排名的整数。 如果member不是有序集key的成员，返回 nil。
     */
    public Long zrank(final String key, final String member) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zrank(getPrefixKey(key), member);
            }
        });
    }

    /**
     * 返回有序集key中成员member的排名，其中有序集成员按score值从大到小排列。排名以0为底，也就是说，score值最大的成员排名为0。
     * 使用ZRANK命令可以获得成员按score值递增(从小到大)排列的排名。
     *
     * @param key
     * @param member
     * @return 如果member是有序集key的成员，返回member的排名。整型数字。 如果member不是有序集key的成员，返回Bulk reply: nil.
     */
    public Long zrevrank(final String key, final String member) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zrevrank(getPrefixKey(key), member);
            }
        });
    }

    /**
     * 返回key集合[start, end]中的元素 1、此方法相当于从后向前取元素，即元素从大到小排列 或者相当于将key从大到小排列，然后从前向后去元素
     */
    public Set<String> zrevrange(final String key, final long start, final long end) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrange(getPrefixKey(key), start, end);
            }
        });
    }

    public Set<Tuple> zrangeWithScores(final String key, final long start, final long end) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrangeWithScores(getPrefixKey(key), start, end);
            }
        });
    }

    public Set<Tuple> zrevrangeWithScores(final String key, final long start, final long end) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrevrangeWithScores(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 获取集合sortedSet的长度
     */
    public Long zcard(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zcard(getPrefixKey(key));
            }
        });
    }

    /**
     * 获取sortedSet中的value的权重score
     */
    public Double zscore(final String key, final String member) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().zscore(getPrefixKey(key), member);
            }
        });
    }

    /**
     * 对一个集合或者一个列表排序 对集合，有序集合，或者列表的value进行排序。默认情况下排序只对数字排序，双精度浮点数。
     *
     * @param key
     * @return 假设集合或列表包含的是数字元素，那么返回的将会是从小到大排列的一个列表。
     */
    public List<String> sort(final String key) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().sort(getPrefixKey(key));
            }
        });
    }

    public List<String> sort(final String key, final SortingParams sortingParameters) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().sort(getPrefixKey(key), sortingParameters);
            }
        });
    }

    /**
     * 返回有序集key中，score值在min和max之间(默认包括score值等于min或max)的成员。
     *
     * @param key
     * @param min
     * @param max
     * @return 指定分数范围的元素个数。
     */
    public Long zcount(final String key, final double min, final double max) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zcount(getPrefixKey(key), min, max);
            }
        });
    }

    public Long zcount(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zcount(getPrefixKey(key), min, max);
            }
        });
    }

    /**
     * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。元素被认为是从低分到高分排序的。 具有相同分数的元素按字典序排列
     *
     * @param key
     * @param min
     * @param max
     * @return 指定分数范围的元素列表
     */
    public Set<String> zrangeByScore(final String key, final double min, final double max) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByScore(getPrefixKey(key), min, max);
            }
        });
    }

    /**
     * 返回key的有序集合中的分数在min和max之间的所有元素（包括分数等于max或者min的元素）。元素被认为是从低分到高分排序的。 具有相同分数的元素按字典序排列
     *
     * @param key
     * @param min
     * @param max
     * @return 指定分数范围的元素列表
     */
    public Set<String> zrangeByScore(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByScore(getPrefixKey(key), min, max);
            }
        });
    }

    public Set<String> zrangeByScore(final String key, final double min, final double max, final int offset,
                                     final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByScore(getPrefixKey(key), min, max, offset, count);
            }
        });
    }

    public Set<String> zrangeByScore(final String key, final String min, final String max, final int offset,
                                     final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByScore(getPrefixKey(key), min, max, offset, count);
            }
        });
    }

    public Set<Tuple> zrangeByScoreWithScores(final String key, final double min, final double max) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrangeByScoreWithScores(getPrefixKey(key), min, max);
            }
        });
    }

    public Set<Tuple> zrangeByScoreWithScores(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrangeByScoreWithScores(getPrefixKey(key), min, max);
            }
        });
    }

    public Set<Tuple> zrangeByScoreWithScores(final String key, final double min, final double max, final int offset,
                                              final int count) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrangeByScoreWithScores(getPrefixKey(key), min, max, offset, count);
            }
        });
    }

    public Set<Tuple> zrangeByScoreWithScores(final String key, final String min, final String max, final int offset,
                                              final int count) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrangeByScoreWithScores(getPrefixKey(key), min, max, offset, count);
            }
        });
    }

    public Set<String> zrevrangeByScore(final String key, final double max, final double min) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByScore(getPrefixKey(key), max, min);
            }
        });
    }

    public Set<String> zrevrangeByScore(final String key, final String max, final String min) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByScore(getPrefixKey(key), max, min);
            }
        });
    }

    public Set<String> zrevrangeByScore(final String key, final double max, final double min, final int offset,
                                        final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByScore(getPrefixKey(key), max, min, offset, count);
            }
        });
    }

    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final double max, final double min) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrevrangeByScoreWithScores(getPrefixKey(key), max, min);
            }
        });
    }

    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final double max, final double min, final int offset,
                                                 final int count) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrevrangeByScoreWithScores(getPrefixKey(key), max, min, offset, count);
            }
        });
    }

    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final String max, final String min, final int offset,
                                                 final int count) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrevrangeByScoreWithScores(getPrefixKey(key), max, min, offset, count);
            }
        });
    }

    public Set<String> zrevrangeByScore(final String key, final String max, final String min, final int offset,
                                        final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByScore(getPrefixKey(key), max, min, offset, count);
            }
        });
    }

    public Set<Tuple> zrevrangeByScoreWithScores(final String key, final String max, final String min) {
        return execute(new RedisTemplate<Set<Tuple>>(){

            @Override
            public Set<Tuple> get() {
                return this.getJedis().zrevrangeByScoreWithScores(getPrefixKey(key), max, min);
            }
        });
    }

    /**
     * 删除指定范围（按照索引，包前包后）的缓存
     */
    public Long zremrangeByRank(final String key, final long start, final long end) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zremrangeByRank(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 删除指定范围（按照分数，包前包后）的缓存
     */
    public Long zremrangeByScore(final String key, final double start, final double end) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zremrangeByScore(getPrefixKey(key), start, end);
            }
        });
    }

    public Long zremrangeByScore(final String key, final String start, final String end) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zremrangeByScore(getPrefixKey(key), start, end);
            }
        });
    }

    /**
     * 当插入到有序集合中的元素都具有相同的分数时，这个命令可以返回min和max指定范围内的元素的数量。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zlexcount(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zlexcount(getPrefixKey(key), min, max);
            }
        });
    }

    public Set<String> zrangeByLex(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByLex(getPrefixKey(key), min, max);
            }
        });
    }

    public Set<String> zrangeByLex(final String key, final String min, final String max, final int offset,
                                   final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrangeByLex(getPrefixKey(key), min, max, offset, count);
            }
        });
    }

    public Set<String> zrevrangeByLex(final String key, final String max, final String min) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByLex(getPrefixKey(key), max, min);
            }
        });
    }

    public Set<String> zrevrangeByLex(final String key, final String max, final String min, final int offset,
                                      final int count) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().zrevrangeByLex(getPrefixKey(key), max, min, offset, count);
            }
        });
    }

    public Long zremrangeByLex(final String key, final String min, final String max) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().zremrangeByLex(getPrefixKey(key), min, max);
            }
        });
    }

    /**
     * 迭代zset里面的元素
     *
     * @param key
     * @param cursor
     * @return
     */
    public ScanResult<Tuple> zscan(final String key, final String cursor) {
        return execute(new RedisTemplate<ScanResult<Tuple>>(){

            @Override
            public ScanResult<Tuple> get() {
                return this.getJedis().zscan(getPrefixKey(key), cursor);
            }
        });
    }

    public ScanResult<Tuple> zscan(final String key, final String cursor, final ScanParams params) {
        return execute(new RedisTemplate<ScanResult<Tuple>>(){

            @Override
            public ScanResult<Tuple> get() {
                return this.getJedis().zscan(getPrefixKey(key), cursor, params);
            }
        });
    }

    /**
     * 设置或者清除指定key的value上的某个位置的比特位，如果该key原先不存在，则新创建一个key，其value将会自动分配内存， 直到可以放下指定位置的bit值。
     *
     * @param key
     * @param offset
     * @param value
     *            true代表1，false代表0
     * @return 返回原来位置的bit值是否是1，如果是1，则返回true，否则返回false。
     */
    public Boolean setbit(final String key, final long offset, final boolean value) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().setbit(getPrefixKey(key), offset, value);
            }
        });
    }

    public Boolean setbit(final String key, final long offset, final String value) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().setbit(getPrefixKey(key), offset, value);
            }
        });
    }

    /**
     * 取得偏移量为offset的bit值。
     *
     * @param key
     * @param offset
     * @return true代表1，false代表0
     */
    public Boolean getbit(final String key, final long offset) {
        return execute(new RedisTemplate<Boolean>(){

            @Override
            public Boolean get() {
                return this.getJedis().getbit(getPrefixKey(key), offset);
            }
        });
    }

    public Long bitpos(final String key, final boolean value) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().bitpos(getPrefixKey(key), value);
            }
        });
    }

    public Long bitpos(final String key, final boolean value, final BitPosParams params) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().bitpos(getPrefixKey(key), value, params);
            }
        });
    }

    public void close() {
    }

    public Long geoadd(final String key, final double longitude, final double latitude, final String member) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().geoadd(getPrefixKey(key), longitude, latitude, member);
            }
        });
    }

    public Long geoadd(final String key, final Map<String, GeoCoordinate> memberCoordinateMap) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().geoadd(getPrefixKey(key), memberCoordinateMap);
            }
        });
    }

    public Double geodist(final String key, final String member1, final String member2) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().geodist(getPrefixKey(key), member1, member2);
            }
        });
    }

    public Double geodist(final String key, final String member1, final String member2, final GeoUnit unit) {
        return execute(new RedisTemplate<Double>(){

            @Override
            public Double get() {
                return this.getJedis().geodist(getPrefixKey(key), member1, member2, unit);
            }
        });
    }

    public List<String> geohash(final String key, final String... members) {
        return execute(new RedisTemplate<List<String>>(){

            @Override
            public List<String> get() {
                return this.getJedis().geohash(getPrefixKey(key), members);
            }
        });
    }

    public List<GeoCoordinate> geopos(final String key, final String... members) {
        return execute(new RedisTemplate<List<GeoCoordinate>>(){

            @Override
            public List<GeoCoordinate> get() {
                return this.getJedis().geopos(getPrefixKey(key), members);
            }
        });
    }

    public List<GeoRadiusResponse> georadius(final String key, final double longitude, final double latitude,
                                             final double radius,
                                             final GeoUnit unit) {
        return execute(new RedisTemplate<List<GeoRadiusResponse>>(){

            @Override
            public List<GeoRadiusResponse> get() {
                return this.getJedis().georadius(getPrefixKey(key), longitude, latitude, radius, unit);
            }
        });
    }

    public List<GeoRadiusResponse> georadius(final String key, final double longitude, final double latitude,
                                             final double radius,
                                             final GeoUnit unit, final GeoRadiusParam param) {
        return execute(new RedisTemplate<List<GeoRadiusResponse>>(){

            @Override
            public List<GeoRadiusResponse> get() {
                return this.getJedis().georadius(getPrefixKey(key), longitude, latitude, radius, unit, param);
            }
        });
    }

    public List<GeoRadiusResponse> georadiusByMember(final String key, final String member, final double radius,
                                                     final GeoUnit unit) {
        return execute(new RedisTemplate<List<GeoRadiusResponse>>(){

            @Override
            public List<GeoRadiusResponse> get() {
                return this.getJedis().georadiusByMember(getPrefixKey(key), member, radius, unit);
            }
        });
    }

    public List<GeoRadiusResponse> georadiusByMember(final String key, final String member, final double radius,
                                                     final GeoUnit unit,
                                                     final GeoRadiusParam param) {
        return execute(new RedisTemplate<List<GeoRadiusResponse>>(){

            @Override
            public List<GeoRadiusResponse> get() {
                return this.getJedis().georadiusByMember(getPrefixKey(key), member, radius, unit, param);
            }
        });
    }

    public List<Long> bitfield(final String key, final String... arguments) {
        return execute(new RedisTemplate<List<Long>>(){

            @Override
            public List<Long> get() {
                return this.getJedis().bitfield(getPrefixKey(key), arguments);
            }
        });
    }

    /**
     * 统计字符串的字节数
     *
     * @param key
     * @return 字节数
     */
    public Long bitcount(final String key) {
        return execute(new RedisTemplate<Long>(){

            @Override
            public Long get() {
                return this.getJedis().bitcount(key);
            }
        });
    }

    public Set<String> sinter(final String... keys) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().sinter(getPrefixKey(keys));
            }
        });
    }

    public Set<String> sdiff(final String... keys) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().sdiff(getPrefixKey(keys));
            }
        });
    }

    public Set<String> sunion(final String... keys) {
        return execute(new RedisTemplate<Set<String>>(){

            @Override
            public Set<String> get() {
                return this.getJedis().sunion(getPrefixKey(keys));
            }
        });
    }
}
