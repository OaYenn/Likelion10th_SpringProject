package com.example.goodbyelion10th.domain;

public class User {

    private Long id;
    private String email;
    private String nickname;

    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
    public void update(UserRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.nickname = requestDto.getNickname();
    }
}