package com.example.ssmp.service.impl;

import com.example.ssmp.service.MessageService;
import com.example.ssmp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSMP
 * @description: 订单业务实现
 * @author: kangwei
 * @create: 2022-07-09 21:56
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private MessageService messageService;
    @Override
    public void order(String orderId) {
        messageService.sendMsg(orderId);
    }
}
