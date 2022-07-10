package com.example.ssmp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * @program: SSMP
 * @description: rabbitmq 配置
 * @author: kangwei
 * @create: 2022-07-10 11:44
 **/
@Configuration
public class RabbitMqDirectConfig {

    /**
     * 队列
     *
     * @return
     * @throws Exception
     */
    @Bean
    public Queue queueDirect() throws Exception {
        return new Queue("direct_queue");
    }

    @Bean
    public Queue queueDirect2() throws Exception {
        return new Queue("direct_queue2");
    }

    /**
     * 直接连接交换机
     *
     * @return
     */
    @Bean
    public DirectExchange exchangeDirect() {
        return new DirectExchange("direct_exchange");
    }

    /**
     * 绑定队列与交换机
     *
     * @return
     * @throws Exception
     */
    @Bean
    public Binding bindingExchange() throws Exception {
        return BindingBuilder.bind(queueDirect()).to(exchangeDirect()).with("direct_binding");
    }

    @Bean
    public Binding bindingExchange2() throws Exception {
        return BindingBuilder.bind(queueDirect()).to(exchangeDirect()).with("direct_binding2");
    }
}
