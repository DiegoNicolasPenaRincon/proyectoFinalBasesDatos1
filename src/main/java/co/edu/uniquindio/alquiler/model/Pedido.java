package co.edu.uniquindio.alquiler.model;



import java.time.LocalDateTime;
import java.util.ArrayList;


public class Pedido {
    private int codigo;
    private Proveedor proveedor;
    private LocalDateTime fechaPedido;
    private ArrayList<Producto> listaProductoCantidad;
    private Administrador administrador;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public ArrayList<Producto> getListaProductoCantidad() {
        return listaProductoCantidad;
    }

    public void setListaProductoCantidad(ArrayList<Producto> listaProductoCantidad) {
        this.listaProductoCantidad = listaProductoCantidad;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Pedido(int codigo, Proveedor proveedor, LocalDateTime fechaPedido, Administrador administrador,ArrayList<Producto> productos) {
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.fechaPedido = fechaPedido;
        this.administrador = administrador;
        this.listaProductoCantidad=productos;
    }
}
