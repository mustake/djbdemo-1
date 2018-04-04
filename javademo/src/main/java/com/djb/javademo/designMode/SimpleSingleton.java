package com.djb.javademo.designMode;

/**
 * 简单单例
 *  如果调用了系统的静态属性或者其他静态方法，这个类也会被初始化出来
 */
public class SimpleSingleton {
    private static SimpleSingleton instance=new SimpleSingleton();

    public  static  String name;
    private SimpleSingleton(){
        System.out.println(" init SimpleSingleton");
    }
    public static SimpleSingleton getInstance() {
        System.out.println("  get  SimpleSingletion");
        return instance;
    }
}
