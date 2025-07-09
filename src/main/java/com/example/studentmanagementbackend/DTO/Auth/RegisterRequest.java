package com.example.studentmanagementbackend.DTO.Auth;

import com.example.studentmanagementbackend.Model.Role.RoleName;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private RoleName role;


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

    public RoleName getRole() {
        return this.role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

}
