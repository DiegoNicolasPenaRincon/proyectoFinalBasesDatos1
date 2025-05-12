package co.edu.uniquindio.alquiler.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Proveedor {
    private String nombre;
    private String telefono;
    private int codigo;
    private String direccion;
    private ArrayList<Producto>productosOfertados;
    private ArrayList<Pedido> pedidos;
}
