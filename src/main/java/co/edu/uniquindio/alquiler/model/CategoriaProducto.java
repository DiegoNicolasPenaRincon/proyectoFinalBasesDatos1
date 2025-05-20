package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class CategoriaProducto {

    private String nombre;
    private double utilidad;
    private double iva;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public CategoriaProducto(String nombre, double utilidad, double iva) {
        this.nombre = nombre;
        this.utilidad = utilidad;
        this.iva = iva;
    }

    @Override
    public String toString() {
        return nombre; // Lo que se muestra por defecto en el ComboBox
    }
}
