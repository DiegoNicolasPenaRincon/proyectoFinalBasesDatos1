package co.edu.uniquindio.alquiler.model;


import co.edu.uniquindio.alquiler.controller.CajeroVentanaController;
import co.edu.uniquindio.alquiler.controller.VentanaAdministradorController;
import co.edu.uniquindio.alquiler.enums.TipoFactura;
import co.edu.uniquindio.alquiler.exceptions.ContrasenaException;
import co.edu.uniquindio.alquiler.exceptions.NoRegistradoException;
import db.Conexion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class TiendaUQ {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Administrador> administradores;
    private ArrayList<Cajero> cajeros;
    private ArrayList<Factura> facturas;
    private ArrayList<Pedido> pedido;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Inventario> inventario;

    private static TiendaUQ tienda;
    public Conexion conexionBD=Conexion.getInstance();

    private TiendaUQ(){
        this.administradores=new ArrayList<>();
        this.cajeros=new ArrayList<>();
        this.facturas=new ArrayList<>();
        this.pedido=new ArrayList<>();
        this.proveedores=new ArrayList<>();
        this.inventario=new ArrayList<>();
        this.productos=new ArrayList<>();
        this.clientes=new ArrayList<>();

        conexionBD.conectarBD();

        quemarDatos();
    }

    public static TiendaUQ getInstance(){
        if(tienda == null){
            tienda = new TiendaUQ();
        }

        return tienda;
    }

    public Cajero verficiarCajero(int documentoIdentidad,String contrasena) throws ContrasenaException {

        for(Cajero cajero: cajeros)
        {
            if(cajero.getDocumentoEntidad()==documentoIdentidad)
            {
                if(cajero.getContrasena().equals(contrasena))
                {
                    return cajero;
                }
                else
                {
                    throw new ContrasenaException("La contrasena es incorrecta");
                }
            }
        }

        return null;
    }

    public Administrador verficiarAdministrador(int documentoIdentidad,String contrasena) throws ContrasenaException {

        for(Administrador administrador : administradores)
        {
            if(administrador.getDocumentoEntidad()==documentoIdentidad)
            {
                if(administrador.getContrasena().equals(contrasena))
                {
                    return administrador;
                }
                else
                {
                    throw new ContrasenaException("La contrasena es incorrecta");
                }
            }
        }
        return null;
    }

    public void inicializarEmpleadoInterfaz(int tipoEmpleado) throws IOException {
        if(tipoEmpleado==1)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/VentanaAdministrador.fxml"));
            Parent root = loader.load();

            VentanaAdministradorController adminController =loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/CajeroVentana.fxml"));
            Parent root = loader.load();

            CajeroVentanaController cajeroController =loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public ArrayList<Cajero> getCajeros() {
        return cajeros;
    }

    public void setCajeros(ArrayList<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ArrayList<Inventario> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Inventario> inventario) {
        this.inventario = inventario;
    }

    public void quemarDatos() {
        try
        {
            String consulta = "SELECT * FROM Materias";
            Statement stmt = conexionBD.getConexionT().createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next())
            {

            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
