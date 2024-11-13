package com.example.task_manager.service;

import com.example.task_manager.dto.request.CardRequestDto;
import com.example.task_manager.dto.response.CardResponse;

public interface CardService {

    CardResponse createCard(CardRequestDto cardRequestDto);

    CardResponse getCardById(String cardId);

    CardResponse updateCard(String cardId, CardRequestDto cardRequest);

    void deleteCard(String cardId);
}
