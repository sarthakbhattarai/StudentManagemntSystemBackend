package com.example.studentmanagementbackend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    // e.g. find all by program
    // List<Student> findByProgram_ProgramId(Long programId);
}
