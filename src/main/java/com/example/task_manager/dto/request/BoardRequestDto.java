package com.example.task_manager.dto.request;

import com.example.task_manager.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardRequestDto {
    @NotEmpty(message = "Board title is required")
    String title;

    String description;

    @NotEmpty(message = "Board type is required")
    String type;
}