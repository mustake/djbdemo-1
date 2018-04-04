package com.djb.javademo.collection;

import com.djb.javademo.thread1.SynchronizedDemoOne;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    //最简单的将 hashMap编程线程安全的方式
    /*public static Map map= Collections.synchronizedMap(new HashMap());


   HashMap hashMap;
   BlockingQueue blockingQueue;

    ConcurrentHashMap concurrentHashMap;*/

    public static void main(String[] args) {
   /*     double a=0.1,b=3,c=0.3;

        Double da=new Double(a),db=new Double(b),dc=new Double(c);
        System.out.println(a*b);
        System.out.println(a*b==c);

        double	bd	=	10d;
        System.out.println(da*db);
        System.out.println(da*db==dc);
        Double ab=da*db;
        System.out.println(ab);
        System.out.println(dc);
        System.out.println(ab.compareTo(dc));*/

        Integer a = 1000  , b = 1000;
        Integer c = 100   , d = 100;
        System.out.println(a==b);
        System.out.println(c==d);


    }

}
