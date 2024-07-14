package com.one.literalura;

import com.one.literalura.controller.AuthorRepository;
import com.one.literalura.controller.BookRepository;
import com.one.literalura.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	public BookRepository bookRepository;
	@Autowired
	public AuthorRepository authorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(bookRepository, authorRepository);
		menu.showMenu();
	}
}
