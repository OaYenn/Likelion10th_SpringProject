package com.example.goodbyelion10th.repository;

import com.example.goodbyelion10th.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Object> findByEmail(String email);
}
