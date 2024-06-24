package com.aluracursos.radioalura.modelos;

public class Podcast extends Audio {

    private String presentador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getTotalReproducciones() >= 2000) {
            return 9;
        } else {
            return 2;
        }
    }


    // GETTERS


    public String getPresentador() {
        return presentador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // SETTERS

    public void setPresentador(String presentador) {
        this.presentador = presentador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
