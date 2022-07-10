package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSMP
 * @description: 短信业务实现
 * @author: kangwei
 * @create: 2022-07-09 21:58
 **/
//@Service
public class MessageServiceImpl implements MessageService {
    private  List<String> list = new ArrayList<>();
    @Override
    public void sendMsg(String orderId) {
        System.out.println("模拟生产短信"+orderId);
        list.add(orderId);
    }


    @Override
    public String getMsg() {
        String orderId = list.remove(0);
        System.out.println("模拟发送短信"+orderId);
        return orderId;
    }
}
