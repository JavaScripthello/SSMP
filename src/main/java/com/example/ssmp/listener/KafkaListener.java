package com.example.ssmp.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @program: SSMP
 * @description: kafka监听消息队列
 * @author: kangwei
 * @create: 2022-07-10 20:31
 **/
@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "kafka_topic")
    public void onMessage(ConsumerRecord<?,?> record){
        System.out.println("消费数据：kafka" + record.value());

    }
}
