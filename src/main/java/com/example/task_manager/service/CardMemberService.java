package com.example.task_manager.service;

import com.example.task_manager.dto.request.CardMemberRequestDto;
import com.example.task_manager.dto.response.CardMemberResponse;

import java.util.List;

public interface CardMemberService {
    List<CardMemberResponse> getCardMembers(String cardId);
    CardMemberResponse addCardMember(String cardId, CardMemberRequestDto cardMemberRequestDto);
    void removeCardMember(String cardId, String userId);
}
