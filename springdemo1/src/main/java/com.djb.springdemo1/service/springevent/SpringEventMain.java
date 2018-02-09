package com.djb.springdemo1.service.springevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringEventMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringEventConfig.class);
        SpringEventPublisher publisher=context.getBean(SpringEventPublisher.class);
        publisher.publish("启动事件发布，发布消息");
        context.close();


    }
}
