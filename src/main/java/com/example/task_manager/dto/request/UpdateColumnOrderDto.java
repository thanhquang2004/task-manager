package com.example.task_manager.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateColumnOrderDto {
    List<String> columnOrderIds;

    String boardId;
}
