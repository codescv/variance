package com.codescv.example.variance;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by czzha on 12/19/16.
 */
public class JedisTest {
    public static void main(String[] args) {
        Set<HostAndPort> hostAndPorts = new HashSet<>(Arrays.asList(
                new HostAndPort("a",123),
                new HostAndPort("bb", 123)));

        JedisCluster c = new JedisCluster(hostAndPorts);
        c.set("key", "val");

    }
}
