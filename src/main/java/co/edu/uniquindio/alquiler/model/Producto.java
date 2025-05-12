package co.edu.uniquindio.alquiler.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Producto {

    private String nombre;
    private String categoria;
    private int codigo;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Factura> facturasAsociadas;
    private int unidadesDisponibles;
    private Inventario inventarioAsociado;
}
