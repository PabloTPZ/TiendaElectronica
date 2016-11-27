package com.example.camk1.app_tienda.Clases;

/**
 * Created by hola on 27/11/2016.
 */

public class TarjetaInicio {
    String nombre;
    String urlImagen;

    public TarjetaInicio(String nombre, String urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
