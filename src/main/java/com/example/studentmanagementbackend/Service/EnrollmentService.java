package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Enrollment;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollment);
    Enrollment getById(Long id);
    List<Enrollment> getAll();
    Enrollment update(Long id, Enrollment enrollment);
    void delete(Long id);
}
