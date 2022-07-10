package com.example.ssmp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: SSMP
 * @description: rabbitmq 监听
 * @author: kangwei
 * @create: 2022-07-10 11:43
 **/
//@Component
public class RabbitMqTopicListener {

    @RabbitListener(queues = "{topic_queue}")
    public String receiveRabbitMqMsg(String orderId) {
        System.out.println("rabbit mq 消费数据:" + orderId);
        return "";
    }

    @RabbitListener(queues = "{topic_queue2}")
    public String receiveRabbitMqMsg2(String orderId) {
        System.out.println("rabbit mq 22消费数据:" + orderId);
        return "";
    }
}
