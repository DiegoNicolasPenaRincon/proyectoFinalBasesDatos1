package co.edu.uniquindio.alquiler.model;

import lombok.*;

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
}
