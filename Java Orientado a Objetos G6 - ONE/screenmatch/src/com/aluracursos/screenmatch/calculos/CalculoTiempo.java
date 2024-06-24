package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculoTiempo {
    private int tiempoTotal;

    public void incluye(Titulo titulo) {
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}
