package com.example.studentmanagementbackend.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagementbackend.DTO.Program.ProgramRequest;
import com.example.studentmanagementbackend.DTO.Program.ProgramResponse;
import com.example.studentmanagementbackend.Service.ProgramService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService programService;

    @PostMapping
    public ResponseEntity<ProgramResponse> create(@Valid @RequestBody ProgramRequest request) {
        System.out.println("Incoming departmentId = " + request.getDepartmentId());
        return ResponseEntity.status(201).body(programService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(programService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProgramResponse>> getAll() {
        return ResponseEntity.ok(programService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramResponse> update(@PathVariable Long id,
            @Valid @RequestBody ProgramRequest request) {
        return ResponseEntity.ok(programService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        programService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
