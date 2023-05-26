package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ez az osztály a Spring Security beállításait konfigurálja.
 * Az @EnableWebSecurity annotációval jelöljük, hogy ezt az osztályt
 * használjuk a biztonsági konfigurációhoz.
 */

public interface BookRepository
        extends JpaRepository<Book, Long> {

}
