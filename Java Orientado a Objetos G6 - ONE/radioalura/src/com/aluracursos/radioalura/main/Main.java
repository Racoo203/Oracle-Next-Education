package com.aluracursos.radioalura.main;

import com.aluracursos.radioalura.modelos.Cancion;
import com.aluracursos.radioalura.modelos.MisFavoritos;
import com.aluracursos.radioalura.modelos.Podcast;

public class Main {
    public static void main(String[] args) {

        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Forever");
        miCancion.setCantante("KISS");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Gabriela Aguiar");
        miPodcast.setTitulo("Cafe.Tech");

        for (int i = 0; i < 100; i++) {
            miCancion.meGusta();
        }

        for (int i = 0; i < 200; i++) {
            miCancion.reproducir();
        }

        //

        for (int i = 0; i < 100; i++) {
            miPodcast.meGusta();
        }

        for (int i = 0; i < 8000; i++) {
            miPodcast.reproducir();
        }

        System.out.println("Total Reproducciones: " + miCancion.getTotalReproducciones());
        System.out.println("Total Me Gusta: " + miCancion.getMeGustas());

        MisFavoritos misFavoritos = new MisFavoritos();
        misFavoritos.adicionar(miPodcast);
        misFavoritos.adicionar(miCancion);

        
    }
}