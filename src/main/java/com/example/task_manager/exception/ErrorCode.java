package com.example.task_manager.exception;

public enum ErrorCode {
    USER_EXIST(400, "User already exists"),
    PASSWORD_INVALID(400, "Password must be at least 8 characters long"),
    USER_NOT_FOUND(404, "User not found"),
    UNAUTHORIZED(401, "Unauthorized");

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
