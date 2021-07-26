package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.Blogrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private Blogrepository blogrepository;

    @Override
    public List<Blog> findAll() {
        return blogrepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogrepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        blogrepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogrepository.deleteById(id);
    }
}
