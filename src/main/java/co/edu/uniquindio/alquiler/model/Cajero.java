package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cajero extends Empleado {

    private ArrayList<Factura> listaFacturas;
    private double salario;

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cajero(String contrasena, String nombre, String telefono, String correo, int documentoEntidad, ArrayList<Factura> listaFacturas, double salario) {
        super(contrasena, nombre, telefono, correo, documentoEntidad);
        this.listaFacturas = listaFacturas;
        this.salario = salario;
    }
}
