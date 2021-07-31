package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByBlogNameContaining(Pageable pageable, String name);

    List<Blog> findAllByCategory_Id(Long id);
    List<Blog> findAllByBlogNameContaining(String name);
}
