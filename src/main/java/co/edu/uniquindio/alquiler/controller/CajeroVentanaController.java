package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.Cliente;
import co.edu.uniquindio.alquiler.model.Factura;
import co.edu.uniquindio.alquiler.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CajeroVentanaController {
    @FXML
    private TableColumn<Cliente,String> nombreClienteColumn;
    @FXML
    private TableColumn<Cliente,String> telefonoClienteColumn;
    @FXML
    private TableColumn<Cliente,String> totalAdquiridosColumn;
    @FXML
    private TableView<Producto> productosAdquiridosTable;
    @FXML
    private TableColumn<Producto,String> nombreProductoColumn;
    @FXML
    private TableColumn<Producto,String> codigoProductoColumn;
    @FXML
    private TableColumn<Producto,String> categoriaProductoColumn;
    @FXML
    private TableColumn<Producto,String> nombreProveedorColumn;
    @FXML
    private TableColumn<Producto,String> codigoProveedorColumn;
    @FXML
    private TableColumn<Producto,String> direccionProveedorColumn;
    @FXML
    private Label opcionesCajeroLbl;
    @FXML
    private Button verificarProductosButton;
    @FXML
    private Button verificarClienteButton;
    @FXML
    private TableView<Factura> cajeroTable;
    @FXML
    private TableColumn<Factura,String> fechaPagoolumn;
    @FXML
    private TableColumn<Factura,String> codigoFacturaColumn;
    @FXML
    private TableColumn<Factura,String> totalColumn;
    @FXML
    private TableColumn<Factura,String> idClienteColumn;

    public void verificarProductosOnAction(ActionEvent actionEvent) {
        Factura factura=cajeroTable.getSelectionModel().getSelectedItem();

    }

}
