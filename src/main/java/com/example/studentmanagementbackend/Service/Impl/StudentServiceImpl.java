package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Student;
import com.example.studentmanagementbackend.Repository.StudentRepository;
import com.example.studentmanagementbackend.Service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student not found: " + id));
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student update(UUID id, Student student) {
        student.setStudentId(id);
        return repository.save(student);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
