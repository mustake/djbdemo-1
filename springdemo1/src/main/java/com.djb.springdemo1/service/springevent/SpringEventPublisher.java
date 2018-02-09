package com.djb.springdemo1.service.springevent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布者
 */
@Component
public class SpringEventPublisher {

    //1.注入applicationContext用来发布事件
    //2. 使用ApplicationContext  的publishEvent 方法来发布
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        applicationContext.publishEvent(new SpringBeanEvent(this,msg));
    }

}
