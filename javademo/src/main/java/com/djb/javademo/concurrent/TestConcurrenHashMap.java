package com.djb.javademo.concurrent;

import java.util.HashMap;
import java.util.UUID;

public class TestConcurrenHashMap {

    public static void main(String[] args) throws InterruptedException {

        final HashMap<String,String> hashMap=new HashMap<>(2);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            hashMap.put(UUID.randomUUID().toString(),"");
                        }
                    },"test:"+i).start();

                }
            }
        },"test");
        thread.start();
        thread.join();



    }


}
