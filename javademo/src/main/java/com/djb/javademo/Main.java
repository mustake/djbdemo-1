package com.djb.javademo;

import com.djb.javademo.test.TestStringFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static LinkedList linkedList;
    static {
        linkedList=new LinkedList();
        for (int i=0;i<10;i++)
            linkedList.add(i);

        System.out.println("初始化");
    }


    public static void main(String[] args) {
      /*  LinkedList<Integer> list=linkedList;
        for (int i: list) {
            System.out.println("i:"+i);
        }*/
        StringBuilder sb=new StringBuilder("54");
        sb.insert(sb.length()-1, ".");
        System.out.println(sb.toString());
    }
}
