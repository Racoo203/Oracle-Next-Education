package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.models.*;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConversorDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConversorDatos conversorDatos = new ConversorDatos();

    private final String URL_BASE = "https://www.omdbapi.com/";
    private final String API_KEY = "&apikey=9a52772e";

    private List<DatosSerie> datosSeries = new ArrayList<>();

    public void mostrarMenu() {
        // BUSCAR DATOS GENERALES DE LA SERIE
        int opcion = -1;

        while (opcion != 0) {
            var menu =
            """
            (1) - Buscar Series
            (2) - Buscar Episodios
            (3) - Mostrar Historial de Series
            
            (0) - Salir
            """;

            System.out.println(menu);

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioDeSerie();
                    break;
                case 3:
                    mostrarHistorialSeries();
                    break;
                case 0:
                    System.out.println("Cerrando aplicacion");
                    break;
                default:
                    System.out.println("Opción invalida.");

            }
        }

    }

    private void mostrarHistorialSeries() {
        List<Serie> series = new ArrayList<>();
        series = datosSeries.stream()
                .map(datosSerie -> new Serie(datosSerie))
                .collect(Collectors.toList());


        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);

    }

    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el Nombre de la Serie:");
        String titulo = "?t=" + scanner.nextLine();
        titulo = titulo.replace(" ", "+");

        var urlSerie = URL_BASE + titulo + API_KEY;

        var jsonSerie = consumoAPI.obtenerDatos(urlSerie);

        System.out.println(jsonSerie);
        return conversorDatos.obtenerDatos(jsonSerie, DatosSerie.class);
    }
    private void buscarEpisodioDeSerie() {
        DatosSerie datosSerie = getDatosSerie();
        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datosSerie.totalDeTemporadas(); i++) {
            String numTemporada = "&Season=" + i;
            String titulo = "?t=" + datosSerie.titulo();
            titulo = titulo.replace(" ", "+");

            var urlTemporada = URL_BASE + titulo + numTemporada + API_KEY;
            var jsonTemporada = consumoAPI.obtenerDatos(urlTemporada);

            var datosTemporada = conversorDatos.obtenerDatos(jsonTemporada, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }

        temporadas.forEach(System.out::println);
    }

    private void buscarSerieWeb() {

        DatosSerie datosSerie = getDatosSerie();
        datosSeries.add(datosSerie);
        System.out.println(datosSerie);

    }

}
