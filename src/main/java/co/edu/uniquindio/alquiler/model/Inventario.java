package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;

public class Inventario {

    private Producto producto;
    private int unidadesAdquiridas;
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

    public int getUnidadesAdquiridas() {
        return unidadesAdquiridas;
    }

    public void setUnidadesAdquiridas(int unidadesAdquiridas) {
        this.unidadesAdquiridas = unidadesAdquiridas;
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
}
