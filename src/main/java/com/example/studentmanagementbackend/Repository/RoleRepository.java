package com.example.studentmanagementbackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Role;
import com.example.studentmanagementbackend.Model.Role.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Optional<Role> findByName(RoleName name);
}
