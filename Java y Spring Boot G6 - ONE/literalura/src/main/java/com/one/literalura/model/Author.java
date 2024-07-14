package com.one.literalura.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private Integer nacimiento;
    private Integer fallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> libros;

    public Author() {}

    public Author(DataAuthor dataAuthor) {
        this.nombre = dataAuthor.nombre();
        this.nacimiento = dataAuthor.nacimiento();
        this.fallecimiento = dataAuthor.fallecimiento();
    }

    @Override
    public String toString() {
        return "====== AUTOR ======" + "\n" +
                "NOMBRE: " + nombre + "\n" +
                "AÑO DE NACIMIENTO: " + nacimiento + "\n" +
                "AÑO DE FALLECIMIENTO: " + fallecimiento + "\n" +
                "===================";
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<Book> getLibros() {
        return libros;
    }

    public void setLibros(List<Book> libros) {
        libros.forEach(libro -> libro.setAutor(this));
        this.libros = libros;
    }
}
