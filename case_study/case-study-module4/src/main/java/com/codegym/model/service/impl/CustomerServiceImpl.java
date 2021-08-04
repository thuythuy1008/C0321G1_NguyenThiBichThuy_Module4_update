package com.codegym.model.service.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.CustomerRepository;
import com.codegym.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByCustomerName(Pageable pageable, String name) {
        return customerRepository.findAllByCustomerNameContaining(pageable, name);
    }
}
