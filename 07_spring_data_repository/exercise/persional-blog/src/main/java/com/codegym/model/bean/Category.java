package com.codegym.model.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category() {
    }

    public Category(Long id, String categoryName, List<Blog> blogs) {
        this.id = id;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
