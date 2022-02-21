package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User findByName(String name);

    void save(User user);
}
