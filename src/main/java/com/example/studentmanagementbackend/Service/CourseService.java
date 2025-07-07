package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Course;

public interface CourseService {
    Course create(Course course);
    Course getById(Long id);
    List<Course> getAll();
    Course update(Long id, Course course);
    void delete(Long id);
}
