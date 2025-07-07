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

import com.example.studentmanagementbackend.Model.CourseSection;
import com.example.studentmanagementbackend.Service.CourseSectionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class CourseSectionController {
    private final CourseSectionService sectionService;

    @PostMapping
    public ResponseEntity<CourseSection> create(@RequestBody CourseSection section) {
        return ResponseEntity.ok(sectionService.create(section));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseSection> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sectionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseSection>> getAll() {
        return ResponseEntity.ok(sectionService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseSection> update(@PathVariable Long id, @RequestBody CourseSection section) {
        return ResponseEntity.ok(sectionService.update(id, section));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sectionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
