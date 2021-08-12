package com.codegym.model.repository.customer;

import ch.qos.logback.core.boolex.EvaluationException;
import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "select * from customer where customer.customer_name like %?1% and flag = 0", nativeQuery = true)
//    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);

    @Query(value = "select * from customer where concat(customer_name,customer_id_card) like %:keyWord% and flag = 0", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String keyWord);
}
