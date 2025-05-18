package co.edu.uniquindio.alquiler.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NonNull
public class TiendaUQ {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Administrador> administradores;
    private ArrayList<Cajero> cajeros;
    private ArrayList<Factura> facturas;
    private ArrayList<Pedido> pedido;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Inventario> inventario;

    private static TiendaUQ tienda;

    private TiendaUQ(){
        this.administradores=new ArrayList<>();
        this.cajeros=new ArrayList<>();
        this.facturas=new ArrayList<>();
        this.pedido=new ArrayList<>();
        this.proveedores=new ArrayList<>();
        this.inventario=new ArrayList<>();
        this.productos=new ArrayList<>();
        this.clientes=new ArrayList<>();
    }

    public static TiendaUQ getInstance(){
        if(tienda == null){
            tienda = new TiendaUQ();
        }

        return tienda;
    }
}
