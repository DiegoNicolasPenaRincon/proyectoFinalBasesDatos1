package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.sql.Connection;
import java.util.Map;

public class MostrarConsultasAdminController {

    @FXML
    private Spinner<Integer> mesSpinner;
    @FXML
    private Button fechaReporteButton;
    @FXML
    private Button reporteCalcularValorButton;
    @FXML
    private TableView<ContenedorGeneral> generalTable;
    @FXML
    private TableColumn<ContenedorGeneral,String> nombreGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> codigoGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> proveedorGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> cProveedorGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> categoriaGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> ivaGeneralColumn;
    @FXML
    private TableColumn<ContenedorGeneral,String> utilidadGeneralColumn;
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
        generalTable.setVisible(false);
        reporteCalcularValorButton.setVisible(false);
        fechaReporteButton.setVisible(false);
        mesSpinner.setVisible(false);

        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12,1);
        mesSpinner.setValueFactory(valueFactory);


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
            mesSpinner.setVisible(true);
            fechaReporteButton.setVisible(true);

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
        else if(consultaDato.getValor()==3)
        {
            consultaLbl.setText("Consulta generalidades");
            generalTable.setVisible(true);
            reporteCalcularValorButton.setVisible(true);


            nombreGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreProducto())));
            codigoGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoProducto())));
            proveedorGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getNombreProveedor()) ) );
            cProveedorGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getCodigoProveedor()) ) );
            categoriaGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getNombreCategoria()) ) );
            ivaGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getIva()) ) );
            utilidadGeneralColumn.setCellValueFactory( cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getUtilidad()) ) );

            this.generalTable.setItems(FXCollections.observableList(tiendaUQ.importarDatosGenerales()));
        }
    }

    public void verificarProductosOnAction(ActionEvent actionEvent) {

    }

    public void calcularValorReporteOnAction(ActionEvent actionEvent) {
        try
        {
            tiendaUQ.generarReporte(1);
        }
        catch (JRException e)
        {
            e.printStackTrace();
        }
    }

    public void generarReportesFechaOnAztion(ActionEvent actionEvent) {
        try
        {
            tiendaUQ.generarReporte(2);
        }
        catch (JRException e)
        {
            e.printStackTrace();
        }
    }
}
