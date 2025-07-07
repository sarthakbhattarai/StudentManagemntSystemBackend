package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.CourseSection;

public interface CourseSectionRepository extends JpaRepository<CourseSection, Long> {
    // List<CourseSection> findBySemesterAndYear(Semester semester, Integer year);
}
