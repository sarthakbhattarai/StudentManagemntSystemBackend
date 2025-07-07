package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Attendance;

public interface AttendanceService {
    Attendance create(Attendance attendance);
    Attendance getById(Long id);
    List<Attendance> getAll();
    Attendance update(Long id, Attendance attendance);
    void delete(Long id);
}
