package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.ContrasenaException;
import co.edu.uniquindio.alquiler.exceptions.NoRegistradoException;
import co.edu.uniquindio.alquiler.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class InicioSesionController {

    @FXML
    private TextField documentoEntidadTRextfield;
    @FXML
    private Label documentoLabel;
    @FXML
    private Label inicioSesionLabel;
    @FXML
    private Button IngresarButton;
    @FXML
    private PasswordField contrasenaPasswordField;
    @FXML
    private Label contrasenaLabel;

    TiendaUQ tiendaUQ=TiendaUQ.getInstance();
    DatosSesion<Administrador> datosAdmin= DatosSesion.getInstance();
    DatosSesion<Cajero> datosCajero=DatosSesion.getInstance();

    public void initialize() {

    }

    public void ingresarOnAction(ActionEvent actionEvent) {
        String documentoEntidad = documentoEntidadTRextfield.getText();
        String contrasena = contrasenaPasswordField.getText();
        if(!documentoEntidad.isEmpty()&&!contrasena.isEmpty())
        {
            try
            {
                int abrir=0;
                Cajero esCajero=tiendaUQ.verficiarCajero(Integer.parseInt(documentoEntidad),contrasena);
                Administrador esAdmin=tiendaUQ.verficiarAdministrador(Integer.parseInt(documentoEntidad),contrasena);
                if(esCajero!=null)
                {
                    abrir=2;
                    datosCajero.setUsuarioActivo(esCajero);
                    datosAdmin.setUsuarioActivo(null);
                    tiendaUQ.inicializarEmpleadoInterfaz(abrir);
                }
                else if(esAdmin!=null)
                {
                    abrir=1;
                    datosAdmin.setUsuarioActivo(esAdmin);
                    datosCajero.setUsuarioActivo(null);
                    tiendaUQ.inicializarEmpleadoInterfaz(abrir);
                }
                else
                {
                    throw new NoRegistradoException("El usuario no se encuentra registrado");
                }
            }
            catch (ContrasenaException | NoRegistradoException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Alerta");
                alert.setContentText(e.getMessage());
                alert.show();
            }
            catch (IOException | SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        else if(contrasena.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("El campo de contrasena debe estar lleno");
            alert.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Alerta");
            alert.setContentText("Debe ingresar su documento de identidad");
            alert.show();
        }
    }


}
