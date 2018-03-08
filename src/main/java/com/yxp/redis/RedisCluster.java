package com.yxp.redis;

import org.testng.annotations.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisCluster {

    private static final String[]  CLUSTERS = {
        "127.0.0.1:6380",
        "127.0.0.1:6381",
        "127.0.0.1:6382",
        "127.0.0.1:6383",
        "127.0.0.1:6384",
        "127.0.0.1:6385"
    };

    //jedis连接redis集群
    @Test
    public void testClusters() throws IOException {
        Set<HostAndPort> jedisClustersNodes = new HashSet<HostAndPort>();
        for (String cluster : CLUSTERS){
            String[] clusterNode = cluster.split(":");
            jedisClustersNodes.add(new HostAndPort(clusterNode[0], Integer.valueOf(clusterNode[1])));
        }
        //启动集群
        JedisCluster jedisCluster = new JedisCluster(jedisClustersNodes);
        jedisCluster.set("cluster-key0308", "cluster0308");
        jedisCluster.get("cluster-key0308");
        jedisCluster.close();
    }
}
