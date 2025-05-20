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


            consulta = "SELECT * FROM Producto";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombreProducto = rs.getString("nombre");
                String categoriaProducto = rs.getString("categoria");
                int codigoProucto =rs.getInt("codigo");
                int unidadesDisponibles =rs.getInt("undidadesDisponibles");
                Producto producto=new Producto(nombreProducto,buscarCategoria(categoriaProducto),codigoProucto,unidadesDisponibles);
                productos.add(producto);

            }

            consulta = "SELECT * FROM Administrador";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombreAdmin = rs.getString("nombre");
                String telefonoAdmin = rs.getString("telefono");
                String correoAdmin =rs.getString("correo");
                int documentoEntidad =rs.getInt("documentoEntidad");
                double salarioAdmin=rs.getDouble("salario");
                String contrasenaAdmin = rs.getString("contrasena");

                Administrador administrador=new Administrador(salarioAdmin,contrasenaAdmin,
                        nombreAdmin, telefonoAdmin,correoAdmin,documentoEntidad);
                System.out.println(administrador.getDocumentoEntidad());
                administradores.add(administrador);
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

            consulta = "SELECT * FROM Pedido";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                int codigoAdmin =rs.getInt("codigoAdministrador");
                LocalDate fechaPedido = rs.getDate("fechaPedido").toLocalDate();
                int codigo =rs.getInt("codigo");
                int codigoProveedor=rs.getInt("codigoProveedor");

                String consulta2="SELECT * FROM Pedido_Producto";
                Statement stmt2 = conexionBD.getConexionT().createStatement();
                ResultSet rs2 = stmt2.executeQuery(consulta2);

                Proveedor proveedorPedido=buscarProveedor(codigoProveedor);

                Administrador adminPedido=buscarAdmin(codigoAdmin);


                ArrayList<Producto> productosPedido=new ArrayList<>();

                while(rs2.next())
                {
                    if(rs2.getInt("codigoPedido")==codigo)
                    {
                        int codigoProducto=rs2.getInt("codigoProducto");
                        productosPedido.add(buscarProducto(codigoProducto));
                    }
                }

                Pedido pedido=new Pedido(codigo,proveedorPedido, fechaPedido.atStartOfDay(),adminPedido,productosPedido);
                adminPedido.getPedidos().add(pedido);
                proveedorPedido.getPedidos().add(pedido);
                pedidos.add(pedido);
            }


            consulta = "SELECT * FROM Cajero";
            rs = stmt.executeQuery(consulta);


            while(rs.next())
            {
                String nombreCajero = rs.getString("nombre");
                String telefonoCajero = rs.getString("telefono");
                String correoCajero =rs.getString("correo");
                int documentoEntidad =rs.getInt("documentoEntidad");
                double salarioCajero=rs.getDouble("salario");
                String contrasenaCajero = rs.getString("contrasena");

                Cajero cajero=new Cajero(contrasenaCajero,nombreCajero,telefonoCajero,correoCajero,documentoEntidad,salarioCajero);
                cajeros.add(cajero);
            }

            consulta = "SELECT * FROM Cliente";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                String nombreCliente = rs.getString("nombre");
                String telefonoCliente = rs.getString("telefono");
                String correoCliente =rs.getString("correo");
                int documentoEntidad =rs.getInt("documentoEntidad");

                Cliente cliente=new Cliente(nombreCliente,telefonoCliente,correoCliente,documentoEntidad);
                clientes.add(cliente);
            }

            consulta = "SELECT * FROM Factura";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                LocalDate fechaPago = rs.getDate("fechaPago").toLocalDate();
                int codigoFactura = rs.getInt("codigo");
                double total =rs.getDouble("total");
                int documentoEntidadCajero=rs.getInt("documentoEntidadCajero");
                int documentoEntidadCliente =rs.getInt("documentoEntidadCliente");
                String tipo=rs.getString("tipo");

                String consulta2="SELECT * FROM Factura_Producto";
                Statement stmt2 = conexionBD.getConexionT().createStatement();
                ResultSet rs2 = stmt2.executeQuery(consulta2);

                ArrayList<Producto> productosFactura=new ArrayList<>();

                while(rs2.next())
                {
                    if(rs2.getInt("codigoFactura")==codigoFactura)
                    {
                        int codigoProductoFactura=rs2.getInt("codigoProducto");
                        productosFactura.add(buscarProducto(codigoProductoFactura));
                    }
                }

                Factura factura=new Factura(documentoEntidadCliente,codigoFactura,documentoEntidadCajero,convertirTipoFactura(tipo), fechaPago.atStartOfDay(),total,productosFactura);
                agregarFacturasCajero(documentoEntidadCajero,factura);
                agregarFacturasCliente(documentoEntidadCliente,factura);
                facturas.add(factura);
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

            consulta="SELECT * FROM Modificacion";
            rs = stmt.executeQuery(consulta);

            while(rs.next())
            {
                int codigoAdmin = rs.getInt("codigoAdmin");
                int codigoInventario =rs.getInt("codigoInventario");
                LocalDate fechaModificacion = rs.getDate("fechaModificacion").toLocalDate();
                int codigoInstancia =rs.getInt("codigoInstancia");

                Administrador admin1=buscarAdmin(codigoAdmin);
                Inventario inventario=buscarInventario(codigoInventario);
                Modificacion modificacion=new Modificacion(admin1, fechaModificacion.atStartOfDay(),codigoInstancia,inventario);
                inventario.getModificaciones().add(modificacion);
                admin1.getModificaciones().add(modificacion);
                modificaciones.add(modificacion);
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
