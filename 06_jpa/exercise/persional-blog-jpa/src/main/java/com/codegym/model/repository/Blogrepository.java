package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Blogrepository extends JpaRepository<Blog, Long> {
}
