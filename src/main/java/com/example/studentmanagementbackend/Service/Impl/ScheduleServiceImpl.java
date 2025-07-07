package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Schedule;
import com.example.studentmanagementbackend.Repository.ScheduleRepository;
import com.example.studentmanagementbackend.Service.ScheduleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository repository;

    @Override
    public Schedule create(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public Schedule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Schedule not found: " + id));
    }

    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @Override
    public Schedule update(Long id, Schedule schedule) {
        schedule.setScheduleId(id);
        return repository.save(schedule);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
