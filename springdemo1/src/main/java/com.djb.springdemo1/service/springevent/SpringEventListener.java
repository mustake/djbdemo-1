package com.djb.springdemo1.service.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
@Component
public class SpringEventListener implements ApplicationListener<SpringBeanEvent>{
   //1.实现 applicationListener  指定监听类型 SpringBeanEvent
    //2.重写 onApplicationEvent   处理消息
    @Override
    public void onApplicationEvent(SpringBeanEvent event) {
        String msg=event.getMsg();
        System.out.println("我  listener 接收到了 publisher 发布的消息 msg:"+msg);

    }
}
