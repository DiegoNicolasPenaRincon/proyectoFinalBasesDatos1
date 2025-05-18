package co.edu.uniquindio.alquiler.model;

import java.util.ArrayList;

public class DatosSesion<T> {

    T usuarioActivo;
    private static DatosSesion datos;

    private DatosSesion(){
    }

    public static DatosSesion getInstance(){
        if(datos == null){
            datos = new DatosSesion();
        }

        return datos;
    }

    public T getEstudianteSeleccionado() {
        return usuarioActivo;
    }

    public void setEstudianteSeleccionado(T usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}
