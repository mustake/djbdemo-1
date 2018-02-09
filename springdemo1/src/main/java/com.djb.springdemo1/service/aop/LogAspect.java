package com.djb.springdemo1.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 编写切面
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.djb.springdemo1.service.aop.Action)")
    public void annotationPointCut(){};

   @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("after   注解式拦截:"+action.name());


    }

    @Before("execution(* com.djb.springdemo1.service.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        System.out.println("before  方法式拦截："+method.getName());
    }

/*
    @Around("annotationPointCut()")
    public void around(JoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();
        Method method=methodSignature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println(" around    测试环绕通知："+action.name());
    }
*/

}
