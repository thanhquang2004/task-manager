package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.CardCommentRequestDto;
import com.example.task_manager.dto.response.CardCommentResponse;
import com.example.task_manager.entity.Card;
import com.example.task_manager.entity.CardComment;
import com.example.task_manager.mapper.CardCommentMapper;
import com.example.task_manager.repository.CardCommentRepository;
import com.example.task_manager.repository.CardRepository;
import com.example.task_manager.service.CardCommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardCommentServiceImpl implements CardCommentService {

    @Autowired
    private CardCommentRepository cardCommentRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardCommentMapper cardCommentMapper;

    @Override
    public List<CardCommentResponse> getCommentsByCardId(String cardId, int page, int limit) {
        List<CardComment> comments = cardCommentRepository.findByCardId(cardId);
        return comments.stream()
                .map(cardCommentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CardCommentResponse addComment(String cardId, CardCommentRequestDto requestDto) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        CardComment cardComment = new CardComment();
        cardComment.setCard(card);
        cardComment.setContent(requestDto.getContent());
        cardComment.setCreatedAt(LocalDateTime.now());

        CardComment savedComment = cardCommentRepository.save(cardComment);
        return cardCommentMapper.toResponse(savedComment);
    }
}
