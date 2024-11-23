package com.example.task_manager.controller;

import com.example.task_manager.dto.request.ColumnRequestDto;
import com.example.task_manager.dto.response.ColumnResponseDto;
import com.example.task_manager.service.ColumnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/columns")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @PostMapping
    public ColumnResponseDto createColumn(@RequestBody ColumnRequestDto request) {
        return columnService.createColumn(request);
    }

    @GetMapping
    public List<ColumnResponseDto> getAllColumns() {
        return columnService.getAllColumns();
    }

    @PutMapping("/{id}")
    public ColumnResponseDto updateColumn(@PathVariable Long id, @RequestBody ColumnRequestDto request) {
        return columnService.updateColumn(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Long id) {
        columnService.deleteColumn(id);
    }
}
