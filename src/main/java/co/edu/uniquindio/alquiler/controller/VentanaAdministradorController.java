package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.*;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VentanaAdministradorController {

    @FXML
    private Button catalogarButton;
    @FXML
    private TableColumn<Inventario,String> disponibleProductoColumn;
    @FXML
    private Label valorPorductoLabel;
    @FXML
    private Spinner<Double> valorProductoSpinner;
    @FXML
    private Button deseleccionarButton;
    @FXML
    private Button InformacionGeneralButton;
    @FXML
    private Button verificarPedidos;
    @FXML
    private Button modificarProductoButton;
    @FXML
    private Button verificarModificacionesButton;
    @FXML
    private Label proveedoresAgregadosLabel;
    @FXML
    private ComboBox<Proveedor> proveedoresAgregadosComboBox;
    @FXML
    private Button quitarProveedorProductoButton;
    @FXML
    private Button descatalogarButton;
    @FXML
    private Label opcionesAdminLbl;
    @FXML
    private Spinner<Integer> unidadesDisponiblesSpinner;
    @FXML
    private Spinner<Integer> unidadesVendidasSpinner;
    @FXML
    private ComboBox<Proveedor> proveedoresComboBox;
    @FXML
    private Label proveedoresLabel;
    @FXML
    private Button agregaProveedorInventarioButton;
    @FXML
    private ComboBox<CategoriaProducto> categoriasComboBox;
    @FXML
    private Label categoriasLabel;
    @FXML
    private Label nombreAgregarLabel;
    @FXML
    private TextField agregarNombreTxtField;
    @FXML
    private Label codigoAgregarLable;
    @FXML
    private TextField agregarCodigoTxtfield;
    @FXML
    private Label agregarDisponiblesLabel;
    @FXML
    private Label agregarVendidasLabel;
    @FXML
    private TableColumn<Inventario,String> nombreInventarioColumn;
    @FXML
    private TableColumn<Inventario,String> codigoInventarioPColum;
    @FXML
    private Button agregarProductoButton;
    @FXML
    private TableView<Inventario> inventarioTable;
    @FXML
    private TableColumn<Inventario,String> disponiblesColum;
    @FXML
    private TableColumn<Inventario,String> vendidasColumn;
    @FXML
    private TableColumn<Inventario,String> numeroReferenciaColumn;


    TiendaUQ tiendaUQ=TiendaUQ.getInstance();
    DatosSesionAdministrador datosAdmin= DatosSesionAdministrador.getInstance();
    ArrayList<Proveedor> proveedoresApoyo;
    ConsultaDato consultaDato=ConsultaDato.getInstance();

    public void initialize() {
        modificarProductoButton.setDisable(true);
        descatalogarButton.setDisable(true);
        catalogarButton.setDisable(true);
        this.proveedoresApoyo=new ArrayList<>();
        refrescarProveedoresAgregadosCombo();
        proveedoresComboBox.setItems(FXCollections.observableList(tiendaUQ.getProveedores()));;
        categoriasComboBox.setItems(FXCollections.observableList(tiendaUQ.getCategorias()));

        SpinnerValueFactory<Integer> valueFactoryDisponibles =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);

        SpinnerValueFactory<Integer> valueFactoryVendidas =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);

        SpinnerValueFactory<Double> valueFactoryValor =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0,1000.0,0.0,50.00);

        unidadesDisponiblesSpinner.setValueFactory(valueFactoryDisponibles);
        unidadesVendidasSpinner.setValueFactory(valueFactoryVendidas);
        valorProductoSpinner.setValueFactory(valueFactoryValor);

        inventarioTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            Inventario inventario=inventarioTable.getSelectionModel().getSelectedItem();
            if (newVal != null)
            {
                agregarProductoButton.setDisable(true);
                modificarProductoButton.setDisable(false);
                agregarCodigoTxtfield.setDisable(true);
                if(inventario.isDescatalogado())
                {
                    descatalogarButton.setDisable(true);
                    catalogarButton.setDisable(false);
                }
                else
                {
                    catalogarButton.setDisable(true);
                    descatalogarButton.setDisable(false);
                }
                proveedoresApoyo.clear();
                proveedoresApoyo.addAll(inventario.getProveedores());
                refrescarProveedoresAgregadosCombo();
            }

        });

        nombreInventarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getProducto().getNombre()));
        codigoInventarioPColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProducto().getCodigo())));
        disponiblesColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesDisponibles()) ) );
        vendidasColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesVendidas()) ) );
        numeroReferenciaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoInstancia())));
        disponibleProductoColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().isDescatalogado())));

        this.inventarioTable.setItems(FXCollections.observableList(tiendaUQ.getInventario()));

    }


    public void agregarProductoOnAction(ActionEvent actionEvent) {
        try
        {
            String nombre=agregarNombreTxtField.getText();
            int codigo=Integer.parseInt(agregarCodigoTxtfield.getText());
            int disponibles=unidadesDisponiblesSpinner.getValue();
            int vendidas=unidadesVendidasSpinner.getValue();
            double valor=valorProductoSpinner.getValue();
            String categoria=categoriasComboBox.getSelectionModel().getSelectedItem().getNombre();
            if(nombre.isEmpty())
            {
                throw new AtributoVacioException("Debe ingresar un nombre");
            }
            else if(tiendaUQ.verificarCodigoNoRepetido(codigo,3))
            {
                throw new AtributoExistenteException("Ese producto ya existe");
            }
            else if(proveedoresApoyo.isEmpty())
            {
                throw new ProveedorException("Debe seleccionar por lo menos un proveedor");
            }
            Producto producto=new Producto(nombre,categoriasComboBox.getSelectionModel().getSelectedItem(),codigo,valor);
            tiendaUQ.exportarProducto(producto);
            tiendaUQ.exportarProveedorProducto(producto.getCodigo(),proveedoresApoyo);
            Inventario inventario=new Inventario(producto,disponibles,vendidas,tiendaUQ.seleccionarNumeroAleatorio(1),proveedoresApoyo,false);
            tiendaUQ.exportarInventario(inventario);
            tiendaUQ.exportarInventarioProveedor(inventario.getCodigoInstancia(),proveedoresApoyo);
            Modificacion inicial=new Modificacion(datosAdmin.getUsuarioActivo(), LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),
                    inventario,"Creacion de la instancia de inventario del producto: "+producto.getNombre()+" con codigo: "+producto.getCodigo());
            tiendaUQ.exportarModificacion(inicial);
            proveedoresApoyo.clear();
            inventario.getModificaciones().add(inicial);
            tiendaUQ.getInventario().add(inventario);
            refrescarProveedoresAgregadosCombo();
            inventarioTable.refresh();

            tiendaUQ.mostrarConfirmacion("Producto creado con exito");
            resetearDatos();
        }
        catch (NumberFormatException e)
        {
            tiendaUQ.mostrarAlerta("Las unidades disponibles, unidades vendidas y el codigo del producto deben contener valores numericos");
        }
        catch (AtributoVacioException |AtributoExistenteException | ProveedorException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
        catch (NullPointerException e)
        {
            tiendaUQ.mostrarAlerta("Debe seleccionar como minimo una categoria");
        }
    }

    public void agregarProveedorProductoOnAction(ActionEvent actionEvent) {
        Proveedor proveedor=proveedoresComboBox.getSelectionModel().getSelectedItem();
        try
        {
            if(proveedor==null)
            {
                throw new AtributoVacioException("debe seleccionar por lo menos un proveedor");
            }
            else
            {
                if(tiendaUQ.buscarProveedor(proveedor.getCodigo(),proveedoresApoyo)==null)
                {
                    proveedoresApoyo.add(proveedor);
                    refrescarProveedoresAgregadosCombo();
                    tiendaUQ.mostrarInformacion("Proveedor agregado correctamente");
                }
                else
                {
                    throw new ProveedorException("El proveedor ya fue agregado");
                }
            }
        }
        catch (AtributoVacioException | ProveedorException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
    }

    public void quitarProveedor(ActionEvent actionEvent) {
        Proveedor proveedorAgregado=proveedoresAgregadosComboBox.getSelectionModel().getSelectedItem();
        try
        {
            if(proveedorAgregado==null)
            {
                throw new AtributoVacioException("debe seleccionar por lo menos un proveedor");
            }
            else
            {
                proveedoresApoyo.remove(proveedorAgregado);
                refrescarProveedoresAgregadosCombo();
                tiendaUQ.mostrarInformacion("Proveedor eliminado con exito");
            }
        }
        catch (AtributoVacioException | ProveedorException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
    }

    public void verificarModificacionesOnAction(ActionEvent actionEvent) {
        Inventario inventario=inventarioTable.getSelectionModel().getSelectedItem();
        try
        {
            if(inventario!=null)
            {
                consultaDato.setValor(2);
                consultaDato.setcodigoUniversal(inventario.getCodigoInstancia());
                tiendaUQ.inicializarConsultas();
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar una instancia del inventario");
            }
        }
        catch (AtributoVacioException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void modificarProductoOnAction(ActionEvent actionEvent) {
        Inventario inventarioSeleccionado=inventarioTable.getSelectionModel().getSelectedItem();
        try
        {
            if(inventarioSeleccionado!=null)
            {
                String nombre = agregarNombreTxtField.getText();
                int disponibles = unidadesDisponiblesSpinner.getValue();
                int vendidas = unidadesVendidasSpinner.getValue();
                double valor = valorProductoSpinner.getValue();
                Producto producto = tiendaUQ.buscarProducto(inventarioSeleccionado.getProducto().getCodigo());
                producto.setValor(valor);

                if(categoriasComboBox.getSelectionModel().getSelectedItem()!=null)
                {
                    producto.setCategoria(categoriasComboBox.getSelectionModel().getSelectedItem());
                }

                if(!proveedoresApoyo.isEmpty())
                {
                    inventarioSeleccionado.setProveedores(tiendaUQ.agregarProveedores(inventarioSeleccionado.getProveedores(),proveedoresApoyo));
                }

                if(!nombre.isEmpty())
                {
                    producto.setNombre(nombre);
                }
                producto.setCodigo(inventarioSeleccionado.getProducto().getCodigo());

                ArrayList<Integer> codigosProveedores=tiendaUQ.rellenarCodigosProveedores(proveedoresApoyo);

                tiendaUQ.modificarInstanciaInventario(inventarioSeleccionado.getCodigoInstancia(),disponibles,vendidas);
                tiendaUQ.modificarProducto(producto);
                tiendaUQ.eliminarProveedorProducto(codigosProveedores,inventarioSeleccionado.getProducto().getCodigo());
                tiendaUQ.eliminarInventarioProveedor(codigosProveedores,inventarioSeleccionado.getCodigoInstancia());
                tiendaUQ.agregarProveedoresProducto(codigosProveedores,producto.getCodigo());
                tiendaUQ.agregarInventarioProveedor(codigosProveedores,inventarioSeleccionado.getCodigoInstancia());

                Modificacion inicial=new Modificacion(datosAdmin.getUsuarioActivo(), LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),
                        inventarioSeleccionado,"Se modifico el producto "+inventarioSeleccionado.getProducto().getCodigo());
                tiendaUQ.exportarModificacion(inicial);
                inventarioSeleccionado.setProducto(producto);
                inventarioSeleccionado.getModificaciones().add(inicial);
                inventarioSeleccionado.setUnidadesDisponibles(disponibles);
                inventarioSeleccionado.setUnidadesVendidas(vendidas);
                inventarioSeleccionado.setProveedores(proveedoresApoyo);

                proveedoresApoyo.clear();
                tiendaUQ.reemplazarValor(inventarioSeleccionado.getCodigoInstancia(),inventarioSeleccionado);
                refrescarProveedoresAgregadosCombo();
                inventarioTable.refresh();
                deseleccionar();
                tiendaUQ.mostrarConfirmacion("Producto modificado con exito");
                resetearDatos();
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar el producto que va a modificar");
            }
        }
        catch (AtributoVacioException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void catalogarProductoOnAction(ActionEvent actionEvent) {
        catalogarDescatalogar(2);
        catalogarButton.setDisable(true);
        descatalogarButton.setDisable(false);
    }

    public void descatalogarOnAction(ActionEvent actionEvent) {
        catalogarDescatalogar(1);
        descatalogarButton.setDisable(true);
        catalogarButton.setDisable(false);
    }

    public void verificarPedidosOnAction(ActionEvent actionEvent) {
        Inventario inventario=inventarioTable.getSelectionModel().getSelectedItem();
        try
        {
            if(inventario!=null)
            {
                consultaDato.setValor(1);
                consultaDato.setcodigoUniversal(inventario.getProducto().getCodigo());
                tiendaUQ.inicializarConsultas();
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar una instancia del inventario");
            }
        }
        catch (AtributoVacioException e)
        {
           tiendaUQ.mostrarAlerta(e.getMessage());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void InformacionGeneralOnAction(ActionEvent actionEvent) {
        try
        {
            consultaDato.setValor(3);
            tiendaUQ.inicializarConsultas();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void deseccionarOnAction(ActionEvent actionEvent) {
        deseleccionar();
    }

    public void deseleccionar() {
        inventarioTable.getSelectionModel().clearSelection();
        modificarProductoButton.setDisable(true);
        agregarProductoButton.setDisable(false);
        descatalogarButton.setDisable(true);
        catalogarButton.setDisable(true);
        agregarCodigoTxtfield.setDisable(false);
        proveedoresApoyo.clear();
    }

    public void refrescarProveedoresAgregadosCombo() {
        proveedoresAgregadosComboBox.setItems(FXCollections.observableList(proveedoresApoyo));
    }

    public void catalogarDescatalogar(int tipo) {
        Inventario inventario=inventarioTable.getSelectionModel().getSelectedItem();
        try
        {
            if(inventario!=null)
            {
                if(tipo==1)
                {
                    Modificacion modificacion=new Modificacion(datosAdmin.getUsuarioActivo(),LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),inventario,"El producto con codigo "+inventario.getProducto().getCodigo()+", fue descatalogado");
                    inventario.setDescatalogado(true);
                    tiendaUQ.descatalogarcatalogarProducto(inventario.getProducto().getCodigo(),1);
                    tiendaUQ.exportarModificacion(modificacion);
                    tiendaUQ.mostrarInformacion("El producto fue descatalogado con exito");
                }
                else
                {
                    Modificacion modificacion=new Modificacion(datosAdmin.getUsuarioActivo(),LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),inventario,"El producto con codigo "+inventario.getProducto().getCodigo()+", fue catalogado");
                    inventario.setDescatalogado(false);
                    tiendaUQ.descatalogarcatalogarProducto(inventario.getProducto().getCodigo(),2);
                    tiendaUQ.exportarModificacion(modificacion);
                    tiendaUQ.mostrarInformacion("El producto fue catalogado con exito");
                }

                inventarioTable.refresh();
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar el producto que desea eliminar");
            }
        }
        catch (AtributoVacioException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
    }

    public void resetearDatos() {
        agregarCodigoTxtfield.clear();
        agregarNombreTxtField.clear();
    }

}
