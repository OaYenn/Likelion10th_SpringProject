package com.example.goodbyelion10th.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String email;
    private String nickname;

    public UserRequestDto(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
