package com.example.studentmanagementbackend.Service;

import java.util.List;

import com.example.studentmanagementbackend.Model.Invoice;

public interface InvoiceService {
    Invoice create(Invoice invoice);
    Invoice getById(Long id);
    List<Invoice> getAll();
    Invoice update(Long id, Invoice invoice);
    void delete(Long id);
}
