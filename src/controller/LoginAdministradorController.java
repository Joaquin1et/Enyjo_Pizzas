
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Conexion;
import model.Sonidos;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class LoginAdministradorController implements Initializable {

    @FXML
    private Button btn_LoginAdmin;
    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_password;

    public static String user = "";
    private String pass = "";
    
    Sonidos sonidoError = new Sonidos();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }

    @FXML
    private void btn_LoginAdministrador(ActionEvent event) {
        
        
        user = txt_usuario.getText().trim();
        pass = txt_password.getText().trim();

        if (!user.equals("") || !pass.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select nombre, password from administradores where nombre = '" + user + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Administrador.fxml"));

                        Parent root = loader.load();
                        AdministradorController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }

                } else {
                    
                    sonidoError.SonidoError();

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Datos de acceso incorrectos.");
                    alert.showAndWait();
                   
                }

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Error en la base de datos.");
                alert.showAndWait();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos de acceso incorrectos.");
            alert.showAndWait();

        }

    }

}
