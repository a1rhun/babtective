package com.babtective.bap.repository;

import com.babtective.bap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// User 엔티티를 위한 데이터 접근 계층
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
