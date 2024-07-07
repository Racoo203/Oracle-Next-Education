package com.aluracursos.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("Title")
        String titulo,
        @JsonAlias("Episode")
        int numeroEpisodio,
        @JsonAlias("imdbRating")
        String evaluacion,
        @JsonAlias("Released")
        String fechaDeLanzamiento) {
}
