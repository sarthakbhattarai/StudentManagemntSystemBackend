package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // List<Invoice> findByStudent_StudentId(UUID studentId);
}
