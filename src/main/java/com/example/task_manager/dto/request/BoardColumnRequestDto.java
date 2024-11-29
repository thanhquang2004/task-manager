package com.example.task_manager.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardColumnRequestDto {
    String title;
    String board_id;
}