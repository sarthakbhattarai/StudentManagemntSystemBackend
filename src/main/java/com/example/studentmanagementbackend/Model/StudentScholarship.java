package com.example.studentmanagementbackend.Model;

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "student_scholarships")
public class StudentScholarship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentScholarshipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scholarship_id")
    private Scholarship scholarship;

    private LocalDate awardedOn;
    private BigDecimal amount;


    public Long getStudentScholarshipId() {
        return this.studentScholarshipId;
    }

    public void setStudentScholarshipId(Long studentScholarshipId) {
        this.studentScholarshipId = studentScholarshipId;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Scholarship getScholarship() {
        return this.scholarship;
    }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
    }

    public LocalDate getAwardedOn() {
        return this.awardedOn;
    }

    public void setAwardedOn(LocalDate awardedOn) {
        this.awardedOn = awardedOn;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
