package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoExistenteException;
import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class VentanaAdministradorController {


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
    DatosSesion<Administrador> datosAdmin= DatosSesion.getInstance();
    ArrayList<Proveedor> proveedoresApoyo;

    public void initialize() {
        proveedoresComboBox=new ComboBox<>();
        proveedoresComboBox.setItems(FXCollections.observableList(tiendaUQ.getProveedores()));
        proveedoresComboBox.setVisible(false);
        categoriasComboBox=new ComboBox<>();
        categoriasComboBox.setItems(FXCollections.observableList(tiendaUQ.getCategorias()));
        categoriasComboBox.setVisible(false);

        inventarioTable.setVisible(false);
        agregarProductoButton.setVisible(false);
        nombreAgregarLabel.setVisible(false);
        agregarNombreTxtField.setVisible(false);
        codigoAgregarLable.setVisible(false);
        agregarCodigoTxtfield.setVisible(false);
        agregarDisponiblesLabel.setVisible(false);
        agregarVendidasLabel.setVisible(false);
        this.proveedoresApoyo=new ArrayList<>();
        proveedoresLabel.setVisible(false);
        agregaProveedorInventarioButton.setVisible(false);

        nombreInventarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getProducto().getNombre()));
        codigoInventarioPColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProducto().getCodigo())));
        disponiblesColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesAdquiridas()) ) );
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

            Producto producto=new Producto(nombre,categoriasComboBox.getSelectionModel().getSelectedItem(),codigo,disponibles);
            Inventario inventario=new Inventario(producto,disponibles,vendidas,tiendaUQ.seleccionarNumeroAleatorio(1),proveedoresApoyo);
            Modificacion inicial=new Modificacion(datosAdmin.getUsuarioActivo(), LocalDateTime.now(),tiendaUQ.seleccionarNumeroAleatorio(2),inventario);
            inventario.getModificaciones().add(inicial);
            tiendaUQ.getProductos().add(producto);
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

    public void pedidosOnAction(ActionEvent actionEvent) {
    }

    public void clientesOnAction(ActionEvent actionEvent) {
    }

    public void facturasOnAction(ActionEvent actionEvent) {
    }

    public void proveedoresOnAction(ActionEvent actionEvent) {
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
                proveedoresApoyo.add(proveedor);
            }
        }
        catch (AtributoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
