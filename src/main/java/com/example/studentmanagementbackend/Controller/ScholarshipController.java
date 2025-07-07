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

import com.example.studentmanagementbackend.Model.Scholarship;
import com.example.studentmanagementbackend.Service.ScholarshipService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scholarships")
@RequiredArgsConstructor
public class ScholarshipController {
    private final ScholarshipService scholarshipService;

    @PostMapping
    public ResponseEntity<Scholarship> create(@RequestBody Scholarship s) {
        return ResponseEntity.ok(scholarshipService.create(s));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scholarship> getById(@PathVariable Long id) {
        return ResponseEntity.ok(scholarshipService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Scholarship>> getAll() {
        return ResponseEntity.ok(scholarshipService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scholarship> update(@PathVariable Long id, @RequestBody Scholarship s) {
        return ResponseEntity.ok(scholarshipService.update(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scholarshipService.delete(id);
        return ResponseEntity.ok().build();
    }
}
