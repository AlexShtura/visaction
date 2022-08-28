package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByName(String name);

    void save(User user);

    User updateUser(Long id, User user);

}
