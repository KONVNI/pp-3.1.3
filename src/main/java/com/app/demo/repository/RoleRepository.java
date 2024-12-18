package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}