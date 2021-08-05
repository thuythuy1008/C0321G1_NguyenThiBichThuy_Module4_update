package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.repository.customer.CustomerRepository;
import com.codegym.model.repository.customer.CustomerTypeRepository;
import com.codegym.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

//    @Override
//    public List<Customer> findAll() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Page<Customer> findAll(Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }

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

    @Override
    public List<CustomerType> findAllByCustomerType() {
        return customerTypeRepository.findAll();
    }
}
