package com.djb.springdemo1.service.javabean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        JUseFunctionService jUseFunctionService=context.getBean(JUseFunctionService.class);
        System.out.println(jUseFunctionService.sayWorld("javaconfig"));
        context.close();
    }


}
