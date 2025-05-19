package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Producto {

    private String nombre;
    private CategoriaProducto categoria;
    private int codigo;
    private int unidadesDisponibles;
    private Inventario inventarioAsociado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Inventario getInventarioAsociado() {
        return inventarioAsociado;
    }

    public void setInventarioAsociado(Inventario inventarioAsociado) {
        this.inventarioAsociado = inventarioAsociado;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public Producto(String nombre, CategoriaProducto categoria, int codigo, int unidadesDisponibles, Inventario inventarioAsociado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.codigo = codigo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.inventarioAsociado = inventarioAsociado;
    }
}
