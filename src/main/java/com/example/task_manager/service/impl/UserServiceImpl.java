package com.example.task_manager.service.impl;

import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.User;
import com.example.task_manager.mapper.UserMapper;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public UserResponse getUserByEmail(String email) {
        return userMapper.toUserResponse(userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email)));
    }
}
