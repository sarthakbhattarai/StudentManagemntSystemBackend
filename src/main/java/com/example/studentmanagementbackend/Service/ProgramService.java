package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.DTO.Program.ProgramRequest;
import com.example.studentmanagementbackend.DTO.Program.ProgramResponse;
import com.example.studentmanagementbackend.Model.Program;

public interface ProgramService {
    ProgramResponse create(ProgramRequest request);
    ProgramResponse getById(Long id);
    List<ProgramResponse> getAll();
    ProgramResponse update(Long id, ProgramRequest request);
    void delete(Long id);
    Program getEntityById(Long id);
}
