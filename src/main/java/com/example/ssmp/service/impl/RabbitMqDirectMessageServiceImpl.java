package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSMP
 * @description:rabbitmq
 * @author: kangwei
 * @create: 2022-07-10 11:42
 **/
@Service
public class RabbitMqDirectMessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String orderId) {
        System.out.println("rabbit mq 生产数据");
        rabbitTemplate.convertAndSend("direct_exchange","direct_binding",orderId);
    }

    @Override
    public String getMsg() {
        return null;
    }
}
