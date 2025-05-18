package co.edu.uniquindio.alquiler.model;


public class Persona {

    private String nombre;
    private String telefono;
    private String correo;
    private int documentoEntidad;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getDocumentoEntidad() {
        return documentoEntidad;
    }

    public void setDocumentoEntidad(int documentoEntidad) {
        this.documentoEntidad = documentoEntidad;
    }

    public Persona(String nombre, String telefono, String correo, int documentoEntidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.documentoEntidad = documentoEntidad;
    }
}
