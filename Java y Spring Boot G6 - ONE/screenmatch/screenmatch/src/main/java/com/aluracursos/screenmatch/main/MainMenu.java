package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.models.DatosEpisodio;
import com.aluracursos.screenmatch.models.DatosSerie;
import com.aluracursos.screenmatch.models.DatosTemporada;
import com.aluracursos.screenmatch.models.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConversorDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConversorDatos conversorDatos = new ConversorDatos();

    private final String URL_BASE = "https://www.omdbapi.com/";
    private final String API_KEY = "&apikey=9a52772e";

    public void mostrarMenu() {
        // BUSCAR DATOS GENERALES DE LA SERIE
        System.out.println("Escribe el Nombre de la Serie:");
        String titulo = "?t=" + scanner.nextLine();
        titulo = titulo.replace(" ", "+");

        var urlSerie = URL_BASE + titulo + API_KEY;

        var jsonSerie = consumoAPI.obtenerDatos(urlSerie);
        var datosSerie = conversorDatos.obtenerDatos(jsonSerie, DatosSerie.class);

        System.out.println("##########################");
        System.out.println(datosSerie);
        System.out.println("##########################");


        // BUSCAR DATOS DE TODAS LAS TEMPORADAS DE LAS SERIE.

        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datosSerie.totalDeTemporadas(); i++) {
            String numTemporada = "&Season=" + i;
            var urlTemporada = URL_BASE + titulo + numTemporada + API_KEY;
            var jsonTemporada = consumoAPI.obtenerDatos(urlTemporada);

            var datosTemporada = conversorDatos.obtenerDatos(jsonTemporada, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }

//        temporadas.forEach(System.out::println);

        // MOSTRAR UNICAMENTE LOS NOMBRES DE LOS EPS

//        for (int i = 0; i < datosSerie.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodios = temporadas.get(i).episodios();
//            for (DatosEpisodio episodio : episodios) {
//                System.out.println(episodio.titulo());
//            }
//        }

//        for (DatosTemporada temporada : temporadas) {
//            temporada.episodios().forEach(episodio -> System.out.println(episodio.titulo()));
//        }

        List<DatosEpisodio> episodios = temporadas.stream()
                .flatMap(temporada -> temporada.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("Top 5");
        episodios.stream()
                .filter(episodio -> !episodio.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios1 = temporadas.stream()
                .flatMap(temporada -> temporada.episodios().stream()
                        .map(datoEpisodio -> new Episodio(temporada.numero(), datoEpisodio)))
                .collect(Collectors.toList());

        episodios1.forEach(System.out::println);

        System.out.println("Indica a partir de que año quieres ver los episodios.");
        var año = scanner.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaBusqueda = LocalDate.of(Integer.parseInt(año), 1, 1);

        System.out.println(".........................");
        episodios1.stream()
                .filter(episodio -> (episodio.getFechaDeLanzamiento() != null) && (episodio.getFechaDeLanzamiento().isAfter(fechaBusqueda)))
                .forEach(episodio -> System.out.println(
                        "Temporada: " + episodio.getTemporada() + "# Episodio: " + episodio.getTitulo() + "# Fecha: " + episodio.getFechaDeLanzamiento().format(dtf)
                ));
    }

}
