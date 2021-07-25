package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByBlogNameContaining(Pageable pageable, String name);

    Iterable<Blog> findAllByCategory(Category category);

//    @Query(value = "select * " +
//            "from blogs " +
//            "where blog_name like :nameParam", nativeQuery = true)
//    Page<Blog> getBlogBySearchingName(Pageable pageable,
//                                         @Param("nameParam") String name);
}
