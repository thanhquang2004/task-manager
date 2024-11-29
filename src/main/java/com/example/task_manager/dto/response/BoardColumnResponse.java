package com.example.task_manager.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardColumnResponse {
    String id;
    String boardId;
    String title;
    List<String> cardOrderIds;
    List<CardResponse> cards;
    boolean isDestroyed;
}