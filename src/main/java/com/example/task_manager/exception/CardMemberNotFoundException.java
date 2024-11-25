package com.example.task_manager.exception;

public class CardMemberNotFoundException extends RuntimeException {
    public CardMemberNotFoundException(String message) {
        super(message);
    }
}
