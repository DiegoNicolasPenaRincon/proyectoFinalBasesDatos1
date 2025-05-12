package co.edu.uniquindio.alquiler.model;

import co.edu.uniquindio.alquiler.enums.TipoFactura;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@NonNull
public class Factura {

    private String documentoEntidadCliente;
    private String documentoEntidadCajero;
    private int codigo;
    private TipoFactura tipoFactura;
    private LocalDateTime fechaPago;
    private double costoTotal;
    private ArrayList<Producto> listaProductos;
}
