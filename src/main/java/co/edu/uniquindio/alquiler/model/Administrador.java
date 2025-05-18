package co.edu.uniquindio.alquiler.model;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Administrador extends Persona{
    private ArrayList<Pedido> pedidos;
    private ArrayList<Inventario> inventariosModificados;
    private double salario;
}
