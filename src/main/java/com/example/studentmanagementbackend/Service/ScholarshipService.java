package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Scholarship;

public interface ScholarshipService {
    Scholarship create(Scholarship scholarship);
    Scholarship getById(Long id);
    List<Scholarship> getAll();
    Scholarship update(Long id, Scholarship scholarship);
    void delete(Long id);
}
