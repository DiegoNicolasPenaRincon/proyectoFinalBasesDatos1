package co.edu.uniquindio.alquiler.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class ProductoCantidad {
    private Producto producto;
    private int cantidad;

}
