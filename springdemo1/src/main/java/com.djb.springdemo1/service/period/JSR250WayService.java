package com.djb.springdemo1.service.period;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * jsr250 注解方式 控制bean 初始和销毁
 */
public class JSR250WayService {
    //在构造函数执行完之前执行
    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService(){
        super();
        System.out.println("初始化构造函数 --JSR250WayService");
    }

    //在Bean销毁之前执行
    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }


}
