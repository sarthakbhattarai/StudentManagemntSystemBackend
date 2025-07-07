package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.StudentScholarship;

public interface StudentScholarshipRepository extends JpaRepository<StudentScholarship, Long> {
    // List<StudentScholarship> findByStudent_StudentId(UUID studentId);
}
