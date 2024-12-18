package com.app.demo.service;

import org.springframework.stereotype.Service;
import com.app.demo.model.Role;
import com.app.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Set<Role> findByIds(List<Long> ids) {
        return new HashSet<>(roleRepository.findAllById(ids));
    }
}

