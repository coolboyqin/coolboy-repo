package com.service;

import com.domain.User;

public interface UserService {
    User findByUsernameAndPassword(User user);
}
