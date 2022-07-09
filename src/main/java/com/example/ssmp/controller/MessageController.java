package com.example.ssmp.controller;

import com.example.ssmp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SSMP
 * @description: 短信发送控制
 * @author: kangwei
 * @create: 2022-07-09 22:03
 **/
@RestController("/msgs")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public String getMsg() {
        String id = messageService.getMsg();
        return id;
    }
}
