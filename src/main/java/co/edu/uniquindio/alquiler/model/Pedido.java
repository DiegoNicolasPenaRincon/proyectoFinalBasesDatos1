package co.edu.uniquindio.alquiler.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Pedido {
    private int codigo;
    private Proveedor proveedor;
    private LocalDateTime fechaPedido;
    private ArrayList<ProductoCantidad> listaProductoCantidad;
}
