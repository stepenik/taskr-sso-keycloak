package com.evil.inc.taskrssokeycloak.repository;

import com.evil.inc.taskrssokeycloak.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
