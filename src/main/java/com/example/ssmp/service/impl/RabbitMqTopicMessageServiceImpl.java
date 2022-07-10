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
public class RabbitMqTopicMessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String orderId) {
        System.out.println("rabbit mq topic 生产数据");
//        topic_binding.orders.orderId topic_binding.users.orderId
        rabbitTemplate.convertAndSend("topic_exchange","topic_binding.orders.orderId",orderId);
    }

    @Override
    public String getMsg() {
        return null;
    }
}
