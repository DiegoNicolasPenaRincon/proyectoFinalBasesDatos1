package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Administrador extends Empleado{
    private ArrayList<Pedido> pedidos;
    private ArrayList<Inventario> inventariosModificados;

    public Administrador(ArrayList<Pedido> pedidos, ArrayList<Inventario> inventariosModificados, double salario,String contrasena,String nombre,String telefono,String correo,int documentoEntidad) {
        super(contrasena,nombre,telefono,correo, documentoEntidad,salario);
        this.pedidos = pedidos;
        this.inventariosModificados = inventariosModificados;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Inventario> getInventariosModificados() {
        return inventariosModificados;
    }

    public void setInventariosModificados(ArrayList<Inventario> inventariosModificados) {
        this.inventariosModificados = inventariosModificados;
    }

}
