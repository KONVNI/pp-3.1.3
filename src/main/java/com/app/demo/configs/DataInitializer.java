package com.app.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.app.demo.model.Role;
import com.app.demo.model.User;
import com.app.demo.repository.RoleRepository;
import com.app.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        roleRepository.deleteAll();

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        User admin = new User();
        admin.setUsername("admin@mail.ru");
        admin.setPassword(passwordEncoder.encode("admin"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminRoles.add(userRole);
        admin.setRoles(adminRoles);
        admin.setAge((byte) 30);
        admin.setFirstname("Admin");
        admin.setLastname("Adminov");
        userRepository.save(admin);

        User user = new User();
        user.setUsername("user@mail.ru");
        user.setPassword(passwordEncoder.encode("user"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        user.setAge((byte) 20);
        user.setFirstname("User");
        user.setLastname("Userov");
        userRepository.save(user);
    }
}
