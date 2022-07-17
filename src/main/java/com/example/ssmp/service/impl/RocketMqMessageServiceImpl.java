package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

/**
 * @program: SSMP
 * @description: rocketMq
 * @author: kangwei
 * @create: 2022-07-10 20:43
 **/
@Service
public class RocketMqMessageServiceImpl implements MessageService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void sendMsg(String orderId) {
        System.out.println("rocket mq 生产数据"+orderId);
        //同步，使用较少
//        rocketMQTemplate.convertAndSend("rocket_order",orderId);
        SendCallback sendCallback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        };
        rocketMQTemplate.asyncSend("rocket_order",orderId,sendCallback);
    }

    @Override
    public String getMsg() {
        return null;
    }
}
