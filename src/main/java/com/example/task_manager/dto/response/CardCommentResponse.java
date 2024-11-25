package com.example.task_manager.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardCommentResponse {
    private String id;
    private String content;
    private LocalDateTime createdAt;
    private UserDto user;

    @Data
    public static class UserDto {
        private String id;
        private String username;
        private String displayName;
        private String avatar;
    }
}
