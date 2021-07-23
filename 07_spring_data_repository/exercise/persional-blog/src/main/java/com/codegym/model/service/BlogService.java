package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Long id);

    List<Blog> findByName(String name);

    Iterable<Blog> findAllByCategory(Category category);
}
