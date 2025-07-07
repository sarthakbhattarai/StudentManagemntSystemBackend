package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Schedule;

public interface ScheduleService {
    Schedule create(Schedule schedule);
    Schedule getById(Long id);
    List<Schedule> getAll();
    Schedule update(Long id, Schedule schedule);
    void delete(Long id);
}
