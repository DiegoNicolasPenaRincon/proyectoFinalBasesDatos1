package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cliente extends Persona{

    private ArrayList<Factura> listaFacturas;

    public Cliente(String nombre, String telefono, String correo, int documentoEntidad, ArrayList<Factura> listaFacturas) {
        super(nombre, telefono, correo, documentoEntidad);
        this.listaFacturas = listaFacturas;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
}
