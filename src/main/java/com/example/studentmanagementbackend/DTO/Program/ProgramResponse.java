package com.example.studentmanagementbackend.DTO.Program;

import com.example.studentmanagementbackend.Model.Program.DegreeLevel;

import lombok.Builder;

@Builder
public class ProgramResponse {
    private Long id;
    private String name;
    private DegreeLevel degreeLevel;
    private Integer totalCreditsRequired;
    private Long departmentId;
    private String departmentName;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
