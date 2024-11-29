package com.example.task_manager.controller;
import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.User;
import com.example.task_manager.mapper.UserMapper;

import com.example.task_manager.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;
    UserMapper userMapper;

    @GetMapping("/getme")
    UserResponse getUse() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("credentials: {}", authentication.getCredentials());
        log.info("principal: {}", authentication.getPrincipal());
        log.info("User {} is getting all users", authentication.getName());
        authentication.getAuthorities().forEach(a -> log.info(a.getAuthority()));

        return userService.getUserByEmail(authentication.getName());
    }
}
