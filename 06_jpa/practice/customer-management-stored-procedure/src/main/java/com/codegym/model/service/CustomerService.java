package com.codegym.model.service;

import com.codegym.model.bean.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        customerRepository.insertWithStoredProcedure(customer);
    }
}
