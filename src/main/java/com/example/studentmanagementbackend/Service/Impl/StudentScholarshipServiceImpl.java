package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.StudentScholarship;
import com.example.studentmanagementbackend.Repository.StudentScholarshipRepository;
import com.example.studentmanagementbackend.Service.StudentScholarshipService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentScholarshipServiceImpl implements StudentScholarshipService {
    private final StudentScholarshipRepository repository;

    @Override
    public StudentScholarship create(StudentScholarship ss) {
        return repository.save(ss);
    }

    @Override
    public StudentScholarship getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("StudentScholarship not found: " + id));
    }

    @Override
    public List<StudentScholarship> getAll() {
        return repository.findAll();
    }

    @Override
    public StudentScholarship update(Long id, StudentScholarship ss) {
        ss.setStudentScholarshipId(id);
        return repository.save(ss);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
