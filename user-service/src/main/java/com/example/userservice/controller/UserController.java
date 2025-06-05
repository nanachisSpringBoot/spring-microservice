package com.example.userservice.controller;

import com.example.userservice.service.ProductClient;
import com.example.userservice.service.UserEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserEventPublisher userEventPublisher;

    @GetMapping()
    public String getUsers() {
        return "List of users from user-service";
    }

    @GetMapping("/product")
    public List<Product> getProduct() {
        return productClient.getProduct();
    }

    @GetMapping("/test")
    public void testRabbit() {
        userEventPublisher.publishUserCreatedEvent(new User(1L, "john_doe"));
    }
}
