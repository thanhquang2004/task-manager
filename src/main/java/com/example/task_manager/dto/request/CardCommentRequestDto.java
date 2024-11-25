package com.example.task_manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CardCommentRequestDto {
    @NotBlank(message = "Content is required")
    private String content;
}
