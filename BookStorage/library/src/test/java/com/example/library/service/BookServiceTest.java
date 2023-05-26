package com.example.library.service;

import com.example.library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/* void save() {*/
    @SpringBootTest
    public class BookServiceTest {
      /* @Test
       void findAll() {
       }*/


        @Autowired
        private BookService bookService;

        @Test
        protected void testAddBook() {
            Book book = new Book();
            book.setTitle("Teszt Konyv");
            book.setAuthor("Teszt Szerzo");
            book.setIsbn("123-456-789");

            Book savedBook = bookService.save(book);

            assertNotNull(savedBook.getId());
            assertEquals(book.getTitle(), savedBook.getTitle());
            assertEquals(book.getAuthor(), savedBook.getAuthor());
            assertEquals(book.getIsbn(), savedBook.getIsbn());
        }

        // Hasznos lehet további teszteseteket is írni, mint például:
        // - teszt a findById() metódushoz: mi történik, ha létező és nem létező ID-val hívod meg?
        // - teszt a delete() metódushoz: mi történik, ha létező és nem létező ID-val hívod meg?


   /* @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {

    }*/
    }
