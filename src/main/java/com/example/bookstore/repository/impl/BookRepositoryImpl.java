package com.example.bookstore.repository.impl;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> findAll() {

        return new ArrayList<>(books);
    }
}
