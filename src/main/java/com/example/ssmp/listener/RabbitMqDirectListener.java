package com.example.ssmp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @program: SSMP
 * @description: rabbitmq 监听
 * @author: kangwei
 * @create: 2022-07-10 11:43
 **/
//@Component
public class RabbitMqDirectListener {

    @RabbitListener(queues = "{direct_queue}")
    public String receiveRabbitMqMsg(String orderId){
        System.out.println("rabbit mq 消费数据:"+orderId);
        return "";
    }
}
