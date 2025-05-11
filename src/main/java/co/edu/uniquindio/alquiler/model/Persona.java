package co.edu.uniquindio.alquiler.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Persona {

    private String nombre;
    private String telefono;
    private String correo;
    private int documentoEntidad;
    

}
