package com.example.task_manager.mapper;

import com.example.task_manager.dto.response.CardCommentResponse;
import com.example.task_manager.entity.CardComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardCommentMapper {
    CardCommentMapper INSTANCE = Mappers.getMapper(CardCommentMapper.class);

    @Mapping(target = "user.id", source = "user.id")
    @Mapping(target = "user.username", source = "user.username")
    @Mapping(target = "user.displayName", source = "user.displayName")
    @Mapping(target = "user.avatar", source = "user.avatar")
    CardCommentResponse toResponse(CardComment cardComment);
}
