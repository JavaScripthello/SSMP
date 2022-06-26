package com.example.ssmp.utils;

import lombok.Data;

/**
 * @program: SSMP
 * @description: 结果集协议映射
 * @author: kangwei
 * @create: 2022-06-18 17:11
 **/
@Data
public class ResultUtils {

    private Boolean success;
    private Object data;
    private String msg;

    public ResultUtils(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ResultUtils(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ResultUtils(Boolean success, String msg,Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Object data) {
        this.data = data;
    }

    public ResultUtils(Boolean success) {
        this.success = success;
    }

    public ResultUtils() {
    }
}
