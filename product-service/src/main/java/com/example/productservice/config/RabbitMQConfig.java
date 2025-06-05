package com.example.productservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {
    public static final String EXCHANGE = "user.exchange";
    public static final String ROUTING_KEY = "user.created";
    public static final String QUEUE = "user.created.queue";
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
