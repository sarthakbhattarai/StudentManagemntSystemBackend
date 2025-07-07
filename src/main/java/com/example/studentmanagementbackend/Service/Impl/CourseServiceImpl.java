package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Course;
import com.example.studentmanagementbackend.Repository.CourseRepository;
import com.example.studentmanagementbackend.Service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found: " + id));
    }

    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Course update(Long id, Course course) {
        Course existing = getById(id);
        existing.setCode(course.getCode());
        existing.setName(course.getName());
        existing.setCredits(course.getCredits());
        existing.setDepartment(course.getDepartment());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
