package controller;

import static controller.LoginAdministradorController.user;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * @author Joaquín
 */
public class FichaClavesUsuariosController implements Initializable {

    @FXML
    private TextField txt_nombreClaveUsu;
    @FXML
    private TextField txt_registradoPor;
    @FXML
    private Button btn_restaurarPasswordClave;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Button EliminarClaveUsu;
    
    private String nombreUsuario = ""; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nombreUsuario = view.Gestion_UsuariosController.nombreClave;
        
        
        //MOSTRAR LA INFORMACIÓN DEL USUARIO------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from Administradores where nombre = '" + nombreUsuario + "'");
            ResultSet rs = pst.executeQuery();
            
            //CARGAR LA IMAGEN DE LA BASE DE DATOS---------------------------------------
            
            if (rs.next()) {
                
                /*Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }*/
                
            //FINALIZA EL CODIGO DE LA CARGA DE LA IMAGEN--------------------------------------    
                
                txt_nombreClaveUsu.setText(rs.getString("nombre"));
                txt_password.setText(rs.getString("password"));
                txt_registradoPor.setText(rs.getString("registrado_por"));
                     
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar Usuario." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        
    }    

    @FXML
    private void Restaurar_Password_Usuario(ActionEvent event) {
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Cambio_de_Password_Admin.fxml"));

                        Parent root = loader.load();
                        Cambio_de_Password_AdminController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();
                        
                        stage =(Stage)this.txt_nombreClaveUsu.getScene().getWindow();
                            stage.close();

                        
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del cambio de password.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }

    @FXML
    private void Eliminar_Clave_Usuario(ActionEvent event) {
        
        try {

            Connection cn = Conexion.conectar();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Seguro que quiere eliminarlo?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() != ButtonType.OK) {

                cn.close();

            } else {

            }

            PreparedStatement pst = cn.prepareStatement(
                    "delete from administradores where nombre = ?");

            pst.setString(1, txt_nombreClaveUsu.getText().trim());
            pst.executeUpdate();

            txt_nombreClaveUsu.setText("");
            txt_password.setText("");
            
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setTitle("Informacion");
            alert1.setContentText("El Usuario ha sido borrado correctamente.");
            alert1.showAndWait();
          
            //JOptionPane.showMessageDialog(null, "El empleado ha sido borrado correctamente ");

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "El empeado no ha sido eliminado.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("El Usuario no ha sido eliminado.");
            alert.showAndWait();
        }
        
    }
    
}
