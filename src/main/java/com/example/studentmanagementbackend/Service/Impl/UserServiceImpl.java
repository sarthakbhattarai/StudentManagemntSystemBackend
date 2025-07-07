package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.User;
import com.example.studentmanagementbackend.Repository.UserRepository;
import com.example.studentmanagementbackend.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User update(UUID id, User user) {
        user.setUserId(id);
        return repository.save(user);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
