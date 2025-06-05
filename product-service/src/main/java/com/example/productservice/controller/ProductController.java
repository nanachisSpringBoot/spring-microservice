package com.example.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public List<Map<String, Object>> getProducts() {
        return List.of(
                Map.of("id", 1, "name", "MacBook Pro"),
                Map.of("id", 2, "name", "iPhone 15 Pro")
        );
    }
}
