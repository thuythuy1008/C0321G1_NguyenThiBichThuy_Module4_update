package com.codegym.model.repository;

import com.codegym.model.bean.Customer;

public interface ICustomerRepository {
    void insertWithStoredProcedure(Customer customer);
}
