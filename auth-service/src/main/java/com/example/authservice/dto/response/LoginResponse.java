package com.example.authservice.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private String token;

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

}
