package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Optional<Course> findByCode(String code);
}
