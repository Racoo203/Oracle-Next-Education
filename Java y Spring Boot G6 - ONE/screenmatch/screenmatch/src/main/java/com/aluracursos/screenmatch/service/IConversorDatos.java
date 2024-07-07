package com.aluracursos.screenmatch.service;

public interface IConversorDatos {
    <T>T obtenerDatos(String json, Class<T> clase);
}
