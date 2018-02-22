package com.djb.javademo.proxy.dynamicJave;

/**
 * 2.定义真实角色
 */
public class RealSubject  implements  ISubject{
    @Override
    public void say() {
        System.out.println("my realSubject");

    }
}
