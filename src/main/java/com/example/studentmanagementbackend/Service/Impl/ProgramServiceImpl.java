package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentmanagementbackend.DTO.Program.ProgramRequest;
import com.example.studentmanagementbackend.DTO.Program.ProgramResponse;
import com.example.studentmanagementbackend.Model.Department;
import com.example.studentmanagementbackend.Model.Program;
import com.example.studentmanagementbackend.Repository.DepartmentRepository;
import com.example.studentmanagementbackend.Repository.ProgramRepository;
import com.example.studentmanagementbackend.Service.ProgramService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository programRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public ProgramResponse create(ProgramRequest request) {
        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Program program = new Program();
        program.setName(request.getName());
        program.setDegreeLevel(request.getDegreeLevel());
        program.setTotalCreditsRequired(request.getTotalCreditsRequired());
        program.setDepartment(dept);

        return mapToResponse(programRepository.save(program));
    }

    @Override
    public ProgramResponse getById(Long id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));
        return mapToResponse(program);
    }

    @Override
    public List<ProgramResponse> getAll() {
        return programRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramResponse update(Long id, ProgramRequest request) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));

        Department dept = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        program.setName(request.getName());
        program.setDegreeLevel(request.getDegreeLevel());
        program.setTotalCreditsRequired(request.getTotalCreditsRequired());
        program.setDepartment(dept);

        return mapToResponse(programRepository.save(program));
    }

    @Override
    public void delete(Long id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Program not found"));
        programRepository.delete(program);
    }

    @Override
    public Program getEntityById(Long id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Program not found"));
    }

    private ProgramResponse mapToResponse(Program program) {
        Department dept = program.getDepartment();

        return ProgramResponse.builder()
                .id(program.getProgramId())
                .name(program.getName())
                .degreeLevel(program.getDegreeLevel())
                .totalCreditsRequired(program.getTotalCreditsRequired())
                .departmentId(dept != null ? dept.getDepartmentId() : null)
                .departmentName(dept != null ? dept.getName() : null)
                .build();
    }

}
