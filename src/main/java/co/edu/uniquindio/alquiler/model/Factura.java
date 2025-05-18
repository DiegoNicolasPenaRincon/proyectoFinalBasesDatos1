package co.edu.uniquindio.alquiler.model;


import co.edu.uniquindio.alquiler.enums.TipoFactura;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Factura {

    private String nombreCliente;
    private String nombreCajero;
    private int codigo;
    private TipoFactura tipoFactura;
    private LocalDateTime fechaPago;
    private double costoTotal;
    private ArrayList<Producto> listaProductos;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Factura(String nombreCliente, int codigo, String nombreCajero, TipoFactura tipoFactura, LocalDateTime fechaPago, double costoTotal, ArrayList<Producto> listaProductos) {
        this.nombreCliente = nombreCliente;
        this.codigo = codigo;
        this.nombreCajero = nombreCajero;
        this.tipoFactura = tipoFactura;
        this.fechaPago = fechaPago;
        this.costoTotal = costoTotal;
        this.listaProductos = listaProductos;
    }
}
