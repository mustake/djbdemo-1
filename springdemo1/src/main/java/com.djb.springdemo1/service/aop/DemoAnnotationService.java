package com.djb.springdemo1.service.aop;

import org.springframework.stereotype.Service;

/**
 * 使用注解的被拦截类
 */
@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){
        System.out.println("类名"+this.getClass().getName());
    }
}
