package com.example.studentmanagementbackend.DTO.Teacher;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


public class TeacherResponse {
    private UUID teacherId;
    private String username;
    private String email;
    private String departmentName;
    private LocalDate hireDate;


    public UUID getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

}
