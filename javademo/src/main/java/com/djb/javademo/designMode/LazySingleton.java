package com.djb.javademo.designMode;

/**
 *  懒加载 单例
 *  使用synchronized  这个在高频率调用时，并不是最好的选择
 */
public class LazySingleton {

    public static String name;
    private LazySingleton(){
        System.out.println(" init  LazySingletion");
    }
    private static LazySingleton instance=null;
    public static synchronized  LazySingleton getInstance(){
        if (null==instance) instance= new LazySingleton();
        return instance;
    }
}
