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

import com.example.studentmanagementbackend.Model.StudentScholarship;
import com.example.studentmanagementbackend.Service.StudentScholarshipService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student-scholarships")
@RequiredArgsConstructor
public class StudentScholarshipController {
    private final StudentScholarshipService ssService;

    @PostMapping
    public ResponseEntity<StudentScholarship> create(@RequestBody StudentScholarship ss) {
        return ResponseEntity.ok(ssService.create(ss));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentScholarship> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ssService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentScholarship>> getAll() {
        return ResponseEntity.ok(ssService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentScholarship> update(@PathVariable Long id, @RequestBody StudentScholarship ss) {
        return ResponseEntity.ok(ssService.update(id, ss));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ssService.delete(id);
        return ResponseEntity.ok().build();
    }
}
