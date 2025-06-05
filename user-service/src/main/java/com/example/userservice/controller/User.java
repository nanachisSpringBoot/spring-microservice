package com.example.userservice.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;

    public User(long l, String johnDoe) {
        this.id = l;
        this.username = johnDoe;
    }
}
