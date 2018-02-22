package com.djb.javademo.proxy.dynamicJave;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyMain {

    public static void main(String[] args) {
        //4、通过 Proxy.newProxyInstance 构建代理对象
        RealSubject realSubject=new RealSubject();
        InvocationHandler invocationHandle=new DynamicSubject(realSubject);
        Class<?> classType=invocationHandle.getClass();
        System.out.println("--  invocationHandle.getClass() ---"+classType.getName());
        Class<?> classType2=Proxy.getProxyClass(ISubject.class.getClassLoader(),new Class[]{ISubject.class});
        System.out.println("--   Proxy.getProxyClass ---"+classType2.getName());
        System.out.println(classType.equals(classType2));
        System.out.println(classType==classType2);
       // ISubject iSubject= (ISubject) Proxy.newProxyInstance(classType2.getClassLoader(),realSubject.getClass().getInterfaces(),invocationHandle);
//        System.out.println("iSubject.getClass()---"+iSubject.getClass());
//         iSubject.say();



    }

}
