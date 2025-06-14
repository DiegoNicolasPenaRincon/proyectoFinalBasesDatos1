package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CajeroVentanaController {
    @FXML
    private TableColumn<ContenedorProductoCajero,String> cantidadProductoColumn;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> nombreClienteColumn;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> telefonoClienteColumn;
    @FXML
    private TableView<ContenedorProductoCajero> productosAdquiridosTable;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> nombreProductoColumn;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> codigoProductoColumn;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> categoriaProductoColumn;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> nombreProveedorColumn;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> codigoProveedorColumn;
    @FXML
    private TableColumn<ContenedorProductoCajero,String> direccionProveedorColumn;
    @FXML
    private Label opcionesCajeroLbl;
    @FXML
    private Button verificarProductosButton;
    @FXML
    private Button verificarClienteButton;
    @FXML
    private TableView<ContenedorImporteCajero> cajeroTable;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> fechaPagoolumn;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> codigoFacturaColumn;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> totalColumn;
    @FXML
    private TableColumn<ContenedorImporteCajero,String> idClienteColumn;

    TiendaUQ tiendaUQ=TiendaUQ.getInstance();
    DatosSesionCajero datosCajero= DatosSesionCajero.getInstance();

    public void initialize() {
        productosAdquiridosTable.setVisible(false);
        this.cajeroTable.setItems(FXCollections.observableList(tiendaUQ.importarDatosFacturaCajero(datosCajero.getUsuarioActivo().getDocumentoEntidad())));

        fechaPagoolumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getFechaPago())));
        codigoFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoFactura())));
        totalColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getTotal()) ) );
        idClienteColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getIdCliente()) ) );
        nombreClienteColumn.setCellValueFactory( cellData -> new SimpleStringProperty(cellData.getValue().getNombreCliente()));
        telefonoClienteColumn.setCellValueFactory( cellData -> new SimpleStringProperty(cellData.getValue().getTelefonoCliente()));

        cantidadProductoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCantidadProducto())));
        nombreProductoColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreProducto())));
        codigoProductoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCodigoProducto()) ) );
        categoriaProductoColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCategoriaNombre()) ) );
        nombreProveedorColumn.setCellValueFactory( cellData -> new SimpleStringProperty(cellData.getValue().getNombreProveedor()));
        codigoProveedorColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCodigoProveedor()) ) );
        direccionProveedorColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getDireccionProveedor()) ) );
    }

    public void verificarProductosOnAction(ActionEvent actionEvent) {
        ContenedorImporteCajero contenedorImporteCajero=cajeroTable.getSelectionModel().getSelectedItem();
        try
        {
            if(contenedorImporteCajero!=null)
            {
                this.productosAdquiridosTable.setItems(FXCollections.observableList(tiendaUQ.importarPorductosCajero(contenedorImporteCajero.getCodigoFactura())));
                productosAdquiridosTable.setVisible(true);
            }
            else
            {
                throw new AtributoVacioException("Debe seleccionar por lo menos un elemento de la tabla");
            }
        }

        catch (AtributoVacioException e)
        {
            tiendaUQ.mostrarAlerta(e.getMessage());
        }
    }

}
