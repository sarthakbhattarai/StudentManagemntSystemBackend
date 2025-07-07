package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Program;

public interface ProgramService {
    Program create(Program program);
    Program getById(Long id);
    List<Program> getAll();
    Program update(Long id, Program program);
    void delete(Long id);
}
