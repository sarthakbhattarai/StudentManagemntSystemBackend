package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Payment;

public interface PaymentService {
    Payment create(Payment payment);
    Payment getById(Long id);
    List<Payment> getAll();
    Payment update(Long id, Payment payment);
    void delete(Long id);
}
