package co.edu.uniquindio.alquiler.model;

public class DatosSesionCajero {

    Cajero usuarioActivo;
    private static DatosSesionCajero datos;

    private DatosSesionCajero(){
    }

    public static DatosSesionCajero getInstance(){
        if(datos == null)
        {
            datos = new DatosSesionCajero();
        }

        return datos;
    }

    public Cajero getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Cajero usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}
