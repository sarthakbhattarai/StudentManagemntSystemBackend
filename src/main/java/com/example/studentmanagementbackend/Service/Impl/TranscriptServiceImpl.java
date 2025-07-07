package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Transcript;
import com.example.studentmanagementbackend.Repository.TranscriptRepository;
import com.example.studentmanagementbackend.Service.TranscriptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranscriptServiceImpl implements TranscriptService {
    private final TranscriptRepository repository;

    @Override
    public Transcript create(Transcript transcript) {
        return repository.save(transcript);
    }

    @Override
    public Transcript getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transcript not found: " + id));
    }

    @Override
    public List<Transcript> getAll() {
        return repository.findAll();
    }

    @Override
    public Transcript update(Long id, Transcript transcript) {
        transcript.setTranscriptId(id);
        return repository.save(transcript);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
