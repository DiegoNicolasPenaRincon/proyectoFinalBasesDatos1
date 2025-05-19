package co.edu.uniquindio.alquiler.model;

public class Empleado extends Persona {
    private String contrasena;
    private double salario;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Empleado(String contrasena, String nombre, String telefono, String correo, int documentoEntidad, double salario) {
        super(nombre,telefono,correo,documentoEntidad);
        this.contrasena = contrasena;
        this.salario=salario;
    }
}
