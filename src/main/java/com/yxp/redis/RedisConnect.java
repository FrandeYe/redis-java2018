package com.yxp.redis;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

public class RedisConnect {
    //jedis连接redis
    @Test
    public void testJedis(){
        Jedis jedis = new Jedis();
        System.out.println(jedis.get("stringkey_0"));
        System.out.println(jedis.hget("hashkey", "field_0"));
    }
}
