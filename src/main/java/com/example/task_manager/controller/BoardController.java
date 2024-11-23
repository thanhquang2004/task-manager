package com.example.task_manager.controller;


import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponseDto;
import com.example.task_manager.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto request) {
        return boardService.createBoard(request);
    }

    @GetMapping
    public List<BoardResponseDto> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PutMapping("/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto request) {
        return boardService.updateBoard(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}