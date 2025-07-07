package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Program;
import com.example.studentmanagementbackend.Repository.ProgramRepository;
import com.example.studentmanagementbackend.Service.ProgramService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository repository;

    @Override
    public Program create(Program program) {
        return repository.save(program);
    }

    @Override
    public Program getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Program not found: " + id));
    }

    @Override
    public List<Program> getAll() {
        return repository.findAll();
    }

    @Override
    public Program update(Long id, Program program) {
        Program existing = getById(id);
        existing.setName(program.getName());
        existing.setDegreeLevel(program.getDegreeLevel());
        existing.setTotalCreditsRequired(program.getTotalCreditsRequired());
        existing.setDepartment(program.getDepartment());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
