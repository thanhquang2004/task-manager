package com.example.task_manager.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CardMember {

    @Id
    private String id;

    @Column(name = "card_id")  // Ánh xạ trường cardId với cột card_id trong cơ sở dữ liệu
    private String cardId;

    @Column(name = "user_id")  // Tương tự với trường userId
    private String userId;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
