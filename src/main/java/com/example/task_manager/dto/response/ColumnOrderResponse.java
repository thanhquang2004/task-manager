package com.example.task_manager.dto.response;

import lombok.Data;

@Data
public class ColumnOrderResponse {
    String id;
    int position;
    String columnId;
    String boardId;
}
