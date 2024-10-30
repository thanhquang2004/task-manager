package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.AuthDto;
import com.example.task_manager.dto.request.LoginDto;
import com.example.task_manager.dto.request.RegisterDto;
import com.example.task_manager.repository.RoleRepository;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;



    @Override
    public String register(RegisterDto registerDto) {
        return null;
    }

    @Override
    public AuthDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

    }

    @Override
    public AuthDto refresh(String refreshToken) {
        return null;
    }

}
