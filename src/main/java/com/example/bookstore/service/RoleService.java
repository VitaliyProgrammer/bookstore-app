package com.example.bookstore.service;

import com.example.bookstore.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role save(Role role);

    List<Role> findAll();

    Optional<Role> findByName(String roleName);
}
