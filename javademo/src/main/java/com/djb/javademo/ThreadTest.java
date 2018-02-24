package com.djb.javademo;

public class ThreadTest {
    static {
        //new ThreadTest();
        System.out.println("static");
    }

    public  ThreadTest(){
        System.out.println("constructor");
    }
    public static void  add(){
        System.out.println(" method static");
    }
    public void print(){
        System.out.println("1111");
    }
}
class ThreadTestMain{
    public static void main(String[] args) {
        ThreadTest.add();
        ThreadTest threadTest=new ThreadTest();
        threadTest.print();

    }
}
