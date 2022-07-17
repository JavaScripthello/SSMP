package com.example.ssmp.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @program: SSMP
 * @description: rocketMq jianting
 * @author: kangwei
 * @create: 2022-07-10 20:48
 **/
@Component
@RocketMQMessageListener(topic = "rocket_order",consumerGroup ="group_rocket")
public class RocketMqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("rocket mq 消费数据："+s);
    }
}
