package com.example.task_manager.service;


import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponse;

import java.util.List;

public interface BoardService {
    BoardResponse createBoard(BoardRequestDto request);
    List<BoardResponse> getAllBoardsByUser();
    BoardResponse updateBoard(String id, BoardRequestDto request);
    BoardResponse getBoardDetailById(String id);
    void  deleteBoard(String id);
}