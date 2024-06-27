package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.*;
import com.aluracursos.screenmatch.modelos.*;

import java.util.ArrayList;

public class Main_Older {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getTotalDelasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La Casa del Dragon", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        System.out.println(casaDragon.getDuracionEnMinutos());
        casaDragon.muestraFichaTecnica();

        Pelicula otraPelicula = new Pelicula("Matrix", 1999);
        otraPelicula.setDuracionEnMinutos(180);

        CalculoTiempo calculadora = new CalculoTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver estos titulos: " + calculadora.getTiempoTotal());

        FiltroRecomendacion filtroDeRecomendacion = new FiltroRecomendacion();
        filtroDeRecomendacion.filtra(miPelicula);

        Episodio nuevoEpisodio = new Episodio();
        nuevoEpisodio.setNumero(1);
        nuevoEpisodio.setNombre("La casa Targaryen");
        nuevoEpisodio.setSerie(casaDragon);
        nuevoEpisodio.setTotalVisualizaciones(50);

        filtroDeRecomendacion.filtra(nuevoEpisodio);

        Pelicula peliculaDeBruno = new Pelicula("EL Señor de los Anillos", 180);
        peliculaDeBruno.setFechaDeLanzamiento(2001);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(peliculaDeBruno);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());

    }
}