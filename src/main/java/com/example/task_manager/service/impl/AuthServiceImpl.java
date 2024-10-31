package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.AuthDto;
import com.example.task_manager.dto.request.LoginDto;
import com.example.task_manager.dto.request.RegisterDto;
import com.example.task_manager.dto.response.AuthResponse;
import com.example.task_manager.entity.User;
import com.example.task_manager.exception.AppException;
import com.example.task_manager.exception.ErrorCode;
import com.example.task_manager.mapper.UserMapper;
import com.example.task_manager.repository.RoleRepository;
import com.example.task_manager.repository.UserRepository;
import com.example.task_manager.security.JwtService;
import com.example.task_manager.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;
    UserMapper userMapper;


    @Override
    public AuthResponse register(RegisterDto registerDto) {
        if (userRepository.existsUserByEmail(registerDto.getEmail())) {
            throw new AppException(ErrorCode.USER_EXIST);
        }

        User user = userMapper.toUser(registerDto);
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        user.setRole(roleRepository.findByName("USER"));

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        userRepository.save(user);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .user(userMapper.toUserResponse(user))
                .build();
    }

    @Override
    public AuthResponse login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
                () -> new RuntimeException("User not found with email: " + loginDto.getEmail())
        );

        boolean authenticated = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());

        if (!authenticated) {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);


        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .user(userMapper.toUserResponse(user))
                .build();
    }

    @Override
    public String refresh(String refreshToken) {
        return null;
    }

}
