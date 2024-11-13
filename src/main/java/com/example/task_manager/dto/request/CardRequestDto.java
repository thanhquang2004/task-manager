package com.example.task_manager.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class CardRequestDto {
    private String title;
    private String description;
    private String cover;
    private boolean isDestroyed;
    private String columnId;  // The ID of the BoardColumn
    private String boardId;   // The ID of the Board
    private Set<String> memberIds; // IDs of users to be added as members
}
