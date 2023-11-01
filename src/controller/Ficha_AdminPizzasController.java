
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * @author joaquín
 */
public class Ficha_AdminPizzasController implements Initializable {
    
    @FXML
    private Label lbl_nombrePizza;
    @FXML
    private TextField txt_preciopizza;
    @FXML
    private TextField txt_fechaPizza;
    @FXML
    private TextArea txt_ingredientesPizza;
    @FXML
    private Button btn_modificarPizza;
    @FXML
    private Button btn_eliminarPizza;
    @FXML
    private ImageView Iv_imagePizza;
    
    String producto = "";
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        producto = AdminPizzasController.producto;
        
        
         //MOSTRAR LA INFORMACIÓN DEL PRODUCTO------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from hamburguesas where nombre = '" + producto + "'");
            ResultSet rs = pst.executeQuery();
            
            //CARGAR LA IMAGEN DE LA BASE DE DATOS---------------------------------------
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_HamburguesaController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                Iv_imagePizza.setImage(i); //Aqui colocamos la ImageView
                
            //FINALIZA EL CODIGO DE LA CARGA DE LA IMAGEN--------------------------------------    
                
                lbl_nombrePizza.setText(rs.getString("nombre"));
                txt_fechaPizza.setText(rs.getString("fecha"));
                txt_preciopizza.setText(rs.getString("precio"));
                txt_ingredientesPizza.setText(rs.getString("descripcion"));
                      
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
    }    

    @FXML
    private void ModificarPizza(ActionEvent event) {
        
        try {

            int validacion = 0;
            
            
            String fecha, precio, ingredientes;
            
            
            

            fecha = txt_fechaPizza.getText().trim();
            ingredientes = txt_ingredientesPizza.getText().trim();
            precio = txt_preciopizza.getText().trim();
            
            Connection cn = Conexion.conectar();
            
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setHeaderText(null);
            alert1.setTitle("Confirmación");
            alert1.setContentText("¿Quiere modificar la imagen?");
            Optional<ButtonType> action = alert1.showAndWait();

            if (action.get() != ButtonType.OK) {
                
                
                PreparedStatement pst2 = cn.prepareStatement(
                    
                    
                    
                    "update hamburguesas set fecha=?, descripcion=?, precio=? "
                    + "where nombre = '" + producto + "'");

            pst2.setString(1, fecha);
            pst2.setString(2, ingredientes);
            pst2.setString(3, precio);
           
           
            pst2.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Modificación correcta.");
            alert.showAndWait();
              
                cn.close();

            } else {

                JFileChooser escoger = new JFileChooser();
                escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int estado = escoger.showOpenDialog(null);
                
                File archivo = escoger.getSelectedFile();
                            
                long longitud = archivo.length();
                            
                
                    FileInputStream flujo;
                try {
                    flujo = new FileInputStream(archivo);
                
            PreparedStatement pst2 = cn.prepareStatement(
                   
                    "update hamburguesas set fecha=?, descripcion=?, precio=?, images=? "
                    + "where nombre = '" + producto + "'");

            pst2.setString(1, fecha);
            pst2.setString(2, ingredientes);
            pst2.setString(3, precio);
            pst2.setBlob(4, flujo, longitud);
           
            pst2.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Modificación correcta.");
            alert.showAndWait();

            //JOptionPane.showMessageDialog(null, "Modificación correcta. ");
            cn.close();
            
            } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ficha_HamburguesaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar." + e);
        }
        
    }

    @FXML
    private void EliminarPizza(ActionEvent event) {
        
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
                    "delete from hamburguesas where descripcion = ?");

                pst.setString(1, txt_ingredientesPizza.getText().trim());
            pst.executeUpdate();

            txt_fechaPizza.setText("");
            txt_ingredientesPizza.setText("");
            txt_preciopizza.setText("");
            
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setTitle("Informacion");
            alert1.setContentText("El producto ha sido borrado correctamente.");
            alert1.showAndWait();
          
            //JOptionPane.showMessageDialog(null, "El empleado ha sido borrado correctamente ");

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "El empeado no ha sido eliminado.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("El empeado no ha sido eliminado.");
            alert.showAndWait();
        }
        
    }
    
}
