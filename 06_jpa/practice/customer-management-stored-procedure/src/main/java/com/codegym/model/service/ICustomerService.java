package com.codegym.model.service;

import com.codegym.model.bean.Customer;

public interface ICustomerService {
    void insertWithStoredProcedure(Customer customer);
}
