package com.example.ssmp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: SSMP
 * @description: 日志
 * @author: kangwei
 * @create: 2022-06-25 23:06
 **/
public class BaseClass {
    private Class clazz;
    private Logger log;

    BaseClass(){
        log = LoggerFactory.getLogger(this.getClass());
    }
}
