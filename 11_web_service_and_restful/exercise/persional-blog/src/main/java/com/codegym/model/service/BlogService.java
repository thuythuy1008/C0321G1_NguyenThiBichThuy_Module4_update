package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    Optional<Blog> findById(Long id);

    List<Blog> findAll();

    List<Blog> findAllByCategory_Id(Long id);
}
