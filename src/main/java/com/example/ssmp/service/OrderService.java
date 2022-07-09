package com.example.ssmp.service;

/**
 * @program: SSMP
 * @description: 订单业务接口层
 * @author: kangwei
 * @create: 2022-07-09 21:54
 **/
public interface OrderService {

    /**
     * 订单发短信
     * @param orderId
     */
    void order(String orderId);
}
