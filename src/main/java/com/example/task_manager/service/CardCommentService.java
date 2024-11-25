package com.example.task_manager.service;

import com.example.task_manager.dto.request.CardCommentRequestDto;
import com.example.task_manager.dto.response.CardCommentResponse;
import java.util.List;

public interface CardCommentService {
    List<CardCommentResponse> getCommentsByCardId(String cardId, int page, int limit);
    CardCommentResponse addComment(String cardId, CardCommentRequestDto requestDto);
}
