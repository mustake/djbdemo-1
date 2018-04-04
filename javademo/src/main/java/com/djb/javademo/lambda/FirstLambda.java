package com.djb.javademo.lambda;

public class FirstLambda {

    public static void main(String[] args) {
        testRunnable();
        runable();
    }
    public static void testRunnable(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");

            }
        }).start();
    }

    public static void runable() {
        new Thread(() -> System.out.println("lambda test")).start();
    }

}
