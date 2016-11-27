package com.example.camk1.app_tienda.Clases;

/**
 * Created by hola on 27/11/2016.
 */

public class Producto {
    String nombre;

    public Producto(String nombre, String imagenProducto) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
