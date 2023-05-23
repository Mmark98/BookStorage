package com.example.library.controller;

import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // további végpontok, mint például a könyv létrehozása, frissítése és törlése
    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }
    // Könyvek listázása
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
    // Új könyv létrehozása
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }
    // Könyv adatainak lekérése
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return (Book) bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException("A könyv nem található az adott ID-val: " + id));
    }
    // Könyv adatainak frissítése
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return (Book) bookService.update(id, updatedBook)
                .orElseThrow(() -> new BookNotFoundException("A könyv nem található az adott ID-val: " + id));
    }
    // Könyv törlése
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}
