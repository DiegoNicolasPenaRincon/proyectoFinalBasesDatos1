package co.edu.uniquindio.alquiler.model;


import co.edu.uniquindio.alquiler.controller.CajeroVentanaController;
import co.edu.uniquindio.alquiler.controller.VentanaAdministradorController;
import co.edu.uniquindio.alquiler.enums.TipoFactura;
import co.edu.uniquindio.alquiler.exceptions.AtributoExistenteException;
import co.edu.uniquindio.alquiler.exceptions.ContrasenaException;
import co.edu.uniquindio.alquiler.exceptions.NoRegistradoException;
import db.Conexion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class TiendaUQ {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Administrador> administradores;
    private ArrayList<Cajero> cajeros;
    private ArrayList<Factura> facturas;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Inventario> inventario;
    private ArrayList<CategoriaProducto> categorias;
    private ArrayList<Modificacion> modificaciones;

    private static TiendaUQ tienda;
    public Conexion conexionBD=Conexion.getInstance();

    private TiendaUQ(){
        this.administradores=new ArrayList<>();
        this.cajeros=new ArrayList<>();
        this.facturas=new ArrayList<>();
        this.pedidos=new ArrayList<>();
        this.proveedores=new ArrayList<>();
        this.inventario=new ArrayList<>();
        this.productos=new ArrayList<>();
        this.clientes=new ArrayList<>();
        this.modificaciones=new ArrayList<>();
        this.categorias=new ArrayList<>();

        conexionBD.conectarBD();

        quemarDatos();

    }

    public static TiendaUQ getInstance(){
        if(tienda == null){
            tienda = new TiendaUQ();
        }

        return tienda;
    }

    public Cajero verficiarCajero(int documentoIdentidad,String contrasenia) throws ContrasenaException, SQLException {
        String consulta = "SELECT * FROM Cajero WHERE documentoEntidad=?";
        PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
        stmt.setInt(1, documentoIdentidad);

        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            String contrasena = rs.getString("contrasena");
            if(contrasena.equals(contrasenia))
            {
                int documentoEntidad = rs.getInt("documentoEntidad");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                double salario =rs.getDouble("salario");
                return new Cajero(contrasena,nombre,telefono,correo,documentoEntidad,salario);
            }
            else
            {
                throw new ContrasenaException("Contraseña incorrecta");
            }
        }
        return null;
    }

    public Administrador verficiarAdministrador(int documentoIdentidad,String contrasenia) throws ContrasenaException, SQLException {

        String consulta = "SELECT * FROM Administrador WHERE documentoEntidad=?";
        PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
        stmt.setInt(1, documentoIdentidad);

        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            String contrasena = rs.getString("contrasena");
            if(contrasena.equals(contrasenia))
            {
                int documentoEntidad = rs.getInt("documentoEntidad");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                double salario =rs.getDouble("salario");
                return new Administrador(salario,contrasena,nombre,telefono,correo,documentoEntidad);
            }
            else
            {
                throw new ContrasenaException("Contraseña incorrecta");
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

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedido) {
        this.pedidos = pedido;
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

    public ArrayList<CategoriaProducto> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<CategoriaProducto> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Modificacion> getModificaciones() {
        return modificaciones;
    }

    public void setModificaciones(ArrayList<Modificacion> modificaciones) {
        this.modificaciones = modificaciones;
    }

    public static TiendaUQ getTienda() {
        return tienda;
    }

    public static void setTienda(TiendaUQ tienda) {
        TiendaUQ.tienda = tienda;
    }

    public void quemarDatos() {
        try
        {
            String consulta = "SELECT * FROM CategoriaProducto";

            Statement stmt = conexionBD.getConexionT().createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombreCategoria = rs.getString("nombre");
                double utilidad = rs.getDouble("utilidad");
                double iva =rs.getDouble("iva");
                CategoriaProducto categoriaProducto=new CategoriaProducto(nombreCategoria,utilidad,iva);
                categorias.add(categoriaProducto);
            }


            consulta = "SELECT * FROM Proveedor";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombre =rs.getString("nombre");
                String direccion =rs.getString("direccion");
                String telefono =rs.getString("telefono");
                int codigo=rs.getInt("codigo");

                String consulta2="SELECT * FROM Proveedor_Producto";
                Statement stmt2 = conexionBD.getConexionT().createStatement();
                ResultSet rs2 = stmt2.executeQuery(consulta2);

                ArrayList<Producto> productos1=new ArrayList<>();

                while(rs2.next())
                {
                    if(rs2.getInt("codigoProveedor")==codigo)
                    {
                        int codigoProducto=rs2.getInt("codigoProducto");
                        productos1.add(buscarProducto(codigoProducto));
                    }
                }

                Proveedor proveedor=new Proveedor(telefono,codigo,nombre,direccion,productos1);
                proveedores.add(proveedor);
            }



            consulta="SELECT * FROM Inventario";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                int codigoInventario = rs.getInt("codigo");
                int codigoProducto = rs.getInt("codigoProducto");
                int unidadesAdquiridas = rs.getInt("unidadesAdquiridas");
                int unidadesVendidas =rs.getInt("unidadesVendidas");

                String consulta2="SELECT * FROM Inventario_Proveedor";
                Statement stmt2 = conexionBD.getConexionT().createStatement();
                ResultSet rs2 = stmt2.executeQuery(consulta2);

                ArrayList<Proveedor> listaProveedoresInventario=new ArrayList<>();

                while(rs2.next())
                {
                    if(rs2.getInt("codigoInventario")==codigoInventario)
                    {
                        int codigoProveedorInventario=rs2.getInt("codigoProveedor");
                        listaProveedoresInventario.add(buscarProveedor(codigoProveedorInventario));
                    }
                }

                Producto producto=buscarProducto(codigoProducto);
                Inventario inventario1=new Inventario(producto,unidadesAdquiridas,unidadesVendidas,codigoInventario,listaProveedoresInventario);
                inventario.add(inventario1);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public CategoriaProducto buscarCategoria(String nombreCategoriaSql) {
        for(int i=0;i<categorias.size();i++)
        {
            if(categorias.get(i).getNombre().equals(nombreCategoriaSql))
            {
                return categorias.get(i);
            }
        }
        return null;
    }

    public TipoFactura convertirTipoFactura(String tipo) {
        if(tipo.equals("cliente"))
        {
            return TipoFactura.CLIENTE;
        }
        return TipoFactura.PROVEEDOR;
    }

    public Producto buscarProducto(int codigo) {
        for(int i=0;i<productos.size();i++)
        {
            if(productos.get(i).getCodigo()==codigo)
            {
                return productos.get(i);
            }
        }
        return null;
    }

    public Administrador buscarAdmin(int codigoAdmin) {
        for(int i=0;i<administradores.size();i++)
        {
            if(administradores.get(i).getDocumentoEntidad()==codigoAdmin)
            {
                return administradores.get(i);
            }
        }
        return null;
    }

    public void agregarFacturasCajero(int documento,Factura factura) {
        if(factura.getTipoFactura().equals(TipoFactura.CLIENTE))
        {
            for(int i=0;i<cajeros.size();i++)
            {
                if(cajeros.get(i).getDocumentoEntidad()==documento)
                {
                    cajeros.get(i).getFacturas().add(factura);
                }
            }
        }
        else
        {
            for(int i=0;i<proveedores.size();i++)
            {
                if(proveedores.get(i).getCodigo()==documento)
                {
                    proveedores.get(i).getFacturasElementosAdquiridos().add(factura);
                }
            }
        }
    }

    public void agregarFacturasCliente(int documento,Factura factura) {
        if(factura.getTipoFactura().equals(TipoFactura.CLIENTE))
        {
            for(int i=0;i<clientes.size();i++)
            {
                if(clientes.get(i).getDocumentoEntidad()==documento)
                {
                    clientes.get(i).getFacturas().add(factura);
                }
            }
        }
    }

    public Proveedor buscarProveedor(int codigoProveedor) {
        for(int i=0;i<proveedores.size();i++)
        {
            if(proveedores.get(i).getCodigo()==codigoProveedor)
            {
                return proveedores.get(i);
            }
        }
        return null;
    }

    public Inventario buscarInventario(int codigoInventario) {
        for(int i=0;i<inventario.size();i++)
        {
            if(inventario.get(i).getCodigoInstancia()==codigoInventario)
            {
                return inventario.get(i);
            }
        }
        return null;
    }

    public boolean verificarCodigoNoRepetido(int numero,int objetoAVerificar) {
        if(objetoAVerificar==1)
        {
            for(Inventario inventario: inventario)
            {
                if(inventario.getCodigoInstancia()==numero)
                {
                    return true;
                }
            }
        }
        else if(objetoAVerificar==2)
        {
            for(Modificacion modificacion: modificaciones)
            {
                if(modificacion.getCodigoInstancia()==numero)
                {
                    return true;
                }
            }
        }
        else if(objetoAVerificar==3)
        {
            for(Producto producto: productos)
            {
                if(producto.getCodigo()==numero)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int seleccionarNumeroAleatorio(int objetoAVerificar) {
        int numeroAleatorio=(int)(Math.random() * 10000);
        while(verificarCodigoNoRepetido(numeroAleatorio,objetoAVerificar))
        {
            numeroAleatorio=(int)(Math.random() * 10000);
        }
        return numeroAleatorio;
    }

}
