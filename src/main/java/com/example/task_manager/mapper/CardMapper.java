package com.example.task_manager.mapper;

import com.example.task_manager.dto.request.CardRequestDto;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card toEntity(CardRequestDto cardRequest);

    CardResponse toResponse(Card card);
}
