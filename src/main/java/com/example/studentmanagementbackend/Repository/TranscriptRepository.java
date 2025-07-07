package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
    // List<Transcript> findByStudent_StudentId(UUID studentId);
}
