package com.example.task_manager.config;

import com.example.task_manager.entity.Role;
import com.example.task_manager.entity.User;
import com.example.task_manager.repository.RoleRepository;
import com.example.task_manager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
public class ApplicationInitConfig {

    @Value("${admin.password}")
    String passwordDefault;

    private final RoleRepository roleRepository;

    public ApplicationInitConfig(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        if (!roleRepository.existsByName("USER") && !roleRepository.existsByName("ADMIN")) {
            Role adminRole = Role.builder()
                    .name("ADMIN")
                    .build();
            Role userRole = Role.builder()
                    .name("USER")
                    .build();
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }


        return args -> {
            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                User user = User.builder()
                        .email("admin@gmail.com")
                        .password(passwordEncoder.encode(passwordDefault))
                        .role(roleRepository.findByName("ADMIN"))
                        .username("admin")
                        .displayName("admin")
                        .build();
                userRepository.save(user);
                log.warn("Admin user created with password: {}", passwordDefault);
            }
        };
    }

}
