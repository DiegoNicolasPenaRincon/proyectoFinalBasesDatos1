package co.edu.uniquindio.alquiler.model;

public class DatosSesion<T> {

    T usuarioActivo;
    private static DatosSesion datos;

    private DatosSesion(){
    }

    public static DatosSesion getInstance(){
        if(datos == null)
        {
            datos = new DatosSesion();
        }

        return datos;
    }

    public T getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(T usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}
