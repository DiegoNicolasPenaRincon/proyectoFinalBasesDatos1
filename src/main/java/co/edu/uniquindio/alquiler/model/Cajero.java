package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cajero extends Empleado {

    private ArrayList<Factura> facturas;

    public Cajero(String contrasena, String nombre, String telefono, String correo, int documentoEntidad,double salario) {
        super(contrasena, nombre, telefono, correo, documentoEntidad,salario);
        this.facturas=new ArrayList<>();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
