package com.djb.springredis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: djb
 * Date  2018/5/30
 */
@RestController
public class LoginController {

    @RequestMapping("login")
    public String login(){

        return "";
    }

}
