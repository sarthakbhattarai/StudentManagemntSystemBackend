package com.example.studentmanagementbackend.DTO.Student;

import com.example.studentmanagementbackend.Model.Student.EnrollmentStatus;


public class RegisterStudentRequest {
    private String username;
    private String email;
    private String password;
    private Integer enrollmentYear;
    private Long programId;
    private EnrollmentStatus status;


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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnrollmentYear() {
        return this.enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Long getProgramId() {
        return this.programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public EnrollmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

}
