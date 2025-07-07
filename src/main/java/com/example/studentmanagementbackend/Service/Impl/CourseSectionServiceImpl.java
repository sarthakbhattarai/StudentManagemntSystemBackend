package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.CourseSection;
import com.example.studentmanagementbackend.Repository.CourseSectionRepository;
import com.example.studentmanagementbackend.Service.CourseSectionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseSectionServiceImpl implements CourseSectionService {
    private final CourseSectionRepository repository;

    @Override
    public CourseSection create(CourseSection section) {
        return repository.save(section);
    }

    @Override
    public CourseSection getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Section not found: " + id));
    }

    @Override
    public List<CourseSection> getAll() {
        return repository.findAll();
    }

    @Override
    public CourseSection update(Long id, CourseSection section) {
        section.setSectionId(id);
        return repository.save(section);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
