package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Scholarship;
import com.example.studentmanagementbackend.Repository.ScholarshipRepository;
import com.example.studentmanagementbackend.Service.ScholarshipService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScholarshipServiceImpl implements ScholarshipService {
    private final ScholarshipRepository repository;

    @Override
    public Scholarship create(Scholarship scholarship) {
        return repository.save(scholarship);
    }

    @Override
    public Scholarship getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Scholarship not found: " + id));
    }

    @Override
    public List<Scholarship> getAll() {
        return repository.findAll();
    }

    @Override
    public Scholarship update(Long id, Scholarship scholarship) {
        scholarship.setScholarshipId(id);
        return repository.save(scholarship);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
