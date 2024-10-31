package com.example.task_manager.service;

import com.example.task_manager.entity.User;

public interface UserService {
    User getUserByEmail(String email);
}
