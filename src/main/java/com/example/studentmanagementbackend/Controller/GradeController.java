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

import com.example.studentmanagementbackend.Model.Grade;
import com.example.studentmanagementbackend.Service.GradeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> create(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.create(grade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gradeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAll() {
        return ResponseEntity.ok(gradeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> update(@PathVariable Long id, @RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.update(id, grade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gradeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
