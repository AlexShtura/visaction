package com.teachmeskills.visaction.repository;

import com.teachmeskills.visaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
