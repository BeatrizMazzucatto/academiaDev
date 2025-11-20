package com.academiadev.repository;

import java.util.Collection;
import java.util.Optional;
import com.academiadev.model.User;

public interface UserRepository {
    
    void save(User user);
    Optional<User> findByEmail(String email);
    Collection<User> findAll();
}

