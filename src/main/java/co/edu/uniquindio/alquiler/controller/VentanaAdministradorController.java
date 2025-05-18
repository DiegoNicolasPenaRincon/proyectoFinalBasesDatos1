package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.Cajero;
import co.edu.uniquindio.alquiler.model.Factura;
import co.edu.uniquindio.alquiler.model.TiendaUQ;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VentanaAdministradorController {

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

    public void initialize() {
        cajerosTable.setVisible(false);
        listaRecibosCajerosTable.setVisible(false);
        masDetallesButton.setVisible(false);

        nombreCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombre()));
        cajeroFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreCajero())));
        fechaPagoFacturaColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getFechaPago()) ) );
        costoFacturaColum.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCostoTotal()) ) );
        codigoFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigo())));

        clienteFacturaColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getNombreCliente()));
        IDCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDocumentoEntidad())));
        correoCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getCorreo() ) );
        telefonoCajeroColumn.setCellValueFactory( cellData -> new SimpleStringProperty( cellData.getValue().getTelefono() ) );
        salarioColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSalario())));


        this.cajerosTable.setItems(FXCollections.observableList(tiendaUQ.getCajeros()));

    }

    public void mostrarCajerosOnAction(ActionEvent actionEvent) {
        cajerosTable.setVisible(true);
        verificarFacturasButton.setVisible(true);
    }

    public void verificarFacturasCajeroOnAction(ActionEvent actionEvent) {
        Cajero cajeroSeleccionado=cajerosTable.getSelectionModel().getSelectedItem();
        if(cajeroSeleccionado!=null)
        {
            this.listaRecibosCajerosTable.setItems(FXCollections.observableList(cajeroSeleccionado.getListaFacturas()));
            listaRecibosCajerosTable.setVisible(true);
        }
    }
}
