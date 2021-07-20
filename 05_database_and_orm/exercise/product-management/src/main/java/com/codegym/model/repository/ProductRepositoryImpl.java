package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class, id);
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>(BaseRepository.entityManager.createQuery(
                "select p " +
                        "from Product p", Product.class).getResultList());
        List<Product> arrayList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                arrayList.add(product);
            }
        }
        return arrayList;
    }
}
