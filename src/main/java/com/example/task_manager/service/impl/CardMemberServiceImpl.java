package com.example.task_manager.service.impl;

import com.example.task_manager.dto.request.CardMemberRequestDto;
import com.example.task_manager.dto.response.CardMemberResponse;
import com.example.task_manager.repository.CardMemberRepository;
import com.example.task_manager.entity.CardMember;
import com.example.task_manager.service.CardMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardMemberServiceImpl implements CardMemberService {

    @Autowired
    private CardMemberRepository cardMemberRepository;

    @Override
    public List<CardMemberResponse> getCardMembers(String cardId) {
        List<CardMember> cardMembers = cardMemberRepository.findByCardId(cardId);
        return cardMembers.stream()
                .map(this::convertToCardMemberResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CardMemberResponse addCardMember(String cardId, CardMemberRequestDto cardMemberRequestDto) {
        CardMember cardMember = new CardMember();
        cardMember.setCardId(cardId);
        cardMember.setUserId(cardMemberRequestDto.getUserId());

        CardMember savedCardMember = cardMemberRepository.save(cardMember);
        return convertToCardMemberResponse(savedCardMember);
    }

    @Override
    public void removeCardMember(String cardId, String userId) {
        cardMemberRepository.deleteByCardIdAndUserId(cardId, userId);
    }

    private CardMemberResponse convertToCardMemberResponse(CardMember cardMember) {
        return new CardMemberResponse(
                cardMember.getId(),
                cardMember.getCardId(),
                cardMember.getUserId()
        );
    }
}
