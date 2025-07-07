package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Department;
import com.example.studentmanagementbackend.Repository.DepartmentRepository;
import com.example.studentmanagementbackend.Service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    @Override
    public Department create(Department dept) {
        return repository.save(dept);
    }

    @Override
    public Department getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found: " + id));
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Department update(Long id, Department dept) {
        Department existing = getById(id);
        existing.setCode(dept.getCode());
        existing.setName(dept.getName());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
