package com.example.studentmanagementbackend.DTO.Student;

import java.util.UUID;

import com.example.studentmanagementbackend.Model.Student.EnrollmentStatus;

public class StudentResponse {
    private UUID studentId;
    private String username;
    private String email;
    private Integer enrollmentYear;
    private String programName;
    private EnrollmentStatus status;


    public UUID getStudentId() {
        return this.studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
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

    public Integer getEnrollmentYear() {
        return this.enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getProgramName() {
        return this.programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public EnrollmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }


}
