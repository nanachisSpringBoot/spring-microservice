package com.example.userservice.controller;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.rabbitMQ.ProductClient;
import com.example.userservice.rabbitMQ.UserEventPublisher;
import com.example.userservice.rabbitMQ.dto.Product;
import com.example.userservice.rabbitMQ.dto.User;
import com.example.userservice.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "Authorization")
public class UserController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserEventPublisher userEventPublisher;

    @Autowired
    private UserService userService;

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

    @PostMapping("/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserRequest request) {
        UserEntity response = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserEntity>> saveUser() {
        List<UserEntity> response = userService.list();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
