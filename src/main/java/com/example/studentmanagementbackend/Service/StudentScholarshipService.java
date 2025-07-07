package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.StudentScholarship;

public interface StudentScholarshipService {
    StudentScholarship create(StudentScholarship ss);
    StudentScholarship getById(Long id);
    List<StudentScholarship> getAll();
    StudentScholarship update(Long id, StudentScholarship ss);
    void delete(Long id);
}
