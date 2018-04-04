package com.djb.javademo.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: djb
 * Date  2018/4/4
 */
public class AsyncMainTest {

    private  static ExecutorService executorService;
    public static ExecutorService getExecutorService(){
        if (executorService==null){
            System.out.println("   executorService ");
            executorService= Executors.newSingleThreadExecutor();
        }
        return executorService;
    }


    public static void add(int a,int b){
        System.out.println(a+b);
    }

    public static void  sub(int a,int b){
        System.out.println(a+""+b);
    }



    public static void main(String[] args) {

        System.out.println("start...........");
        int a=10,b=20;

        new Thread(()->  add( a, b)).start();
        new Thread(()-> sub( a, b)).start();
        System.out.println("end");
    }
}
