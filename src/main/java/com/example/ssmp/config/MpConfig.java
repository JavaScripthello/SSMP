package com.example.ssmp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SSMP
 * @description: 插件配置
 * @author: kangwei
 * @create: 2022-06-18 11:04
 **/
@Configuration
public class MpConfig {

    /**
     * 注入分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor plusInterceptor(){
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return plusInterceptor;
    }
}
