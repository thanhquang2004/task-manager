package com.example.task_manager.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardMemberResponse {
    private Long id;
    private String memberName;
    private Long boardId;


}