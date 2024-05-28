package com.src.app.services;

import java.util.List;

import com.src.app.domain.User;

public interface UserService {
    List<User> listUsers();
    User saveUser (User user);
}
