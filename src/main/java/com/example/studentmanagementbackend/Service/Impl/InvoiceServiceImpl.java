package com.example.studentmanagementbackend.Service.Impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.studentmanagementbackend.Model.Invoice;
import com.example.studentmanagementbackend.Repository.InvoiceRepository;
import com.example.studentmanagementbackend.Service.InvoiceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository repository;

    @Override
    public Invoice create(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public Invoice getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Invoice not found: " + id));
    }

    @Override
    public List<Invoice> getAll() {
        return repository.findAll();
    }

    @Override
    public Invoice update(Long id, Invoice invoice) {
        invoice.setInvoiceId(id);
        return repository.save(invoice);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
