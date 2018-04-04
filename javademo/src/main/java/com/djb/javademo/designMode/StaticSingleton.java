package com.djb.javademo.designMode;

public class StaticSingleton {

    private StaticSingleton(){
        System.out.println(" init StaticSingleton");
    }
    private static class SingletonHolder{
        public SingletonHolder(){
            System.out.println(" init SingletonHolder");
        }
        private static StaticSingleton instance=new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
            return SingletonHolder.instance;
    }
}
