package com.example.task_manager.service;


import com.example.task_manager.dto.request.ColumnRequestDto;
import com.example.task_manager.dto.response.ColumnResponseDto;

import java.util.List;

public interface ColumnService {
    ColumnResponseDto createColumn(ColumnRequestDto request);
    List<ColumnResponseDto> getAllColumns();
    ColumnResponseDto updateColumn(Long id, ColumnRequestDto request);
    void deleteColumn(Long id);
}