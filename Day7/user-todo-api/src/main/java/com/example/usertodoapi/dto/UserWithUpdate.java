package com.example.usertodoapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWithUpdate {
    @Email(message = "格式不正確")
    @NotBlank(message = "不得是空值")
    String email;

    @NotBlank(message = "不得是空值")
    String nickname;

    @NotBlank(message = "不得是空值")
    String type;

    @NotBlank(message = "不得是空值")
    String password;
}