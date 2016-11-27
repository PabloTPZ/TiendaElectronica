package com.example.camk1.app_tienda.Clases;

/**
 * Created by hola on 27/11/2016.
 */

public class Producto {
    private String key;
    private String nombre;
    private String categoria;

    public Producto(String categoria, String key, String nombre) {
        this.categoria = categoria;
        this.key = key;
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
