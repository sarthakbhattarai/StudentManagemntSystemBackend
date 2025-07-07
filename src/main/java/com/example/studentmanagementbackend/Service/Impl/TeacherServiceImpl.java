package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Teacher;
import com.example.studentmanagementbackend.Repository.TeacherRepository;
import com.example.studentmanagementbackend.Service.TeacherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    @Override
    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Teacher not found: " + id));
    }

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher update(UUID id, Teacher teacher) {
        teacher.setTeacherId(id);
        return repository.save(teacher);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
