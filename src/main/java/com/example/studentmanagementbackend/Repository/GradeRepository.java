package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    // List<Grade> findByEnrollment_EnrollmentId(Long enrollmentId);
}
