package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    Page<Blog> findByBlogName(Pageable pageable, String name);

    Optional<Blog> findById(Long id);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllByCategory_Id(Long id);

    List<Blog> findByName(String name);
}
