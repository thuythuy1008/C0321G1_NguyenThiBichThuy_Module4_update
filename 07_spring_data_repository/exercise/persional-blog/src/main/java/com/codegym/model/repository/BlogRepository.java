package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByBlogNameContaining(String name);

    Iterable<Blog> findAllByCategory(Category category);
}
