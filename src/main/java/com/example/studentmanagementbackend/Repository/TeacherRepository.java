package com.example.studentmanagementbackend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    // e.g. List<Teacher> findByDepartment_DepartmentId(Long departmentId);
}