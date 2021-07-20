package com.codegym.model.service;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
}
