package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Administrador extends Empleado{

    private ArrayList<Pedido> pedidos;
    private ArrayList<Modificacion> modificaciones;

    public Administrador(double salario,String contrasena,String nombre,String telefono,String correo,int documentoEntidad) {
        super(contrasena,nombre,telefono,correo, documentoEntidad,salario);
        this.modificaciones=new ArrayList<>();
        this.pedidos=new ArrayList<>();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Modificacion> getModificaciones() {
        return modificaciones;
    }

    public void setModificaciones(ArrayList<Modificacion> modificaciones) {
        this.modificaciones = modificaciones;
    }
}
