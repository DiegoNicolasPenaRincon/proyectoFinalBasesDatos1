package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;

public class Inventario {

    private Producto producto;
    private int unidadesDisponibles;
    private int unidadesVendidas;
    private ArrayList<Modificacion> modificaciones;
    private int codigoInstancia;
    private ArrayList<Proveedor> proveedores;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public ArrayList<Modificacion> getModificaciones() {
        return modificaciones;
    }

    public void setModificaciones(ArrayList<Modificacion> modificaciones) {
        this.modificaciones = modificaciones;
    }

    public int getCodigoInstancia() {
        return codigoInstancia;
    }

    public void setCodigoInstancia(int codigoInstancia) {
        this.codigoInstancia = codigoInstancia;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Inventario(Producto producto, int unidadesVendidas, int codigoInstancia,ArrayList<Proveedor> proveedores) {
        this.producto = producto;
        this.unidadesVendidas = unidadesVendidas;
        this.codigoInstancia = codigoInstancia;
        this.modificaciones = new ArrayList<>();
        this.proveedores = proveedores;
    }
}
