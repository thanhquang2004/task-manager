package com.example.task_manager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardResponse {
    String id;
    String title;
    String description;
    String type;
    List<String> columnOrderIds;
    List<BoardColumnResponse> columns;
    boolean isDestroyed;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}