package com.example.task_manager.controller;

import com.example.task_manager.dto.request.CardMemberRequestDto;
import com.example.task_manager.dto.response.CardMemberResponse;
import com.example.task_manager.service.CardMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards/{cardId}/members")
public class CardMemberController {

    private final CardMemberService cardMemberService;

    public CardMemberController(CardMemberService cardMemberService) {
        this.cardMemberService = cardMemberService;
    }

    @GetMapping
    public ResponseEntity<List<CardMemberResponse>> getCardMembers(@PathVariable String cardId) {
        List<CardMemberResponse> members = cardMemberService.getCardMembers(cardId);
        return ResponseEntity.ok(members);
    }

    @PostMapping
    public ResponseEntity<CardMemberResponse> addCardMember(
            @PathVariable String cardId,
            @RequestBody CardMemberRequestDto cardMemberRequest) {
        CardMemberResponse addedMember = cardMemberService.addCardMember(cardId, cardMemberRequest);
        return ResponseEntity.ok(addedMember);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeCardMember(
            @PathVariable String cardId,
            @PathVariable String userId) {
        cardMemberService.removeCardMember(cardId, userId);
        return ResponseEntity.noContent().build();
    }
}
