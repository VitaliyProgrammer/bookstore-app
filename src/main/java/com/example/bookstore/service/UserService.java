package com.example.bookstore.service;

import com.example.bookstore.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAll();
}
