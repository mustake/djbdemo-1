package com.djb.springdemo1.service.springevent;

import org.springframework.context.ApplicationEvent;

/**
 *  spring bean  事件
 */
//继承 applicationEvent
public class SpringBeanEvent extends ApplicationEvent {

    private static final long serialVersionUID = -2159547735562868322L;
    private String msg;

    public SpringBeanEvent(Object source,String msg){
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
