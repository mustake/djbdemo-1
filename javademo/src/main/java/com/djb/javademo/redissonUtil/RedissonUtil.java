package com.djb.javademo.redissonUtil;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * @authot Administrator
 * @date 28
 */
public class RedissonUtil {

    private final static String REDIS_HOST="192.168.0.174";
    private final static String REDIS_PORT="7393";
    private final static String REDIS_PASSWORD="sz73go";
    private final static String REDIS_TIMEOUT="50";

    private static RedissonClient redissonClient;

    public static  RedissonClient getRedissonClient() {
        if (redissonClient==null){
            Config config = new Config();
            SingleServerConfig serverConfig = config.useSingleServer();
            serverConfig.setAddress("redis://" + REDIS_HOST + ":" + REDIS_PORT);
            serverConfig.setTimeout(Integer.parseInt(REDIS_TIMEOUT));// 30秒强行解锁，防止死锁
            serverConfig.setPassword(REDIS_PASSWORD);
            redissonClient = Redisson.create(config);
        }
        return redissonClient;
    }

    public static void shutDown(){
        redissonClient.shutdown();
    }


}
