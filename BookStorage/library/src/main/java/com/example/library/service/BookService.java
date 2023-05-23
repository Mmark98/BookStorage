package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book save(Book book) {
        return book;
    }

    public Optional<Object> findById(Long id) {
        Optional<Object> o = Optional.empty();
        return o;
    }

    public Optional<Object> update(Long id, Book updatedBook) {
        Optional<Object> o = Optional.empty();
        return o;
    }

    public void delete(Long id) {

    }

}
