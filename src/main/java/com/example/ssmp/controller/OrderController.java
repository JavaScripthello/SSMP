package com.example.ssmp.controller;

import com.example.ssmp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SSMP
 * @description: 订单控制层
 * @author: kangwei
 * @create: 2022-07-09 22:02
 **/
@RestController("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/{orderId}")
    public void order(@PathVariable String orderId){
        orderService.order(orderId);
    }
}
