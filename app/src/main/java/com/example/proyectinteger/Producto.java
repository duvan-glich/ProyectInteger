package com.example.proyecto;

public class Producto {
    private String nombre;
    private String categoria;
    private String stock;
    private String precio;

    public Producto(String nombre, String categoria, String stock, String precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStock() {
        return stock;
    }

    public String getPrecio() {
        return precio;
    }
}
