package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Scholarship;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
    // Optional<Scholarship> findByName(String name);
}
