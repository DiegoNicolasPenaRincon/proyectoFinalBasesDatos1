package db;

import javafx.scene.control.Alert;

import java.sql.*;

public class Conexion {

    private Connection conexionT=null;

    private final String usuario="AdministradorBase";
    private final String contrasenia="bases1";
    private final String bd="TiendaUQ";
    private final String Ip="localhost";
    private final String puerto="1433";

    private static Conexion conexion;

    private Conexion(){

    }

    public static Conexion getInstance(){
        if(conexion == null){
            conexion = new Conexion();
        }

        return conexion;
    }


    String cadenaJDBC="jdbc:sqlserver://"+Ip+":"+puerto+"/"+bd;

    public Connection conectarBD(){
        try
        {
            String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"DatabaseName="+bd+";"+"encrypt=true;trustServerCertificate=true;";
            conexionT= DriverManager.getConnection(cadena,usuario,contrasenia);
        }
        catch (Exception e)
        {

        }
        return conexionT;
    }

    public void cerrarConexion() {
        try
        {
            conexionT.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConexionT() {
        return conexionT;
    }

    public void setConexionT(Connection conexionT) {
        this.conexionT = conexionT;
    }
}
