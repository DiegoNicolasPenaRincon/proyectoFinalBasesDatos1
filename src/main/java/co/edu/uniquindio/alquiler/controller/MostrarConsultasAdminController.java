package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.ConsultaDato;
import co.edu.uniquindio.alquiler.model.ContenedorConsultaPedido;
import co.edu.uniquindio.alquiler.model.ContenedorModificaciones;
import co.edu.uniquindio.alquiler.model.TiendaUQ;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MostrarConsultasAdminController {
    @FXML
    private TableView<ContenedorModificaciones> modificacionesTable;
    @FXML
    private TableColumn<ContenedorModificaciones,String> nombreAdminColumn;
    @FXML
    private TableColumn<ContenedorModificaciones,String> idAdminColumn;
    @FXML
    private TableColumn<ContenedorModificaciones,String> fechaModificacionColumn;
    @FXML
    private TableColumn<ContenedorModificaciones,String> codigoModificacionColumn;
    @FXML
    private TableView<ContenedorConsultaPedido> pedidosTable;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> codigoPedidoColumn;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> codigoAdministradorColumn;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> nombreAdministradorColumn;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> codigoProveedorColumn;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> nombreProveedorColumn;
    @FXML
    private TableColumn<ContenedorConsultaPedido,String> fechaPedidoColumn;
    @FXML
    private Label consultaLbl;
    @FXML
    private Button verificarProductosButton;

    ConsultaDato consultaDato=ConsultaDato.getInstance();
    TiendaUQ tiendaUQ=TiendaUQ.getInstance();


    public void initialize() {
        pedidosTable.setVisible(false);
        verificarProductosButton.setVisible(false);
        modificacionesTable.setVisible(false);
        if(consultaDato.getValor()==1)
        {
            consultaLbl.setText("Consulta pedidos");
            pedidosTable.setVisible(true);
            codigoPedidoColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoPedido())));
            codigoAdministradorColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoAdministrador())));
            nombreAdministradorColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getNombreAdministrador()) ) );
            codigoProveedorColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCodigoProveedor()) ) );
            nombreProveedorColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreProveedor())));
            fechaPedidoColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaPedido())));
            verificarProductosButton.setVisible(true);

            this.pedidosTable.setItems(FXCollections.observableList(tiendaUQ.importarConsultaPedido(consultaDato.getcodigoUniversal())));
        }
        else if(consultaDato.getValor()==2)
        {
            consultaLbl.setText("Consulta modificaciones");
            modificacionesTable.setVisible(true);
            nombreAdminColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreAdmin())));
            idAdminColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDocumentoEntidad())));
            fechaModificacionColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getFechaModificacion()) ) );
            codigoModificacionColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCodigoInstancia()) ) );

            this.modificacionesTable.setItems(FXCollections.observableList(tiendaUQ.importarModificaciones(consultaDato.getcodigoUniversal())));
        }
    }

    public void verificarProductosOnAction(ActionEvent actionEvent) {
    }
}
