package com.djb.springdemo1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 配置扫描路径
 */
@Configuration
@ComponentScan(value ="com.djb.springdemo1")
public class Diconfig {

}
