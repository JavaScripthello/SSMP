package com.example.ssmp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SSMP
 * @description: rabbitmq 配置
 * @author: kangwei
 * @create: 2022-07-10 11:44
 **/
@Configuration
public class RabbitMqTopicConfig {

    /**
     * 队列
     *
     * @return
     * @throws Exception
     */
    @Bean
    public Queue queueTopic() throws Exception {
        return new Queue("topic_queue");
    }

    @Bean
    public Queue queueTopic2() throws Exception {
        return new Queue("topic_queue2");
    }

    /**
     * 直接连接交换机
     *
     * @return
     */
    @Bean
    public TopicExchange exchangeTopic() {
        return new TopicExchange("topic_exchange");
    }

    /**
     * 绑定队列与交换机
     *
     * @return
     * @throws Exception
     */
    @Bean
    public Binding bindingExchange() throws Exception {
        return BindingBuilder.bind(queueTopic()).to(exchangeTopic()).with("topic_binding.*.*");
    }

    @Bean
    public Binding bindingExchange2() throws Exception {
        return BindingBuilder.bind(queueTopic()).to(exchangeTopic()).with("topic_binding2");
    }
}
