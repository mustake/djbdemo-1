package com.djb.springdemo1.service;

import org.springframework.stereotype.Service;

@Service  //1.编写功能bean
public class FunctionService {
    public String sayParam(String param){
        return "say "+param;

    }
}
