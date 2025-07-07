package com.example.studentmanagementbackend.Service;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagementbackend.Model.Student;

public interface StudentService {
    Student create(Student student);
    Student getById(UUID id);
    List<Student> getAll();
    Student update(UUID id, Student student);
    void delete(UUID id);
}
