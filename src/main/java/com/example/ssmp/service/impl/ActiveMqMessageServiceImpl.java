package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: SSMP
 * @description: activemq
 * @author: kangwei
 * @create: 2022-07-09 22:42
 **/
//@Service
public class ActiveMqMessageServiceImpl implements MessageService {

    @Autowired(required = false)
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMsg(String orderId) {
        System.out.println("模拟生产短信"+orderId);
       jmsTemplate.convertAndSend(orderId);
    }


    @Override
    public String getMsg() {
        String orderId = (String) jmsTemplate.receiveAndConvert(String.valueOf(String.class));
        System.out.println("模拟发送短信"+orderId);
        return orderId;
    }
}
