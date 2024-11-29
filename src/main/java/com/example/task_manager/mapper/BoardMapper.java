package com.example.task_manager.mapper;

import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponse;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board toEntity(BoardRequestDto boardRequest);

    BoardResponse toResponse(Board board);

}
