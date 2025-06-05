package com.example.productservice.config;

import com.example.productservice.controller.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class UserEventListener {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleUserCreated(User user) {
        System.out.println("Received user: " + user.getUsername());
        // Do something with the event
    }
}
