package com.example.proyecto_pdm01.modelos;

public class Videojuego {
    public int imagen;
    public String nombre;
    public String descripcion;
    public double precio;
    public String plataforma;

    public Videojuego(int imagen, String nombre, String descripcion, double precio, String plataforma) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.plataforma = plataforma;
    }

}
