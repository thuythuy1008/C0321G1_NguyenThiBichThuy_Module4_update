package com.codegym.model.repository.employee;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where employee.employee_name like %?1% and flag = 0", nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);

//    Employee findByEmployeeNameContaining(String name);
}
