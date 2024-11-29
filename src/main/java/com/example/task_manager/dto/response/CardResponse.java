package com.example.task_manager.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class CardResponse {
    private String id;
    private String title;
    private String description;
    private String cover;
    private boolean isDestroyed;
    private String columnId;
    private String boardId;
    private Set<String> memberIds;
    private Set<CardCommentResponse> comments;
    private Set<CardAttachmentResponse> attachments;
}
