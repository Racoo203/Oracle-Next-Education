package com.aluracursos.screenmatch.models;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    CRIMEN("Crime"),
    DRAMA("Drama");

    private String categoriaOMDB;

    Categoria (String categoriaOMDB) {
        this.categoriaOMDB = categoriaOMDB;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOMDB.equalsIgnoreCase(text)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Niguna categoria encontrada: " + text);
    }
}
