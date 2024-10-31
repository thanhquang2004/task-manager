package com.example.task_manager.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(500, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXIST(400, "User already exists", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(400, "Password must be at least 8 characters long", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(401, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(401, "Unauthorized", HttpStatus.UNAUTHORIZED),;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;

}
