package com.djb.springdemo1.service.period;

/**
 * 使用@Bean 控制bean 初始和销毁
 */
public class BeanWayService {
    public void  init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("初始化构造函数  -  BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
