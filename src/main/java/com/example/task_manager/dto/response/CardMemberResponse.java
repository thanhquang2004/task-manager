package com.example.task_manager.dto.response;

public class CardMemberResponse {
    private String id;
    private String cardId;
    private String userId;

    public CardMemberResponse() {
    }

    public CardMemberResponse(String id, String cardId, String userId) {
        this.id = id;
        this.cardId = cardId;
        this.userId = userId;
    }

    // Setters và Getters
    public void setId(String id) { this.id = id; }
    public void setCardId(String cardId) { this.cardId = cardId; }
    public void setUserId(String userId) { this.userId = userId; }

    // Getters
    public String getId() { return id; }
    public String getCardId() { return cardId; }
    public String getUserId() { return userId; }
}
