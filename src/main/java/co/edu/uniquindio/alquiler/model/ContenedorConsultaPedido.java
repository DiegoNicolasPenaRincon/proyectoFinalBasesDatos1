package co.edu.uniquindio.alquiler.model;

import java.time.LocalDateTime;

public class ContenedorConsultaPedido {

    private int codigoPedido;
    private int codigoAdministrador;
    private String nombreAdministrador;
    private String nombreProveedor;
    private int codigoProveedor;
    private LocalDateTime fechaPedido;

    public ContenedorConsultaPedido(int codigoPedido, int codigoAdministrador, String nombreAdministrador, String nombreProveedor, int codigoProveedor, LocalDateTime fechaPedido) {
        this.codigoPedido = codigoPedido;
        this.codigoAdministrador = codigoAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.nombreProveedor = nombreProveedor;
        this.codigoProveedor = codigoProveedor;
        this.fechaPedido = fechaPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(int codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
}
