package com.djb.javademo.thread1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 初始一个字符串，使用十个线程去修改这个字符串，其中只有一个线程能成功，其他都是失败
 */
public class AtomicReferenceDemo {

    public final static AtomicReference<String> atomicStr = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int)Math.random()*100));//让程序随机休眠，保证竞争
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (atomicStr.compareAndSet("abc", "edf")) {
                        System.out.println(Thread.currentThread().getName() + " true  "+atomicStr);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " false "+atomicStr);
                    }
                }
            }.start();
        }


    }


}
