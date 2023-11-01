package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * @author Joaquín
 */
public class Cambio_de_Password_AdminController implements Initializable {

    @FXML
    private PasswordField txt_cambioPassword;
    @FXML
    private PasswordField txt_confirmarPassword;
    @FXML
    private Button btn_restaurarPassword;
    
    String cambioClave = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Restaurar_Password(ActionEvent event) {
        
        cambioClave = view.Gestion_UsuariosController.nombreClave;
        
        String password, confirmacion_password;

        password = txt_cambioPassword.getText().trim();
        confirmacion_password = txt_confirmarPassword.getText().trim();

        if (!password.equals("") && !confirmacion_password.equals("")) {

            if (password.equals(confirmacion_password)) {

                try {

                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update administradores set password=? where nombre= '" + cambioClave + "'");

                    pst.setString(1, password);
                    pst.executeUpdate();
                    cn.close();

                    txt_cambioPassword.setStyle("-fx-background-color: #6DF80C ;");
                    txt_confirmarPassword.setStyle("-fx-background-color: #6DF80C ;");

                    //JOptionPane.showMessageDialog(null, "Restauracion correcta. ");
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setHeaderText(null);
                    alert1.setTitle("Información");
                    alert1.setContentText("Restauración correcta.");
                    alert1.showAndWait();
                          
                    //this.dispose();
                    
                    Limpiar();

                } catch (SQLException e) {
                    System.out.println("Error al restaurar el password " + e);
                }

            } else {
                txt_confirmarPassword.setStyle("-fx-background-color: #F98854 ;");
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden. ");
            }

        } else {
            txt_cambioPassword.setStyle("-fx-background-color: #F98854 ;");
            txt_confirmarPassword.setStyle("-fx-background-color: #F98854 ;");
            JOptionPane.showMessageDialog(null, "No se admiten contraseñas vacias. ");
        }
        
    }
    
    
    public void Limpiar() {

        txt_cambioPassword.setText("");
        txt_confirmarPassword.setText("");
        
    }
    
    
}
