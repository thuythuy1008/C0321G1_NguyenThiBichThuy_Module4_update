package com.codegym.model.service;

import com.codegym.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void delete(Integer id);
}
