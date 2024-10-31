package com.example.task_manager.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    String email;

    @NotEmpty(message = "Password is required")
    @Min(value = 8, message = "Password must be at least 8 characters long")
    String password;

    @NotEmpty(message = "Username is required")
    String username;

    @NotEmpty(message = "Display name is required")
    String displayName;
}
