package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.models.DatosEpisodio;
import com.aluracursos.screenmatch.models.DatosSerie;
import com.aluracursos.screenmatch.models.DatosTemporada;
import com.aluracursos.screenmatch.models.Episodio;
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
//
//        List<DatosEpisodio> episodios = temporadas.stream()
//                .flatMap(temporada -> temporada.episodios().stream())
//                .collect(Collectors.toList());
//
//        System.out.println("Top 5");
//        episodios.stream()
//                .filter(episodio -> !episodio.evaluacion().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .limit(5)
//                .forEach(System.out::println);
//
        List<Episodio> episodios = temporadas.stream()
                .flatMap(temporada -> temporada.episodios().stream()
                        .map(datoEpisodio -> new Episodio(temporada.numero(), datoEpisodio)))
                .collect(Collectors.toList());
//
//        episodios1.forEach(System.out::println);
//
//        System.out.println("Indica a partir de que año quieres ver los episodios.");
//        var año = scanner.nextLine();
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        LocalDate fechaBusqueda = LocalDate.of(Integer.parseInt(año), 1, 1);

//        System.out.println(".........................");
//        episodios1.stream()
//                .filter(episodio -> (episodio.getFechaDeLanzamiento() != null) && (episodio.getFechaDeLanzamiento().isAfter(fechaBusqueda)))
//                .forEach(episodio -> System.out.println(
//                        "Temporada: " + episodio.getTemporada() + "# Episodio: " + episodio.getTitulo() + "# Fecha: " + episodio.getFechaDeLanzamiento().format(dtf)
//                ));

//        System.out.println("Escribe el titulo del episodio que quieres ver");
//        var pedazoTitulo = scanner.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(episodio -> episodio.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
//                .findFirst();
//
//        if (episodioBuscado.isPresent()) {
//            System.out.println("Episodio encontrado");
//            System.out.println(episodioBuscado.get());
//        } else {
//            System.out.println("Episodio no encontrado");
//        }

        Map<Integer, Double> evaluacionTemporada = episodios.stream()
                .filter(episodio -> episodio.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));

        System.out.println(evaluacionTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(episodio -> episodio.getEvaluacion() > 0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));

        System.out.println("Media: " + est.getAverage());
        System.out.println("Maximo: " + est.getMax());
        System.out.println("Min: " + est.getMin());
    }

}
