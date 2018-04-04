package com.djb.javademo.redissonUtil;

import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;

/**
 * @authot Administrator
 * @date 28
 */
public class RedissonQueueTest {

    public static void main(String[] args) {
        RedissonClient redisson=RedissonUtil.getRedissonClient();
        for (int i=0;i<10;i++) {
            //创建队列
            RDeque<String> deque = redisson.getDeque("myQueue");
            if (i==0){
                deque.clear();
            }

            deque.add("1");
            deque.add("2");
            deque.add("3");
            deque.add("4");
            RDeque<String> dequetemp = redisson.getDeque("myQueue");
            //System.out.println(i+"--"+dequetemp.pollFirst());
            System.out.println(i+"--"+dequetemp.poll());
        }

        redisson.shutdown();

    }
}
