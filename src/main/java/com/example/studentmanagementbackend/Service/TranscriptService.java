package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Transcript;

public interface TranscriptService {
    Transcript create(Transcript transcript);
    Transcript getById(Long id);
    List<Transcript> getAll();
    Transcript update(Long id, Transcript transcript);
    void delete(Long id);
}
