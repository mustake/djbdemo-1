package com.djb.springdemo1.service.period;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value="com.djb.springdemo1.service.period")
public class PeriodConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return  new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return  new  JSR250WayService();
    }
}
