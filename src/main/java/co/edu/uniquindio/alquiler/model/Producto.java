package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Producto {

    private String nombre;
    private CategoriaProducto categoria;
    private int codigo;
    private double valor;;

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


    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public Producto(String nombre, CategoriaProducto categoria, int codigo, double valor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.codigo = codigo;
        this.valor=valor;
    }



}
