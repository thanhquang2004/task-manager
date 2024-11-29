package com.example.task_manager.controller;


import com.example.task_manager.dto.request.BoardRequestDto;
import com.example.task_manager.dto.response.BoardResponse;
import com.example.task_manager.service.BoardService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:5173")
public class BoardController {


    BoardService boardService;

    @PostMapping
    public BoardResponse createBoard(@RequestBody BoardRequestDto request) {
        return boardService.createBoard(request);
    }

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoardsByUser();
    }

    @GetMapping("/{id}")

    public BoardResponse getBoardDetail(@PathVariable String id) {
//        log.info("Getting board detail for board id: {}", id);
        return boardService.getBoardDetailById(id);
    }


    @PutMapping("/{id}")
    public BoardResponse updateBoard(@PathVariable String id, @RequestBody BoardRequestDto request) {
        return boardService.updateBoard(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable String id) {
        boardService.deleteBoard(id);
    }
}