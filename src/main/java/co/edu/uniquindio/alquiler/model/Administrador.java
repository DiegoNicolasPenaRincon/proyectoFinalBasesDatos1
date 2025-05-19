package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Administrador extends Empleado{

    public Administrador(double salario,String contrasena,String nombre,String telefono,String correo,int documentoEntidad) {
        super(contrasena,nombre,telefono,correo, documentoEntidad,salario);
    }

}
