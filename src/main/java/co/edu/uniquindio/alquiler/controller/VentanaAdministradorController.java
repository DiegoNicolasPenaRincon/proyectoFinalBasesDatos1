package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoExistenteException;
import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.exceptions.ProveedorException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VentanaAdministradorController {


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
    private Button eliminarProductoButton;
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
        this.proveedoresApoyo=new ArrayList<>();
        refrescarProveedoresAgregadosCombo();
        proveedoresComboBox.setItems(FXCollections.observableList(tiendaUQ.getProveedores()));;
        categoriasComboBox.setItems(FXCollections.observableList(tiendaUQ.getCategorias()));

        SpinnerValueFactory<Integer> valueFactoryDisponibles =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);

        SpinnerValueFactory<Integer> valueFactoryVendidas =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);

        SpinnerValueFactory<Double> valueFactoryValor =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,1000.0,0.0,50.00);

        unidadesDisponiblesSpinner.setValueFactory(valueFactoryDisponibles);
        unidadesVendidasSpinner.setValueFactory(valueFactoryVendidas);
        valorProductoSpinner.setValueFactory(valueFactoryValor);

        inventarioTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            Inventario inventario=inventarioTable.getSelectionModel().getSelectedItem();
            if (newVal != null)
            {
                agregarProductoButton.setDisable(true);
                modificarProductoButton.setDisable(false);
                proveedoresAgregadosComboBox.setItems(FXCollections.observableList(inventario.getProveedores()));
            }

        });

        nombreInventarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getProducto().getNombre()));
        codigoInventarioPColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProducto().getCodigo())));
        disponiblesColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesDisponibles()) ) );
        vendidasColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesVendidas()) ) );
        numeroReferenciaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoInstancia())));

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
            else if(categoria.isEmpty())
            {
                throw new AtributoVacioException("Debe seleccionar una categoria");
            }
            else if(proveedoresApoyo.isEmpty())
            {
                throw new AtributoVacioException("Debe seleccionar como minimo un proveedor");
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
            Inventario inventario=new Inventario(producto,disponibles,vendidas,tiendaUQ.seleccionarNumeroAleatorio(1),proveedoresApoyo);
            Modificacion inicial=new Modificacion(datosAdmin.getUsuarioActivo(), LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),
                    inventario,"Creacion de la instancia de inventario del producto: "+producto.getNombre()+" con codigo: "+producto.getCodigo());
            proveedoresApoyo.clear();
            inventario.getModificaciones().add(inicial);
            tiendaUQ.getInventario().add(inventario);
            refrescarProveedoresAgregadosCombo();
        }
        catch (NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("Las unidades disponibles, unidades vendidas y el codigo del producto deben contener valores numericos");
            alert.show();
        }
        catch (AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Alerta");
                    alert.setContentText("Proveedor agregado correctamente");
                    alert.show();
                }
                else
                {
                    throw new ProveedorException("El proveedor ya fue agregador");
                }
            }
        }
        catch (AtributoVacioException | ProveedorException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Alerta");
                alert.setContentText("Proveedor eliminado con exito");
                alert.show();
            }
        }
        catch (AtributoVacioException | ProveedorException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void modificarProductoOnAction(ActionEvent actionEvent) {

    }

    public void eliminarProductoOnAction(ActionEvent actionEvent) {
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
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
        inventarioTable.getSelectionModel().clearSelection();
        modificarProductoButton.setDisable(true);
        agregarProductoButton.setDisable(false);
    }

    public void refrescarProveedoresAgregadosCombo() {
        proveedoresAgregadosComboBox.setItems(FXCollections.observableList(proveedoresApoyo));
    }
}
