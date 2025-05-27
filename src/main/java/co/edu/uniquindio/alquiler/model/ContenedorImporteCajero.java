package co.edu.uniquindio.alquiler.model;

import java.time.LocalDateTime;

public class ContenedorImporteCajero {

    private LocalDateTime fechaPago;
    private int codigoFactura;
    private int idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private double total;

    public ContenedorImporteCajero(LocalDateTime fechaPago, int codigoFactura, int idCliente, String nombreCliente, String telefonoCliente, double total) {
        this.fechaPago = fechaPago;
        this.codigoFactura = codigoFactura;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.total = total;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
