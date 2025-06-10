package com.example.userservice.service;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserEntityRepository userRepository;


    public UserEntity save(UserRequest request) {

        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        return userRepository.save(userEntity);
    }

    public List<UserEntity> list() {
        return userRepository.findAll();
    }
}
