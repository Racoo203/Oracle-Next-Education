package com.aluracursos.radioalura.modelos;

public class Cancion extends Audio{
    private String album;
    private String cantante;
    private String genero;

    @Override
    public int getClasificacion() {
        if (getMeGustas() >= 5000) {
            return 8;
        } else {
            return 4;
        }
    }

    // GETTERS

    public String getAlbum() {
        return album;
    }

    public String getCantante() {
        return cantante;
    }

    public String getGenero() {
        return genero;
    }

    // SETTERS

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
