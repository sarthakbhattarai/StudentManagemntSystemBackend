package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Optional<Department> findByCode(String code);
}
