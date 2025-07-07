package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // List<Attendance> findByEnrollment_EnrollmentId(Long enrollmentId);
}
