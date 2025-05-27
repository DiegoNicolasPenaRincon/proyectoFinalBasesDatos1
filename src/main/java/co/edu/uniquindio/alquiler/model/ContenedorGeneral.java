package co.edu.uniquindio.alquiler.model;

public class ContenedorGeneral {

    private String nombreProducto;
    private int codigoProducto;
    private String nombreProveedor;
    private int codigoProveedor;
    private String nombreCategoria;
    private double iva;
    private double utilidad;

    public ContenedorGeneral(String nombreProducto, int codigoProducto, String nombreProveedor, int codigoProveedor, String nombreCategoria, double iva, double utilidad) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.nombreProveedor = nombreProveedor;
        this.codigoProveedor = codigoProveedor;
        this.nombreCategoria = nombreCategoria;
        this.iva = iva;
        this.utilidad = utilidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }
}
