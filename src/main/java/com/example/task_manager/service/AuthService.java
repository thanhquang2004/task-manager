package com.example.task_manager.service;

import com.example.task_manager.dto.request.AuthDto;
import com.example.task_manager.dto.request.LoginDto;
import com.example.task_manager.dto.request.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    AuthDto login(LoginDto loginDto);
    AuthDto refresh(String refreshToken);
}
