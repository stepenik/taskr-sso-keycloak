package com.evil.inc.taskrssokeycloak.service.impl;

import com.evil.inc.taskrssokeycloak.domain.User;
import com.evil.inc.taskrssokeycloak.repository.UserRepository;
import com.evil.inc.taskrssokeycloak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
