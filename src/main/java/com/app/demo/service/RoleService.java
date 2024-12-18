package com.app.demo.service;

import com.app.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAll();

    Set<Role> findByIds(List<Long> ids);
}