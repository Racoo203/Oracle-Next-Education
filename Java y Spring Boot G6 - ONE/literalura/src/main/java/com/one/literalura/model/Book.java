package com.one.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    // Asumimos que los libros solo tienen un idioma.
    private String idioma;
    private Integer descargas;
    // Asumimos que los libros solo tienen un autor.
    @ManyToOne
    private Author autor;

    public Book() {}

    public Book(DataBook dataBook) {
        this.titulo = dataBook.titulo();
        this.idioma = dataBook.idiomas().getFirst();
        this.descargas = dataBook.descargas();
        this.autor = new Author(dataBook.autores().getFirst());
    }

    @Override
    public String toString() {
        return "====== BOOK ======" + "\n" +
                "TITULO: " + titulo + "\n" +
                "AUTOR: " + autor.getNombre() + "\n" +
                "IDIOMA: " + idioma + "\n" +
                "DESCARGAS: " + descargas + "\n" +
                "==================";
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}
