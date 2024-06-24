package com.aluracursos.radioalura.modelos;

public class Audio {
    private String titulo;
    private int duracion;
    private int totalReproducciones;
    private int meGustas;
    private int clasificacion;

    public void meGusta() {
        this.meGustas++;
    }

    public void reproducir() {
        this.totalReproducciones++;
    }

    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }

    public int getMeGustas() {
        return meGustas;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    // SETTERS

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
}
