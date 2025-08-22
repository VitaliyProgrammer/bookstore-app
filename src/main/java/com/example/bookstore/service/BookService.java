package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);

    void delete(Long id);
}
