package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

    Page<Customer> findByCustomerName(Pageable pageable, String name);
}
