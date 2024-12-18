package com.app.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.app.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void updateUser(User user);

    void deleteById(Long id);
}
