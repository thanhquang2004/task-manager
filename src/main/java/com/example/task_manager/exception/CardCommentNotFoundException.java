package com.example.task_manager.exception;

public class CardCommentNotFoundException extends RuntimeException {
    public CardCommentNotFoundException(String message) {
        super(message);
    }
}
