package com.djb.springdemo1.service.javabean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 申明配置类
 */
@Configuration
public class JavaConfig {
    //在配置里面声明所有的bean   这里不需要配置扫描路径，所有的bean都在这个配置类里

    @Bean    //bean的名称是方法名
    public JFunctionService jFunctionService(){
        return  new JFunctionService();
    }
    @Bean
    public JUseFunctionService jUseFunctionService(){
        JUseFunctionService jUseFunctionService=new JUseFunctionService();
        jUseFunctionService.setjFunctionService(jFunctionService());
        return  jUseFunctionService;
    }

}
