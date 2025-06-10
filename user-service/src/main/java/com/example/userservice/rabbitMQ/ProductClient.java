package com.example.userservice.rabbitMQ;

import com.example.userservice.rabbitMQ.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductClient {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ProductClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public List<Product> getProduct() {
        return webClientBuilder.build()
                .get()
                .uri("http://product-service/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }
}
