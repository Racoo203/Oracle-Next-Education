package com.one.literalura.view;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.literalura.controller.AuthorRepository;
import com.one.literalura.controller.BookRepository;
import com.one.literalura.controller.QueriesAPI;
import com.one.literalura.model.Author;
import com.one.literalura.model.Book;
import com.one.literalura.model.DataBook;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public final String BASE_URL = "http://gutendex.com/books/?";
    public Scanner scanner = new Scanner(System.in);
    public BookRepository bookRepository;
    public AuthorRepository authorRepository;

    public Menu(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {
        String opcion = "";

        String menu =
            """
            Selecciona una opcion:
            
            (1) - Búsqueda de libro por título
            (2) - Lista de todos los libros
            (3) - Lista de autores
            (4) - Listar autores vivos en determinado año
            (5) - Exhibir cantidad de libros en un determinado idioma
            
            (*) - Finalizar
            """;

        while (!opcion.equals("*")) {
            System.out.println(menu);
            opcion = scanner.nextLine();
            Optional<List<Book>> queryResultBooks;
            Optional<List<Author>> queryResultAuthors;



            switch (opcion) {
                case "1":
                    searchBookTitle();
                    break;
                case "2":
                    queryResultBooks = bookRepository.showAllBooks();
                    if (queryResultBooks.isPresent()) {
                        queryResultBooks.get().forEach(System.out::println);
                    } else {
                        System.out.println("No hay lista por mostrar.");
                    }
                    break;
                case "3":
                    queryResultAuthors = authorRepository.showAllAuthors();
                    if (queryResultAuthors.isPresent()) {
                        queryResultAuthors.get().forEach(System.out::println);
                    } else {
                        System.out.println("No hay lista por mostrar.");
                    }
                    break;
                case "4":
                    System.out.println("Ingresa el año determinado:");
                    int year = Integer.parseInt(scanner.nextLine());
                    queryResultAuthors = authorRepository.showAuthorsAlive(year);
                    if (queryResultAuthors.isPresent()) {
                        queryResultAuthors.get().forEach(System.out::println);
                    } else {
                        System.out.println("No hay lista por mostrar.");
                    }
                    break;
                case "5":
                    Optional<List<String>> idiomas = bookRepository.showUniqueLanguages();
                    if (idiomas.isPresent()) {
                        idiomas.get()
                                .forEach(
                                    idioma -> System.out.printf("Para lenguaje %s, hay %d libros\n", idioma, bookRepository.showBooksInLanguage(idioma).get().size()
                                )
                        );
                    }

                    break;
                case "*":
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
            }

        }

    }

    private Book bookQuery(String url) {
        var jsonResponse = QueriesAPI.getJson(url);
        var jsonBook = "";

        try {
            JsonNode node = new ObjectMapper().readTree(jsonResponse);
            jsonBook = node.get("results").get(0).toString();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(jsonBook);
        var dataBook = QueriesAPI.mapJsonToClass(jsonBook, DataBook.class);
//        System.out.println(dataBook);
        return new Book(dataBook);
    }

    private void searchBookTitle() {
        System.out.println("Escribe el nombre del libro que buscas:");
        String book_title = scanner.nextLine();
        book_title = "search=" + book_title.replace(" ", "+").toLowerCase();
        Book tempBook = bookQuery(BASE_URL + book_title);
        Author tempAuthor = tempBook.getAutor();

        authorRepository.save(tempAuthor);
        bookRepository.save(tempBook);

        System.out.println(tempBook);
    }

}
