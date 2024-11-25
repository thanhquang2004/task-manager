package com.example.task_manager.service;


import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponseDto;

import java.util.List;

public interface BoardColumnService {
    BoardColumnResponseDto createColumn(BoardColumnRequestDto request);
    List<BoardColumnResponseDto> getAllColumns();
    BoardColumnResponseDto updateColumn(Long id, BoardColumnRequestDto request);
    void deleteColumn(Long id);
}