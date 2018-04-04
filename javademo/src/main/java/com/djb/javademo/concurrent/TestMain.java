package com.djb.javademo.concurrent;

/**
 * @authot Administrator
 * @date 27
 */
public class TestMain {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("test");
                }
            }).start();
        }
    }
}
