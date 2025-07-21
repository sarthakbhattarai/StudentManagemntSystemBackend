package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.DTO.Dept.DepartmentRequest;
import com.example.studentmanagementbackend.DTO.Dept.DepartmentResponse;
import com.example.studentmanagementbackend.Model.Department;
import com.example.studentmanagementbackend.Repository.DepartmentRepository;
import com.example.studentmanagementbackend.Service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Department getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found: " + id));
    }

    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        Department department = Department.builder()
                .code(request.getCode())
                .name(request.getName())
                .build();

        Department saved = repository.save(department);
        return mapToResponse(saved);
    }

    @Override
    public List<DepartmentResponse> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Department update(Long id, Department dept) {
        Department existing = getById(id);
        existing.setCode(dept.getCode());
        existing.setName(dept.getName());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DepartmentResponse mapToResponse(Department dept) {
        return DepartmentResponse.builder()
                .id(dept.getDepartmentId())
                .code(dept.getCode())
                .name(dept.getName())
                .build();
    }

}
