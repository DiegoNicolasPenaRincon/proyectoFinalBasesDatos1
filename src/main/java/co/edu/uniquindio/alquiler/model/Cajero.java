package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cajero extends Empleado {

    private ArrayList<Factura> listaFacturas;

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }


    public Cajero(String contrasena, String nombre, String telefono, String correo, int documentoEntidad, ArrayList<Factura> listaFacturas, double salario) {
        super(contrasena, nombre, telefono, correo, documentoEntidad);
        this.listaFacturas = listaFacturas;
    }
}
