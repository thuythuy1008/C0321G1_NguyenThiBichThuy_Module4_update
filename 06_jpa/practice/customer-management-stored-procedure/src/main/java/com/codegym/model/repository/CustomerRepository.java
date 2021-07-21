package com.codegym.model.repository;

import com.codegym.model.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class CustomerRepository implements ICustomerRepository {

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = BaseRepository.entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        query.executeUpdate();
        transaction.commit();
    }
}
