package com.djb.javademo.thread1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不是 synchronized ，使用 AtomicInteger 来做线程安全操作
 */
public class AtomicIntegerDemo {
    static AtomicInteger i=new AtomicInteger();
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for (int k=0;k<10000;k++){
                i.incrementAndGet();//每次加1
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts=new Thread[10];
        for (int k=0;k<10;k++){
           ts[k]=new Thread(new AddThread());
            //ts[k]=new AddThread();
        }
        for (int k=0;k<10;k++){ts[k].start();}
        for (int k=0;k<10;k++){ts[k].join();} //这句的意思就是让主线程等待子线程执行完毕
        //Thread.sleep(1000);
        System.out.println(i);
    }



}
