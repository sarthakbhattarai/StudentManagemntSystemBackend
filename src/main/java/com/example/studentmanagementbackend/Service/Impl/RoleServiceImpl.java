package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Role;
import com.example.studentmanagementbackend.Repository.RoleRepository;
import com.example.studentmanagementbackend.Service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role create(Role role) {
        return repository.save(role);
    }

    @Override
    public Role getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Role not found: " + id));
    }

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role update(Long id, Role role) {
        Role existing = getById(id);
        existing.setName(role.getName());
        existing.setDescription(role.getDescription());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
