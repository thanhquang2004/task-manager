package com.example.task_manager.service;

import com.example.task_manager.dto.request.AuthDto;
import com.example.task_manager.dto.request.LoginDto;
import com.example.task_manager.dto.request.RegisterDto;
import com.example.task_manager.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterDto registerDto);
    AuthResponse login(LoginDto loginDto);
    String refresh(String refreshToken);
}
