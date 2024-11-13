package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.CardRequestDto;
import com.example.task_manager.dto.response.CardResponse;
import com.example.task_manager.entity.Card;
import com.example.task_manager.exception.CardNotFoundException;
import com.example.task_manager.mapper.CardMapper;
import com.example.task_manager.repository.CardRepository;
import com.example.task_manager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public CardResponse createCard(CardRequestDto cardRequest) {
        Card card = cardMapper.toEntity(new CardRequestDto());
        card = cardRepository.save(card);
        return cardMapper.toResponse(card);
    }

    @Override
    public CardResponse getCardById(String cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();
        return cardMapper.toResponse(card);
    }

    @Override
    public CardResponse updateCard(String cardId, CardRequestDto cardRequest) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();

        // Cập nhật các trường của card
        card.setTitle(cardRequest.getTitle());
        card.setDescription(cardRequest.getDescription());
        card.setCover(cardRequest.getCover());
        card.setDestroyed(cardRequest.isDestroyed());

        // Lưu lại và trả về phản hồi
        card = cardRepository.save(card);
        return cardMapper.toResponse(card);
    }

    @Override
    public void deleteCard(String cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow();
        cardRepository.delete(card);
    }
}
