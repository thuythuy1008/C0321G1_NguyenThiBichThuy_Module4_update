package com.codegym.model.repository;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
}
