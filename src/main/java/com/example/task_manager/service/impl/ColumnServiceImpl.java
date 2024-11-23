package com.example.task_manager.service.impl;


import com.example.task_manager.dto.request.ColumnRequestDto;
import com.example.task_manager.dto.response.ColumnResponseDto;
import com.example.task_manager.service.ColumnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {

    private List<ColumnResponseDto> columns = new ArrayList<>();

    @Override
    public ColumnResponseDto createColumn(ColumnRequestDto request) {
        // Logic to create a column
        ColumnResponseDto column = new ColumnResponseDto(); // Create a new column
        columns.add(column);
        return column;
    }

    @Override
    public List<ColumnResponseDto> getAllColumns() {
        return columns;
    }

    @Override
    public ColumnResponseDto updateColumn(Long id, ColumnRequestDto request) {
        // Logic to update a column
        return null; // Return updated column
    }

    @Override
    public void deleteColumn(Long id) {
        // Logic to delete a column
    }
}