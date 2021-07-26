package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void deleteById(Long id);
}
