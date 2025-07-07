package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.CourseSection;

public interface CourseSectionService {
    CourseSection create(CourseSection section);
    CourseSection getById(Long id);
    List<CourseSection> getAll();
    CourseSection update(Long id, CourseSection section);
    void delete(Long id);
}
