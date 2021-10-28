package com.example.t3practica03.entities;

public class Pokemons {
    public String nombre;
    public String tipo;
    public String urlImagen;
    public String latitud;
    public String longitud;

    public Pokemons() {

    }
    public Pokemons(String nombre, String tipo, String urlImagen, String latitud, String longitud) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl_imagen() {
        return urlImagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.urlImagen = urlImagen;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitude(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitude(String longitud) {
        this.longitud = longitud;
    }
}
