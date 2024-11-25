package com.example.task_manager.service.impl;


import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponseDto;
import com.example.task_manager.service.BoardColumnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardColumnServiceImpl implements BoardColumnService {

    private List<BoardColumnResponseDto> columns = new ArrayList<>();

    @Override
    public BoardColumnResponseDto createColumn(BoardColumnRequestDto request) {
        // Logic to create a column
        BoardColumnResponseDto column = new BoardColumnResponseDto(); // Create a new column
        columns.add(column);
        return column;
    }

    @Override
    public List<BoardColumnResponseDto> getAllColumns() {
        return columns;
    }

    @Override
    public BoardColumnResponseDto updateColumn(Long id, BoardColumnRequestDto request) {
        // Logic to update a column
        return null; // Return updated column
    }

    @Override
    public void deleteColumn(Long id) {
        // Logic to delete a column
    }
}