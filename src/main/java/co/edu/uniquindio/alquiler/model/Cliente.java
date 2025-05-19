package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Cliente extends Persona{


    public Cliente(String nombre, String telefono, String correo, int documentoEntidad, ArrayList<Factura> listaFacturas) {
        super(nombre, telefono, correo, documentoEntidad);
    }

}
