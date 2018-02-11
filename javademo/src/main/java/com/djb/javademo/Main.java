package com.djb.javademo;

import com.djb.javademo.test.TestStringFactory;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static LinkedList linkedList;
    static {
        linkedList=new LinkedList();
        for (int i=0;i<10;i++)
            linkedList.add(i);

        System.out.println("初始化");
    }


    public static void main(String[] args) {
        LinkedList<Integer> list=linkedList;
        for (int i: list) {
            System.out.println("i:"+i);
        }

    }
}
