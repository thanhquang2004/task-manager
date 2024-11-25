package com.example.task_manager.controller;

import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.response.BoardColumnResponseDto;
import com.example.task_manager.service.BoardColumnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/columns")
public class BoardColumnController {

    @Autowired
    private BoardColumnService boardColumnService;

    @PostMapping
    public BoardColumnResponseDto createColumn(@RequestBody BoardColumnRequestDto request) {
        return boardColumnService.createColumn(request);
    }

    @GetMapping
    public List<BoardColumnResponseDto> getAllColumns() {
        return boardColumnService.getAllColumns();
    }

    @PutMapping("/{id}")
    public BoardColumnResponseDto updateColumn(@PathVariable Long id, @RequestBody BoardColumnRequestDto request) {
        return boardColumnService.updateColumn(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Long id) {
        boardColumnService.deleteColumn(id);
    }
}
