package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Enrollment;
import com.example.studentmanagementbackend.Repository.EnrollmentRepository;
import com.example.studentmanagementbackend.Service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repository;

    @Override
    public Enrollment create(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public Enrollment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Enrollment not found: " + id));
    }

    @Override
    public List<Enrollment> getAll() {
        return repository.findAll();
    }

    @Override
    public Enrollment update(Long id, Enrollment enrollment) {
        enrollment.setEnrollmentId(id);
        return repository.save(enrollment);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
