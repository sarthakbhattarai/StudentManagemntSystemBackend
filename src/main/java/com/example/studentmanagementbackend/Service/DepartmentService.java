package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Department;

public interface DepartmentService {
    Department create(Department dept);
    Department getById(Long id);
    List<Department> getAll();
    Department update(Long id, Department dept);
    void delete(Long id);
}
