package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Order;
import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.repository.UserRepo;
import com.teachmeskills.visaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAllByActiveOrderByIdDesc(true);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findByIdAndActive(id, true);
    }

    @Override
    public User findByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public void save(User user) {
        /*List<Order> orderList = new ArrayList<>();

        // create first story
        Order order1 = new Order();
        order1.setId(id);*/


        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public User updateUser(Long id, User request) {
        User fromDb = findById(id);
        fromDb.setUsername(request.getUsername());
        fromDb.setFirstName(request.getFirstName());
        fromDb.setLastName(request.getLastName());
        fromDb.setAge(request.getAge());
        fromDb.setSexes(request.getSexes());
        fromDb.setMobileNumber(request.getMobileNumber());
        fromDb.setEmail(request.getEmail());
        fromDb.setActive(request.isActive());
        fromDb.setRoles(request.getRoles());
        fromDb.setUpdatedUserAt(LocalDateTime.now());
        return userRepo.save(fromDb);
    }

}
