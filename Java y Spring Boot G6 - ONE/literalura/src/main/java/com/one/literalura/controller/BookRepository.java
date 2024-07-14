package com.one.literalura.controller;

import com.one.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "SELECT * FROM books", nativeQuery = true)
    Optional<List<Book>> showAllBooks();

    @Query(value = "SELECT * FROM books b WHERE b.idioma = :lang", nativeQuery = true)
    Optional<List<Book>> showBooksInLanguage(@Param("lang") String lang);

    @Query(value = "SELECT DISTINCT idioma FROM books", nativeQuery = true)
    Optional<List<String>> showUniqueLanguages();

}
