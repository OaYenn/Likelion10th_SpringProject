package com.example.goodbyelion10th.service;

import com.example.goodbyelion10th.domain.Users;
import com.example.goodbyelion10th.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(Users user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(Users user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Users> findUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
