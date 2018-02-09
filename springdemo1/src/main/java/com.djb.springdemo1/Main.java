package com.djb.springdemo1;

import com.djb.springdemo1.config.Diconfig;
import com.djb.springdemo1.service.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //使用AnnotationConfigApplicationContext作为spring容易，接受一个配置类作为参数
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Diconfig.class);
        //获取bean
        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("di"));
        //关闭容器
        context.close();


    }


}
