package com.djb.springdemo1.service.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.djb.springdemo1.service.aop")
@EnableAspectJAutoProxy  //开启spring对 Aspect的支持
public class AopConfig {


}
