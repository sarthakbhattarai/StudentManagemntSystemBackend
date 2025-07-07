package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Role;

public interface RoleService {
    Role create(Role role);
    Role getById(Long id);
    List<Role> getAll();
    Role update(Long id, Role role);
    void delete(Long id);
}
