package com.example.ssmp.exception;

import com.example.ssmp.utils.ResultUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: SSMP
 * @description: 异常处理类
 * @author: kangwei
 * @create: 2022-06-18 22:54
 **/
@RestControllerAdvice
public class ExceptionHandlerUtils {


    /**
     * 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResultUtils doException(Exception e) {
        String msg = "系统内部异常";
        e.printStackTrace();
        return new ResultUtils(false, msg);
    }


}
