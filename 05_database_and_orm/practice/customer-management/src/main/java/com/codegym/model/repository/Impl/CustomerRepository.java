package com.codegym.model.repository.Impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(customer);
        transaction.commit();
    }

    @Override
    public List<Customer> findAll() {
        return BaseRepository.entityManager.createQuery(
                "select c " +
                        "from customer c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }
}
