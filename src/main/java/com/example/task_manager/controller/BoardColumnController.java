package com.example.task_manager.controller;

import com.example.task_manager.dto.request.BoardColumnRequestDto;
import com.example.task_manager.dto.request.UpdateColumnOrderDto;
import com.example.task_manager.dto.response.BoardColumnResponse;
import com.example.task_manager.dto.response.ColumnOrderResponse;
import com.example.task_manager.entity.ColumnOrder;
import com.example.task_manager.service.BoardColumnService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/columns")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:5173")
public class BoardColumnController {

    BoardColumnService boardColumnService;

    @PostMapping
    public BoardColumnResponse createColumn(@RequestBody BoardColumnRequestDto request) {
        return boardColumnService.createColumn(request);
    }

    @GetMapping("/board/{id}")
    public List<BoardColumnResponse> getAllColumns(@PathVariable String id) {
        return boardColumnService.getAllColumnsByBoardId(id);
    }

    @PutMapping("/order")
    public List<ColumnOrderResponse> updateColumnOrder(@RequestBody UpdateColumnOrderDto updateColumnOrderDto) {
        return boardColumnService.updateColumnOrder(updateColumnOrderDto.getColumnOrderIds(), updateColumnOrderDto.getBoardId());
    }

    @PutMapping("/{id}")
    public BoardColumnResponse updateColumn(@PathVariable String id, @RequestBody BoardColumnRequestDto request) {
        return boardColumnService.updateColumn(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable String id) {
        boardColumnService.deleteColumn(id);
    }
}
