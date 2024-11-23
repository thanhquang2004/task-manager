package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponseDto;
import com.example.task_manager.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private List<BoardResponseDto> boards = new ArrayList<>();

    @Override
    public BoardResponseDto createBoard(BoardRequestDto request) {
        // Logic to create a board
        BoardResponseDto board = new BoardResponseDto(); // Create a new board
        boards.add(board);
        return board;
    }

    @Override
    public List<BoardResponseDto> getAllBoards() {
        return boards;
    }

    @Override
    public BoardResponseDto updateBoard(Long id, BoardRequestDto request) {
        // Logic to update a board
        return null; // Return updated board
    }

    @Override
    public void deleteBoard(Long id) {
        // Logic to delete a board
    }
}