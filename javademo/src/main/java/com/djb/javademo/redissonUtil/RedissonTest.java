package com.djb.javademo.redissonUtil;

import org.redisson.Redisson;
import org.redisson.api.RDeque;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * @authot Administrator
 * @date 27
 */
public class RedissonTest {

    private final static String REDIS_HOST="192.168.0.174";
    private final static String REDIS_PORT="7393";
    private final static String REDIS_PASSWORD="sz73go";
    private final static String REDIS_TIMEOUT="50";


    private static RedissonClient redissonClient;

    private static RedissonClient getRedissonLocker() {
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


    private static Collection<String> getCollection(String peekLast) {
        int start = 0;
        if (peekLast!=null) {
            start = Integer.parseInt(peekLast) + 1;
        }
        Collection<String> collection = new ArrayList<String>();
        for (int i = 1; i <= 500; i++) {
            start++;
            collection.add("" + start);

        }
        return collection;
    }

    private static void clearRedis(String type) {
        String substring = type.substring(5, 13);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = sdf.parse(substring);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date time = calendar.getTime();
            String key = type.substring(0, 5) + sdf.format(time);
            RDeque<String> deque = redissonClient.getDeque(key);
            deque.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getOrderNo(String type) {
        String orderNo = null;
        RLock lock=null;
        RDeque<String> deque=null;
       try {
           //获取队列  这个是 类型加时间，也就是说  第一次获取的总是为空
            deque =redissonClient.getDeque(type);
            orderNo=deque.poll();
            if(deque==null){
                //添加 或者是每天第一次
                System.out.println("deque is nulll");
            }
            lock=redissonClient.getLock("testOrderNoLock");
            orderNo = deque.poll();
            // 判断队列剩余订单数量大小
            if (orderNo==null) {
                // 清除昨天redis缓存
                clearRedis(type);
                String maxSerial = "1";
                Collection<String> collection = getCollection(maxSerial);
                orderNo = maxSerial;
                deque.addAll(collection);

            } else {
                int size = deque.size();
                if (size < 50) {
                    String peekLast = deque.peekLast();
                    Collection<String> collection = getCollection(peekLast);
                    deque.addAll(collection);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            if (lock!=null){
                lock.unlock();
            }

        }
        return orderNo;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currTime = sdf.format(new Date());
           String type="testt"+currTime;
        redissonClient= getRedissonLocker();
        for (int i=0;i<5;i++){
            new Thread(new Runnable(){

                @Override
                public void run() {

                    System.out.println(getOrderNo(type));

                }
            } ).start();
        }
        if (redissonClient==null){
            System.out.println("redissonClient is null");
        }else {
            redissonClient.shutdown();
        }

    }


}
