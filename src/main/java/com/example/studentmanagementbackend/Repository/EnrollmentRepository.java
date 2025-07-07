package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // List<Enrollment> findByStudent_StudentId(UUID studentId);
}
