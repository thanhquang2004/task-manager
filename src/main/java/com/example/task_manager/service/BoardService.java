package com.example.task_manager.service;


import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponseDto;

import java.util.List;

public interface BoardService {
    BoardResponseDto createBoard(BoardRequestDto request);
    List<BoardResponseDto> getAllBoards();
    BoardResponseDto updateBoard(Long id, BoardRequestDto request);
    void deleteBoard(Long id);
}