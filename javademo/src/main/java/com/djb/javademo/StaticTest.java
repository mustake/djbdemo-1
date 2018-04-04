package com.djb.javademo;

public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static
    {
        b=11;
       // System.out.println(b);   类变量 可以再定义前赋值，但是不能再定义前引用 ，否则会报非法前向引用
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest(){
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
