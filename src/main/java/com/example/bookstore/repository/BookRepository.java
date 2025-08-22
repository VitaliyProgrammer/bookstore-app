package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String Isbn);

    List<Book> findByAuthor(String author);

    List<Book> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Book> findByTitleIgnoreCase(String title);
}
