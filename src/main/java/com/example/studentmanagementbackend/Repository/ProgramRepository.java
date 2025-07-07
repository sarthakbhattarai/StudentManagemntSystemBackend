package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    // List<Program> findByDepartment_DepartmentId(Long departmentId);
}
