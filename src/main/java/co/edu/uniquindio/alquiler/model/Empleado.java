package co.edu.uniquindio.alquiler.model;

public class Empleado extends Persona {
    private String contrasena;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleado(String contrasena,String nombre,String telefono,String correo,int documentoEntidad) {
        super(nombre,telefono,correo,documentoEntidad);
        this.contrasena = contrasena;
    }
}
