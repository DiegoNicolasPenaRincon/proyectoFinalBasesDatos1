package co.edu.uniquindio.alquiler.model;

import java.time.LocalDateTime;

public class ContenedorModificaciones {

    private String nombreAdmin;
    private int documentoEntidad;
    private LocalDateTime fechaModificacion;
    private int codigoInstancia;

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public int getDocumentoEntidad() {
        return documentoEntidad;
    }

    public void setDocumentoEntidad(int documentoEntidad) {
        this.documentoEntidad = documentoEntidad;
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

    public ContenedorModificaciones(String nombreAdmin, int documentoEntidad, LocalDateTime fechaModificacion, int codigoInstancia) {
        this.nombreAdmin = nombreAdmin;
        this.documentoEntidad = documentoEntidad;
        this.fechaModificacion = fechaModificacion;
        this.codigoInstancia = codigoInstancia;
    }
}
