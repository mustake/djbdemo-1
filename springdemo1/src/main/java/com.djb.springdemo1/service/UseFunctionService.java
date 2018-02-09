package com.djb.springdemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service//3.在申明一个功能bean
public class UseFunctionService {
    @Autowired  //2.引入功能bean
    FunctionService functionService;

    public String sayHello(String hello){
        return functionService.sayParam(hello);
    }
}
