package com.example.task_manager.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDto {
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    String email;

    @NotEmpty(message = "Password is required")
    String password;
}
