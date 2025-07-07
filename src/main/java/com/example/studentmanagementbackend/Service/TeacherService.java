package com.example.studentmanagementbackend.Service;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagementbackend.Model.Teacher;

public interface TeacherService {
    Teacher create(Teacher teacher);
    Teacher getById(UUID id);
    List<Teacher> getAll();
    Teacher update(UUID id, Teacher teacher);
    void delete(UUID id);
}
