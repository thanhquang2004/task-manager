package com.example.task_manager.controller;

import com.example.task_manager.dto.response.CardCommentResponse;
import com.example.task_manager.service.CardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardCommentController {

    @Autowired
    private CardCommentService cardCommentService;

    @GetMapping("/{cardId}/comments")
    public List<CardCommentResponse> getCommentsByCardId(
            @PathVariable String cardId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit) {
        return cardCommentService.getCommentsByCardId(cardId, page, limit);
    }
}
