package com.one.literalura.controller;

import com.one.literalura.model.Author;
import com.one.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query(value = "SELECT * FROM authors", nativeQuery = true)
    Optional<List<Author>> showAllAuthors();

    @Query(value = "SELECT * FROM authors a WHERE a.nacimiento <= :year AND a.fallecimiento >= :year", nativeQuery = true)
    Optional<List<Author>> showAuthorsAlive(@Param("year") int year);
}
