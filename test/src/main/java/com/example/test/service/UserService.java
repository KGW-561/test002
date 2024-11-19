package com.example.test.service;

import com.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String generateRandomNickname(){
        return "user_" + UUID.randomUUID().toString().substring(0,8);
    }

    public void saveUser(String nickname){
        userMapper.insertUser(nickname);
    }
}
