package com.aluracursos.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title")
        String titulo,

        @JsonAlias ("totalSeasons")
        int totalDeTemporadas,

        @JsonAlias("imdbRating")
        String evaluacion) {
}
