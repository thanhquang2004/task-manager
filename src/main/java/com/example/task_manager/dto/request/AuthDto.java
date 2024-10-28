package com.example.task_manager.dto.request;

import com.example.task_manager.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDto {
    String id;
    String accessToken;
    String refreshToken;

    public static AuthDto from(User user, String accessToken, String refreshToken) {
        return AuthDto.builder()
                .id(user.getId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
