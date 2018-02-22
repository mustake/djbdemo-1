package com.djb.javademo.proxy.dynamicJave;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *  3.定义代理角色
 *     代理角色要实现 InvocationHandler接口
 */
public class DynamicSubject implements InvocationHandler {

    private  Object object;

    public DynamicSubject(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("in DynamicSubject, before invocation");

        Object ret = method.invoke(object, args);  //执行被代理类方法

        System.out.println("in DynamicSubject, after invocation");
        return ret;
    }

}
