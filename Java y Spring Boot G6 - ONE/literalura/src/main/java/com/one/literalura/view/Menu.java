package com.one.literalura.view;

import com.one.literalura.controller.QueriesAPI;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public final String BASE_URL = "http://gutendex.com/books/";
    public Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        String opcion = "";

        String menu =
            """
            Selecciona una opcion:
            
            (1) - Algo lol
            
            (*) - Finalizar     
            """;

        while (!opcion.equals("*")) {
            System.out.println(menu);
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("hola");
                    break;
                case "*":
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
            }

        }






    }

    public void optionSelection() {







    }

}
