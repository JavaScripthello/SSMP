package com.example.ssmp.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @program: SSMP
 * @description: mq监听
 * @author: kangwei
 * @create: 2022-07-09 22:46
 **/
@Component
public class ActiveMqListener {

    /**
     * 从orders中取出来
     * 在sentTo other
     * @param orderId
     * @return
     */
    @JmsListener(destination = "orders")
    @SendTo("orders.other")
    public String reviceMqMsg(String orderId){
        System.out.println("从队列中监听"+orderId);
        return null;
    }


}
