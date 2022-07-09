package com.example.ssmp.service;

/**
 * @program: SSMP
 * @description: 短信业务逻辑接口
 * @author: kangwei
 * @create: 2022-07-09 21:57
 **/
public interface MessageService {
    public void sendMsg(String orderId);
    public String getMsg();
}
