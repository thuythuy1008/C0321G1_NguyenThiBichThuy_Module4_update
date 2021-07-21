package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements Blogrepository {
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = BaseRepository.entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = BaseRepository.entityManager.createQuery("select b from Blog b where  b.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Blog blog) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        if (blog.getId() != null) {
            BaseRepository.entityManager.merge(blog);
        } else {
            BaseRepository.entityManager.persist(blog);
        }
        transaction.commit();
    }

    @Override
    public void remove(Long id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Blog blog = findById(id);
        if (blog != null) {
            BaseRepository.entityManager.remove(blog);
        }
        transaction.commit();
    }
}
