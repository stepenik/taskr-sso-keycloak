package com.evil.inc.taskrssokeycloak.service;

import com.evil.inc.taskrssokeycloak.domain.User;

public interface UserService {
    User saveUser(User user);
    User getByUsername(String username);
}
