package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escribe el nombre de la pelicula: ");
            String titulo = scanner.nextLine();
            titulo = titulo.replace(" ", "+");
            String clave = "9a52772e";

            String url = "https://www.omdbapi.com/?t=" + titulo + "&apikey=" + clave;

            try {

                if(titulo.equalsIgnoreCase("salir")) {
                    break;
                }

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


                TituloOMDB miTituloOMDB = gson.fromJson(json, TituloOMDB.class);
                Titulo miTitulo = new Titulo(miTituloOMDB);
                System.out.println("Titulo: " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);
        FileWriter writer = new FileWriter("titulos.json");
        writer.write(gson.toJson(titulos));
        writer.close();
        System.out.println("Finalizó la ejecución del programa!");
    }
}
