package com.djb.javademo.test;

public class TestStringFactory {

     private volatile StringFactory stringFactory;
     public  StringFactory getStringFactory(){
         return  stringFactory;
     }

}
