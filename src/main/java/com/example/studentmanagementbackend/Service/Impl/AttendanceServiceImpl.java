package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Attendance;
import com.example.studentmanagementbackend.Repository.AttendanceRepository;
import com.example.studentmanagementbackend.Service.AttendanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository repository;

    @Override
    public Attendance create(Attendance attendance) {
        return repository.save(attendance);
    }

    @Override
    public Attendance getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Attendance not found: " + id));
    }

    @Override
    public List<Attendance> getAll() {
        return repository.findAll();
    }

    @Override
    public Attendance update(Long id, Attendance attendance) {
        attendance.setAttendanceId(id);
        return repository.save(attendance);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
