package com.example.task_manager.service;

import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.User;

public interface UserService {
    UserResponse getUserByEmail(String email);
}
