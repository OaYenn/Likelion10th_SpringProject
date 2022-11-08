package com.example.goodbyelion10th.service;

import com.example.goodbyelion10th.domain.User;
import com.example.goodbyelion10th.domain.UserRequestDto;
import com.example.goodbyelion10th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long update(Long id, UserRequestDto requestDto) {
        User user1 = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다.")
        );
        user1.update(requestDto);
        return user1.getId();
    }
}
