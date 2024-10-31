package com.example.task_manager.mapper;

import com.example.task_manager.dto.request.RegisterDto;
import com.example.task_manager.dto.response.UserResponse;
import com.example.task_manager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(RegisterDto request);
    UserResponse toUserResponse(User user);
}
