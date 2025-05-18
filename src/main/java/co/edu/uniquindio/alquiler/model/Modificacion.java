package co.edu.uniquindio.alquiler.model;

import java.time.LocalDateTime;

public class Modificacion {
    private Administrador administrador;
    private LocalDateTime fechaModificacion;
    private int codigoInstancia;
    private Inventario inventario;

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCodigoInstancia() {
        return codigoInstancia;
    }

    public void setCodigoInstancia(int codigoInstancia) {
        this.codigoInstancia = codigoInstancia;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Modificacion(Administrador administrador, LocalDateTime fechaModificacion, int codigoInstancia, Inventario inventario) {
        this.administrador = administrador;
        this.fechaModificacion = fechaModificacion;
        this.codigoInstancia = codigoInstancia;
        this.inventario = inventario;
    }


}
