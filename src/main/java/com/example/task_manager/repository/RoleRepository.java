package com.example.task_manager.repository;

import com.example.task_manager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String name);
    boolean existsByName(String name);
}
