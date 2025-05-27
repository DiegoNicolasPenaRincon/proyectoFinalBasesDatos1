package co.edu.uniquindio.alquiler.model;

public class DatosSesionAdministrador {

    Administrador usuarioActivo;
    private static DatosSesionAdministrador datos;

    private DatosSesionAdministrador(){
    }

    public static DatosSesionAdministrador getInstance(){
        if(datos == null)
        {
            datos = new DatosSesionAdministrador();
        }

        return datos;
    }

    public Administrador getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Administrador usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
}
