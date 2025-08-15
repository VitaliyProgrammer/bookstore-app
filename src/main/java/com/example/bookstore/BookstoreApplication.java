package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
    private final BookService bookService;

    public BookstoreApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {

        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("The Lord of the Rings", "John R.R. Tolkien", "4412009957",
                new BigDecimal(49.99), "A book about war between good and evil", null);

        bookService.save(book);
        bookService.findAll().forEach(a -> System.out.println(a.getTitle()));
    }
}
