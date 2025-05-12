package co.edu.uniquindio.alquiler.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Inventario {
    private Producto producto;
    private int unidadesAdquiridas;
    private int unidadesVendidas;
    private ArrayList<Administrador> modificadores;
    private int codigoInstancia;
    private ArrayList<Proveedor> proveedores;
}
