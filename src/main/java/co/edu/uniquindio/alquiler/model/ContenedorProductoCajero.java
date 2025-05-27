package co.edu.uniquindio.alquiler.model;

public class ContenedorProductoCajero {

    private String nombreProducto;
    private int codigoProducto;
    private String categoriaNombre;
    private String nombreProveedor;
    private int codigoProveedor;
    private String direccionProveedor;
    private int cantidadProducto;

    public ContenedorProductoCajero(String nombreProducto, int codigoProducto, String categoriaNombre, String nombreProveedor, int codigoProveedor, String direccionProveedor,int cantidadProducto) {
        this.nombreProducto = nombreProducto;
        this.codigoProducto = codigoProducto;
        this.categoriaNombre = categoriaNombre;
        this.nombreProveedor = nombreProveedor;
        this.codigoProveedor = codigoProveedor;
        this.direccionProveedor = direccionProveedor;
        this.cantidadProducto=cantidadProducto;
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

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}
