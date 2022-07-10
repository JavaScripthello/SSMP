package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: SSMP
 * @description: kafka消息队列
 * @author: kangwei
 * @create: 2022-07-10 20:27
 **/
@Service
public class KafKaMessageServiceImpl implements MessageService {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Override
    public void sendMsg(String orderId) {

        System.out.println("生产消息kafka"+orderId);
        kafkaTemplate.send("kafka_topic",orderId);
    }

    @Override
    public String getMsg() {
        return null;
    }
}
