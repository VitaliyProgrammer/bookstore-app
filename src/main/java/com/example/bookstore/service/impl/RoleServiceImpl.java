package com.example.bookstore.service.impl;

import com.example.bookstore.model.Role;
import com.example.bookstore.repository.RoleRepository;
import com.example.bookstore.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findByName(String roleName) {

        return roleRepository.findByName(roleName);
    }
}
