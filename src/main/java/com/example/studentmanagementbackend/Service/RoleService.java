package com.example.studentmanagementbackend.Service;

import java.util.List;
import java.util.Optional;

import com.example.studentmanagementbackend.Model.Role;
import com.example.studentmanagementbackend.Model.Role.RoleName;

public interface RoleService {
    Role create(Role role);
    Role getById(Long id);
    List<Role> getAll();
    Role update(Long id, Role role);
    void delete(Long id);
    Optional<Role> findByName(RoleName name);
}
