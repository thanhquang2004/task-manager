package com.example.task_manager.mapper;

import com.example.task_manager.dto.response.BoardColumnResponse;
import com.example.task_manager.entity.BoardColumn;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardColumnMapper {
    BoardColumn toEntity(com.example.task_manager.dto.request.BoardColumnRequestDto request);
    BoardColumnResponse toResponse(BoardColumn entity);
    List<BoardColumnResponse> toResponseList(List<BoardColumn> entities);
}
