package com.codegym.model.repository.employee;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);
}
