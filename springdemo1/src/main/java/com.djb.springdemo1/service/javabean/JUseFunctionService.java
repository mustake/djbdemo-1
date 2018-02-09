package com.djb.springdemo1.service.javabean;

public class JUseFunctionService {

    //java配置bean
    JFunctionService jFunctionService;
     //java方式注入需要的bean
    public void setjFunctionService(JFunctionService jFunctionService) {
        this.jFunctionService = jFunctionService;
    }

    public String sayWorld(String world){
        return jFunctionService.sayHello(world);
    }
}
