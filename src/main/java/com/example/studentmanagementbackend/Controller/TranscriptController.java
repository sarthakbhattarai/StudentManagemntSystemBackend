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

import com.example.studentmanagementbackend.Model.Transcript;
import com.example.studentmanagementbackend.Service.TranscriptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transcripts")
@RequiredArgsConstructor
public class TranscriptController {
    private final TranscriptService transcriptService;

    @PostMapping
    public ResponseEntity<Transcript> create(@RequestBody Transcript t) {
        return ResponseEntity.ok(transcriptService.create(t));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transcript> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transcriptService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Transcript>> getAll() {
        return ResponseEntity.ok(transcriptService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transcript> update(@PathVariable Long id, @RequestBody Transcript t) {
        return ResponseEntity.ok(transcriptService.update(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transcriptService.delete(id);
        return ResponseEntity.ok().build();
    }
}
