package com.djb.springdemo1.service.period;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PeriodMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PeriodConfig.class);
        BeanWayService beanWayService=context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService=context.getBean(JSR250WayService.class);
        context.close();
    }
}
