package com.example.studentmanagementbackend.DTO.Program;

import com.example.studentmanagementbackend.Model.Program.DegreeLevel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProgramRequest {
    @NotBlank(message = "Program name is required")
    private String name;

    @NotNull(message = "Degree level is required")
    private DegreeLevel degreeLevel;

    @NotNull(message = "Total credits required is required")
    @Min(value = 1, message = "Credits must be at least 1")
    private Integer totalCreditsRequired;

    @NotNull(message = "Department ID is required")
    private Long departmentId;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DegreeLevel getDegreeLevel() {
        return this.degreeLevel;
    }

    public void setDegreeLevel(DegreeLevel degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public Integer getTotalCreditsRequired() {
        return this.totalCreditsRequired;
    }

    public void setTotalCreditsRequired(Integer totalCreditsRequired) {
        this.totalCreditsRequired = totalCreditsRequired;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}
