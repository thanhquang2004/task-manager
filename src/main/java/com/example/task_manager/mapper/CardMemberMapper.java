package com.example.task_manager.mapper;

import com.example.task_manager.dto.response.CardMemberResponse;
import com.example.task_manager.entity.CardMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMemberMapper {
    @Mapping(source = "userId", target = "id")
    CardMemberResponse toResponse(CardMember cardMember);
    List<CardMemberResponse> toResponsesList(List<CardMember> cardMembers);
}
