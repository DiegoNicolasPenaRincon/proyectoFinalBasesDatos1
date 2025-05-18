package co.edu.uniquindio.alquiler.model;


import java.util.ArrayList;


public class Proveedor {
    private String nombre;
    private String telefono;
    private int codigo;
    private ArrayList<Inventario> inventariosMencionados;
    private String direccion;
    private ArrayList<Producto>productosOfertados;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Factura> facturasElementosAdquiridos;

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Inventario> getInventariosMencionados() {
        return inventariosMencionados;
    }

    public void setInventariosMencionados(ArrayList<Inventario> inventariosMencionados) {
        this.inventariosMencionados = inventariosMencionados;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Producto> getProductosOfertados() {
        return productosOfertados;
    }

    public void setProductosOfertados(ArrayList<Producto> productosOfertados) {
        this.productosOfertados = productosOfertados;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ArrayList<Factura> getFacturasElementosAdquiridos() {
        return facturasElementosAdquiridos;
    }

    public void setFacturasElementosAdquiridos(ArrayList<Factura> facturasElementosAdquiridos) {
        this.facturasElementosAdquiridos = facturasElementosAdquiridos;
    }

    public Proveedor(String telefono, int codigo, String nombre, ArrayList<Inventario> inventariosMencionados, String direccion, ArrayList<Producto> productosOfertados, ArrayList<Pedido> pedidos, ArrayList<Factura> facturasElementosAdquiridos) {
        this.telefono = telefono;
        this.codigo = codigo;
        this.nombre = nombre;
        this.inventariosMencionados = inventariosMencionados;
        this.direccion = direccion;
        this.productosOfertados = productosOfertados;
        this.pedidos = pedidos;
        this.facturasElementosAdquiridos = facturasElementosAdquiridos;
    }
}
