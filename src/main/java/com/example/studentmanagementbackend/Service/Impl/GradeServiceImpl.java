package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Grade;
import com.example.studentmanagementbackend.Repository.GradeRepository;
import com.example.studentmanagementbackend.Service.GradeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository repository;

    @Override
    public Grade create(Grade grade) {
        return repository.save(grade);
    }

    @Override
    public Grade getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Grade not found: " + id));
    }

    @Override
    public List<Grade> getAll() {
        return repository.findAll();
    }

    @Override
    public Grade update(Long id, Grade grade) {
        grade.setGradeId(id);
        return repository.save(grade);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
