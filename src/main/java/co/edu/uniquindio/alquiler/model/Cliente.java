package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cliente extends Persona{

    private ArrayList<Factura> facturas;

    public Cliente(String nombre, String telefono, String correo, int documentoEntidad) {
        super(nombre, telefono, correo, documentoEntidad);
        this.facturas=new ArrayList<>();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
}
