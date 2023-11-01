/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import controller.LoginAdministradorController;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class Registro_UsuariosController implements Initializable {

    @FXML
    private TextField txt_nombreUsuario;
    @FXML
    private TextField txt_password;
    @FXML
    private Button btn_registro_Usuario;
    
    public static String usuario = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Registro_Usuario(ActionEvent event) {
        
        usuario = LoginAdministradorController.user;
        
        int validacion = 0 ;
        String nombreUsuario, pass;
        
        nombreUsuario = txt_nombreUsuario.getText().trim();
        pass = txt_password.getText().trim();
        
        if (nombreUsuario.equals("")) {
            txt_nombreUsuario.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (pass.equals("")) {
            txt_password.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre from administradores where nombre = '" + nombreUsuario + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_nombreUsuario.setStyle("-fx-background-color: #F64104 ;");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Nombre de usuario no disponible.");
                alert.showAndWait();
                //JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible. ");
                cn.close();
            } else {

                cn.close();

                if (validacion == 0) {
                    try {

                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "insert into administradores values (?,?,?)");
                        //pst2.setInt(1, 0);
                        pst2.setString(1, nombreUsuario);
                        pst2.setString(2, pass);
                        pst2.setString(3, usuario);
                        

                        pst2.executeUpdate();
                        cn2.close();

                        Limpiar();

                        txt_nombreUsuario.setStyle("-fx-background-color: #6DF80C ;");
                        txt_password.setStyle("-fx-background-color: #6DF80C ;");
                        

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Informacion");
                        alert.setContentText("Usuario registrado correctamente.");
                        alert.showAndWait();

                        //JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
                        dispose();

                    } catch (SQLException e) {
                       
                        System.err.println("Error al registrar usuario. ");
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!! Contacte con el administrador.");
                    }
                } else {
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Informacion");
                    alert.setContentText("Debes de rellenar todos los campos.");
                    alert.showAndWait();
                    //JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos.");
                }

            }

        } catch (Exception e) {
            System.err.println("Error al validar el nombre de usuario.");
            JOptionPane.showMessageDialog(null, "¡¡Error al comparar usuario!! Contacte con el administrador.");

        }
        
    }
    
    public void Limpiar() {
        
        txt_nombreUsuario.setText("");
        txt_password.setText("");
    }
    
}
