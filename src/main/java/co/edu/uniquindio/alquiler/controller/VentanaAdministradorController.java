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
    private ComboBox<Proveedor> proveedoresComboBox;
    @FXML
    private Label proveedoresLabel;
    @FXML
    private Button agregaProveedorInventarioButton;
    @FXML
    private Button categoriasButton;
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
    private TextField agregarDisponiblesProductoTxtField;
    @FXML
    private TextField agregarVendidasProductoTxtField;
    @FXML
    private Label agregarVendidasLabel;
    @FXML
    private TableView<Proveedor> proveedoresTable;
    @FXML
    private TableColumn<Proveedor,String> nombreProveColum;
    @FXML
    private TableColumn<Proveedor,String> idProveColumn;
    @FXML
    private TableColumn<Proveedor,String> telefonoProveColumn;
    @FXML
    private TableColumn<Proveedor,String> direccionProveColumn;
    @FXML
    private TableView<Modificacion> modificacionesTable;
    @FXML
    private TableColumn<Modificacion,String> nombreadminModiColum;
    @FXML
    private TableColumn<Modificacion,String> codigoAdminModiColum;
    @FXML
    private TableColumn<Modificacion,String> fechaModiColumn;
    @FXML
    private TableColumn<Modificacion,String> inventarioModiColum;
    @FXML
    private TableColumn<Modificacion,String> codigoModiColum;
    @FXML
    private Button verificarModificacionesButton;
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
    @FXML
    private Button verificarProveedoresButton;
    @FXML
    private TableView<Factura> listaRecibosCajerosTable;
    @FXML
    private TableColumn<Factura,String>  clienteFacturaColumn;
    @FXML
    private TableColumn<Factura,String>  cajeroFacturaColumn;
    @FXML
    private TableColumn<Factura,String>  codigoFacturaColumn;
    @FXML
    private TableColumn<Factura,String>  fechaPagoFacturaColum;
    @FXML
    private TableColumn<Factura,String>  costoFacturaColum;
    @FXML
    private Button masDetallesButton;
    @FXML
    private Label opcionesLabel;
    @FXML
    private TableView<Cajero> cajerosTable;
    @FXML
    private TableColumn<Cajero,String> nombreCajeroColumn;
    @FXML
    private TableColumn<Cajero,String> IDCajeroColumn;
    @FXML
    private TableColumn<Cajero,String> correoCajeroColumn;
    @FXML
    private TableColumn<Cajero,String> telefonoCajeroColumn;
    @FXML
    private TableColumn<Cajero, String> salarioColumn;
    @FXML
    private Button cajerosButton;
    @FXML
    private Button inventarioButton;
    @FXML
    private Button pedidosButton;
    @FXML
    private Button clientesButton;
    @FXML
    private Button facturasButton;
    @FXML
    private Button proveedoresButton;
    @FXML
    private Button verificarFacturasButton;

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
        cajerosTable.setVisible(false);
        listaRecibosCajerosTable.setVisible(false);
        masDetallesButton.setVisible(false);
        inventarioTable.setVisible(false);
        agregarProductoButton.setVisible(false);
        verificarProveedoresButton.setVisible(false);
        verificarModificacionesButton.setVisible(false);
        proveedoresTable.setVisible(false);
        nombreAgregarLabel.setVisible(false);
        agregarNombreTxtField.setVisible(false);
        codigoAgregarLable.setVisible(false);
        agregarCodigoTxtfield.setVisible(false);
        agregarDisponiblesLabel.setVisible(false);
        agregarDisponiblesProductoTxtField.setVisible(false);
        agregarVendidasProductoTxtField.setVisible(false);
        agregarVendidasLabel.setVisible(false);
        this.proveedoresApoyo=new ArrayList<>();
        proveedoresLabel.setVisible(false);
        agregaProveedorInventarioButton.setVisible(false);

        nombreInventarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getProducto().getNombre()));
        codigoInventarioPColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProducto().getCodigo())));
        disponiblesColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesAdquiridas()) ) );
        vendidasColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUnidadesVendidas()) ) );
        numeroReferenciaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoInstancia())));

        nombreCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        cajeroFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDocumentoEntidadCajero())));
        fechaPagoFacturaColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getFechaPago()) ) );
        costoFacturaColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCostoTotal()) ) );
        codigoFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigo())));

        clienteFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getDocumentoEntidadCliente())));
        IDCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDocumentoEntidad())));
        correoCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCorreo() ) );
        telefonoCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getTelefono() ) );
        salarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSalario())));

        nombreadminModiColum.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getAdministrador().getNombre()));
        codigoAdminModiColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAdministrador().getDocumentoEntidad())));
        fechaModiColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getFechaModificacion()) ) );
        inventarioModiColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getInventario().getCodigoInstancia()) ) );
        codigoModiColum.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoInstancia())));

        nombreProveColum.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        idProveColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigo())));
        telefonoProveColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getTelefono()) ) );
        direccionProveColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getDireccion()) ) );


        this.cajerosTable.setItems(FXCollections.observableList(tiendaUQ.getCajeros()));
        this.inventarioTable.setItems(FXCollections.observableList(tiendaUQ.getInventario()));

    }

    public void mostrarCajerosOnAction(ActionEvent actionEvent) {
        cajerosTable.setVisible(true);
        verificarFacturasButton.setVisible(true);
        listaRecibosCajerosTable.setVisible(false);
        masDetallesButton.setVisible(false);
        inventarioTable.setVisible(false);
        agregarProductoButton.setVisible(false);
        verificarProveedoresButton.setVisible(false);
        verificarModificacionesButton.setVisible(false);
        proveedoresTable.setVisible(false);
        modificacionesTable.setVisible(false);
        categoriasComboBox.setVisible(false);
        proveedoresComboBox.setVisible(false);


    }

    public void verificarFacturasCajeroOnAction(ActionEvent actionEvent) {
        Cajero cajeroSeleccionado=cajerosTable.getSelectionModel().getSelectedItem();
        if(cajeroSeleccionado!=null)
        {
            cajerosTable.setVisible(false);
            verificarFacturasButton.setVisible(false);
            this.listaRecibosCajerosTable.setItems(FXCollections.observableList(cajeroSeleccionado.getFacturas()));
            listaRecibosCajerosTable.setVisible(true);
            masDetallesButton.setVisible(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("No ha seleccionado ningun cajero");
            alert.show();
        }
    }

    public void mostrarFacturaCompleta(ActionEvent actionEvent) {

    }

    public void mostrarInventarioOnAction(ActionEvent actionEvent) {
        inventarioTable.setVisible(true);
        agregarProductoButton.setVisible(true);
        verificarProveedoresButton.setVisible(true);
        verificarModificacionesButton.setVisible(true);
        cajerosTable.setVisible(false);
        listaRecibosCajerosTable.setVisible(false);
        masDetallesButton.setVisible(false);
        verificarFacturasButton.setVisible(false);
        nombreAgregarLabel.setVisible(true);
        agregarNombreTxtField.setVisible(true);
        codigoAgregarLable.setVisible(true);
        agregarCodigoTxtfield.setVisible(true);
        agregarDisponiblesLabel.setVisible(true);
        agregarDisponiblesProductoTxtField.setVisible(true);
        agregarVendidasProductoTxtField.setVisible(true);
        agregarVendidasLabel.setVisible(true);
        categoriasComboBox.setVisible(true);
        proveedoresComboBox.setVisible(true);
        proveedoresLabel.setVisible(true);
        categoriasLabel.setVisible(true);
        agregaProveedorInventarioButton.setVisible(true);
    }

    public void verificarProveeOnAction(ActionEvent actionEvent) {
        Inventario inventarioSeleccionado=inventarioTable.getSelectionModel().getSelectedItem();
        if(inventarioSeleccionado!=null)
        {
            inventarioTable.setVisible(false);
            agregarProductoButton.setVisible(false);
            verificarProveedoresButton.setVisible(false);
            verificarModificacionesButton.setVisible(false);
            this.proveedoresTable.setItems(FXCollections.observableList(inventarioSeleccionado.getProveedores()));
            proveedoresTable.setVisible(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("No ha seleccionado ninguna instancia de inventario");
            alert.show();
        }

    }

    public void verificarModifOnAction(ActionEvent actionEvent) {
        Inventario inventarioSeleccionado=inventarioTable.getSelectionModel().getSelectedItem();
        if(inventarioSeleccionado!=null)
        {
            inventarioTable.setVisible(false);
            agregarProductoButton.setVisible(false);
            verificarProveedoresButton.setVisible(false);
            verificarModificacionesButton.setVisible(false);
            this.modificacionesTable.setItems(FXCollections.observableList(inventarioSeleccionado.getModificaciones()));
            modificacionesTable.setVisible(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("No ha seleccionado ninguna instancia de inventario");
            alert.show();
        }
    }

    public void agregarProductoOnAction(ActionEvent actionEvent) {
        try
        {
            String nombre=agregarNombreTxtField.getText();
            int codigo=Integer.parseInt(agregarCodigoTxtfield.getText());
            int disponibles=Integer.parseInt(agregarDisponiblesProductoTxtField.getText());
            int vendidas=Integer.parseInt(agregarVendidasProductoTxtField.getText());
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
