package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // List<Schedule> findBySection_SectionId(Long sectionId);
}
