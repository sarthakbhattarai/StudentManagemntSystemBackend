package com.example.studentmanagementbackend.Service;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagementbackend.Model.User;

public interface UserService {
    User create(User user);
    User getById(UUID id);
    List<User> getAll();
    User update(UUID id, User user);
    void delete(UUID id);
}
