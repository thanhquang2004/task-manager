package com.example.task_manager.controller;

import com.example.task_manager.dto.request.LoginDto;
import com.example.task_manager.dto.request.RegisterDto;
import com.example.task_manager.dto.response.ApiResponse;
import com.example.task_manager.dto.response.AuthResponse;
import com.example.task_manager.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
    AuthService authService;

    @PostMapping("/register")
    AuthResponse register(@RequestBody @Valid RegisterDto registerDto) {
        log.info("Register request: {}", registerDto);
        return authService.register(registerDto);
    }

    @PostMapping("/login")
    AuthResponse login(@RequestBody @Valid LoginDto loginDto) {
        log.info("Login request: {}", loginDto);
        return authService.login(loginDto);
    }
}
