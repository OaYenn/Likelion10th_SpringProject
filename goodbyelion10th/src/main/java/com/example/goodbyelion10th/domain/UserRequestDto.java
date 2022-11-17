package com.example.goodbyelion10th.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String email;
    private String password;
    private String nickname;

    public UserRequestDto(String email, String nickname, String password) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
