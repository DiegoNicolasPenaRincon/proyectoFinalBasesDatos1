package co.edu.uniquindio.alquiler.model;


import co.edu.uniquindio.alquiler.enums.TipoFactura;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Factura {

    private int documentoEntidadCliente;
    private int documentoEntidadCajero;
    private int codigo;
    private TipoFactura tipoFactura;
    private LocalDateTime fechaPago;
    private double costoTotal;
    private ArrayList<Producto> listaProductos;

    public int getDocumentoEntidadCliente() {
        return documentoEntidadCliente;
    }

    public void setDocumentoEntidadCliente(int documentoEntidadCliente) {
        this.documentoEntidadCliente = documentoEntidadCliente;
    }

    public int getDocumentoEntidadCajero() {
        return documentoEntidadCajero;
    }

    public void setDocumentoEntidadCajero(int documentoEntidadCajero) {
        this.documentoEntidadCajero = documentoEntidadCajero;
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

    public Factura(int documentoEntidadCliente, int codigo, int documentoEntidadCajero, TipoFactura tipoFactura, LocalDateTime fechaPago, double costoTotal, ArrayList<Producto> listaProductos) {
        this.documentoEntidadCliente = documentoEntidadCliente;
        this.codigo = codigo;
        this.documentoEntidadCajero = documentoEntidadCajero;
        this.tipoFactura = tipoFactura;
        this.fechaPago = fechaPago;
        this.costoTotal = costoTotal;
        this.listaProductos = listaProductos;
    }
}

