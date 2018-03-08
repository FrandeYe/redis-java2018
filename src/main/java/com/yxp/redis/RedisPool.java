package com.yxp.redis;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    @Test
    public void testRedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setTestWhileIdle(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379, 10*1000);
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(new JedisPubSubImpl(), "channel0");
        jedis.close();
    }
}
