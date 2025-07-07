package com.example.studentmanagementbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementbackend.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // List<Payment> findByInvoice_InvoiceId(Long invoiceId);
}
