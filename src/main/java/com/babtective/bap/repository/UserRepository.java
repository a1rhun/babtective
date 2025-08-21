package com.babtective.bap.repository;

import com.babtective.bap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// *User 엔티티용 JPA 리포지토리
public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일 중복 여부 체크 (회원가입 시 사용)
    boolean existsByEmail(String email);

    // 이메일로 사용자 조회 (로그인 시 사용)
    Optional<User> findByEmail(String email);
}
