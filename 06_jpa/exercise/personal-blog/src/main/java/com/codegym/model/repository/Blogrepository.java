package com.codegym.model.repository;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface Blogrepository {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
