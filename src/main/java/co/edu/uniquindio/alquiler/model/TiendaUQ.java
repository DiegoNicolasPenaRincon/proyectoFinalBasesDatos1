package co.edu.uniquindio.alquiler.model;


import co.edu.uniquindio.alquiler.controller.CajeroVentanaController;
import co.edu.uniquindio.alquiler.controller.MostrarConsultasAdminController;
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

    public void inicializarConsultas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/MostrarConsultasAdmin.fxml"));
        Parent root = loader.load();

        MostrarConsultasAdminController consultasAdminController =loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
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

    public TipoFactura convertirTipoFactura(String tipo) {
        if(tipo.equals("cliente"))
        {
            return TipoFactura.CLIENTE;
        }
        return TipoFactura.PROVEEDOR;
    }

    public Producto buscarProducto(int codigoEntrante) throws SQLException {
        String consulta = "SELECT * FROM Producto WHERE codigo=?";
        PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
        stmt.setInt(1, codigoEntrante);

        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            int codigo = rs.getInt("codigo");
            if(codigo==codigoEntrante)
            {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                CategoriaProducto categoriaProducto=buscarCategoria(categoria);
                int unidadesDisponibles =rs.getInt("undidadesDisponibles");
                return new Producto(nombre,categoriaProducto,codigo,unidadesDisponibles);
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

    /*public CategoriaProducto buscarCategoria(String nombre) throws SQLException {
        String consulta = "SELECT * FROM CategoriaProducto WHERE nombre=?";
        PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
        stmt.setString(1, nombre);

        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            String nombreCategoria = rs.getString("nombre");
            if(nombreCategoria.equals(nombre))
            {
                double iva=rs.getDouble("iva");
                double utilidad=rs.getDouble("utilidad");
                return new CategoriaProducto(nombre,utilidad,iva);
            }
        }
        return null;
    }


     */

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

    public ArrayList<ContenedorImporteCajero> importarDatosFacturaCajero(int idCajeroSesionIniciada)  {
        ArrayList<ContenedorImporteCajero> listasCajeros=new ArrayList<>();
        try
        {
            String consulta = """
            SELECT f.FechaPago, f.codigo, f.documentoEntidadCliente, 
                   c.nombre, c.telefono, f.total 
            FROM Factura f
            JOIN Cliente c ON c.documentoEntidad = f.documentoEntidadCliente
            WHERE f.documentoEntidadCajero = ?
            GROUP BY f.FechaPago, f.codigo, f.documentoEntidadCliente, 
                     c.nombre, c.telefono, f.total;
        """;
            PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
            stmt.setInt(1, idCajeroSesionIniciada);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LocalDateTime fechaPago = rs.getTimestamp("FechaPago").toLocalDateTime();
                int codigo = rs.getInt("codigo");
                int documentoEntidadCliente = rs.getInt("documentoEntidadCliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                double total = rs.getDouble("total");
                ContenedorImporteCajero contenedor=new ContenedorImporteCajero(fechaPago,codigo,documentoEntidadCliente,nombre,telefono,total);
                listasCajeros.add(contenedor);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return listasCajeros;
    }

    public ArrayList<ContenedorProductoCajero> importarPorductosCajero(int facturaId) {
        ArrayList<ContenedorProductoCajero> listaProductos=new ArrayList<>();
        try
        {
            String consulta = """
            SELECT 
                p.nombre AS nombreProducto, p.codigo AS codigoProducto, p.categoria,
                prove.nombre AS nombreProveedor, prove.codigo AS codigoProveedor, prove.direccion, fo.cantidadProducto
            FROM Producto p
            JOIN Proveedor_Producto pro ON pro.codigoProducto = p.codigo
            JOIN Proveedor prove ON prove.codigo = pro.codigoProveedor
            JOIN Factura_Producto fo ON fo.codigoProducto = p.codigo
            JOIN Factura f ON f.codigo = fo.codigoFactura
            WHERE f.codigo = ?
        """;
            PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
            stmt.setInt(1, facturaId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombreProducto = rs.getString("nombreProducto");
                int codigoProducto = rs.getInt("codigoProducto");
                String categoria = rs.getString("categoria");
                String nombreProveedor = rs.getString("nombreProveedor");
                int codigoProveedor = rs.getInt("codigoProveedor");
                String direccion = rs.getString("direccion");
                int cantidadProducto=rs.getInt("cantidadProducto");
                ContenedorProductoCajero contenedor=new ContenedorProductoCajero(nombreProducto,codigoProducto,categoria,nombreProveedor,codigoProveedor,direccion,cantidadProducto);
                listaProductos.add(contenedor);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public ArrayList<ContenedorConsultaPedido> importarConsultaPedido(int codigoProducto) {
        ArrayList<ContenedorConsultaPedido> listaPedidos=new ArrayList<>();
        try
        {
            String consulta="""
            
                   SELECT p.codigo AS codigoPedido, ad.documentoEntidad AS codigoAdministrador,ad.nombre AS nombreAdmin,prove.codigo AS codigoProveedor,prove.nombre AS nombreProveedor,p.fechaPedido,
                                                                         	   PP.codigoProducto
                                                                         	   FROM Pedido p
                                                                         	   JOIN Administrador ad ON ad.documentoEntidad=p.codigoAdministrador
                                                                         	   JOIN Proveedor prove ON prove.codigo=p.codigoProveedor
                                                                         	   JOIN Pedido_Producto PP ON PP.codigoPedido=p.codigo
                                                                         	   WHERE PP.codigoProducto=?;
            """;
            PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
            stmt.setInt(1, codigoProducto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int codigoPedido = rs.getInt("codigoPedido");
                int codigoAdmin = rs.getInt("codigoAdministrador");
                String nombreAdmin = rs.getString("nombreAdmin");
                int codigoProveedor = rs.getInt("codigoProveedor");
                String nombreProveedor = rs.getString("nombreProveedor");
                LocalDateTime fechaPedido = rs.getTimestamp("fechaPedido").toLocalDateTime();
                ContenedorConsultaPedido contenedor=new ContenedorConsultaPedido(codigoPedido,codigoAdmin,nombreAdmin,nombreProveedor,codigoProveedor,fechaPedido);
                listaPedidos.add(contenedor);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return listaPedidos;
    }

    public ArrayList<ContenedorModificaciones> importarModificaciones(int codigoInventario) {
        ArrayList<ContenedorModificaciones> listaModificaciones=new ArrayList<>();
        try
        {
            String consulta = """
            SELECT 
                ad.nombre AS nombreAdmin,
                ad.documentoEntidad AS documentoIdentidadAdmin,
                modi.fechaModificacion,
                modi.codigoInstancia
            FROM Administrador ad
            JOIN Modificacion modi ON modi.codigoAdmin = ad.documentoEntidad
            WHERE modi.codigoInventario=?""";

            PreparedStatement stmt = conexionBD.getConexionT().prepareStatement(consulta);
            stmt.setInt(1, codigoInventario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                String nombreAdmin = rs.getString("nombreAdmin");
                int documentoIdentidadAdmin = rs.getInt("documentoIdentidadAdmin");
                LocalDateTime fechaModificacion = rs.getTimestamp("fechaModificacion").toLocalDateTime();
                int codigoInstancia = rs.getInt("codigoInstancia");
                ContenedorModificaciones contenedor=new ContenedorModificaciones(nombreAdmin,documentoIdentidadAdmin,fechaModificacion,codigoInstancia);
                listaModificaciones.add(contenedor);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return listaModificaciones;
    }


}
