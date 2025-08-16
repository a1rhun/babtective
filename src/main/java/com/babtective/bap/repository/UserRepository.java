package com.babtective.bap.repository;

import com.babtective.bap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}