package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main_Old {
    public static void main(String[] args) {
        Pelicula favorita = new Pelicula("El señor de los anillos", 2001);
        favorita.evalua(10);

        Pelicula otra = new Pelicula("John Wick", 2014);
        otra.evalua(9);

        Serie serie = new Serie("La Casa de Papel", 2017);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorita);
        lista.add(otra);
        lista.add(serie);

        Collections.sort(lista);
        System.out.println(lista);
    }
}
