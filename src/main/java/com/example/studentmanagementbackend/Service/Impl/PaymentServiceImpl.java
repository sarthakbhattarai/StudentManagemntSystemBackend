package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Payment;
import com.example.studentmanagementbackend.Repository.PaymentRepository;
import com.example.studentmanagementbackend.Service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found: " + id));
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }

    @Override
    public Payment update(Long id, Payment payment) {
        payment.setPaymentId(id);
        return repository.save(payment);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
