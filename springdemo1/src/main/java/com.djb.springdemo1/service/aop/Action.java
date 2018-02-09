package com.djb.springdemo1.service.aop;

import java.lang.annotation.*;

/**
 * 编写拦截规则注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
