package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Grade;

public interface GradeService {
    Grade create(Grade grade);
    Grade getById(Long id);
    List<Grade> getAll();
    Grade update(Long id, Grade grade);
    void delete(Long id);
}
