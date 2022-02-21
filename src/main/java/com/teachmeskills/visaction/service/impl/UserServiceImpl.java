package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.repository.UserRepo;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public void save(User user) {
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
