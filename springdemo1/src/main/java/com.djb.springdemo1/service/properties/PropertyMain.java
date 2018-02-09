package com.djb.springdemo1.service.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PropertyMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ELconfig.class);
        ELconfig eLconfig=context.getBean(ELconfig.class);
        eLconfig.outputResource();
        context.close();
    }
}
