package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.DTO.Dept.DepartmentRequest;
import com.example.studentmanagementbackend.DTO.Dept.DepartmentResponse;
import com.example.studentmanagementbackend.Model.Department;

public interface DepartmentService {

    DepartmentResponse create(DepartmentRequest request);

    Department getById(Long id);

    List<DepartmentResponse> getAll();

    Department update(Long id, Department dept);

    void delete(Long id);
}
