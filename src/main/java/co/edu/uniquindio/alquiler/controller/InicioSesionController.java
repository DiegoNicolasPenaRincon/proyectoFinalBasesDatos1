package co.edu.uniquindio.alquiler.controller;

import co.edu.uniquindio.alquiler.exceptions.ContrasenaException;
import co.edu.uniquindio.alquiler.exceptions.NoRegistradoException;
import co.edu.uniquindio.alquiler.model.Administrador;
import co.edu.uniquindio.alquiler.model.Cajero;
import co.edu.uniquindio.alquiler.model.Persona;
import co.edu.uniquindio.alquiler.model.TiendaUQ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void initialize() {

    }

    public void ingresarOnAction(ActionEvent actionEvent) {
        String documentoEntidad = documentoEntidadTRextfield.getText();
        String contrasena = contrasenaPasswordField.getText();
        if(!documentoEntidad.isEmpty()&&!contrasena.isEmpty())
        {
            try
            {
                Persona isUsuarioRegistrado=tiendaUQ.verficiarUsuario(Integer.parseInt(documentoEntidad),contrasena);
                if(isUsuarioRegistrado!=null)
                {
                    int abrir=0;
                    if(isUsuarioRegistrado instanceof Administrador)
                    {
                        abrir=1;
                    }
                    else if(isUsuarioRegistrado instanceof Cajero)
                    {
                        abrir=2;
                    }
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
            catch (IOException e)
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
