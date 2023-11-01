
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * @author Joaquín
 */
public class BebidasController implements Initializable {

    @FXML
    private ImageView Iv_cataImagen;
    @FXML
    private Label lbl_cartaIngredientes;
    @FXML
    private Label lbl_cartaPrecio;
    @FXML
    private Label lbl_cartaNombre;
    
    String nombreBebida = ""; 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nombreBebida = Carta_BebidasController.nombreBebida;
        
        //MOSTRAR LA INFORMACIÓN DEL PRODUCTO HAMBURGUESAS------------
        
        try {
            
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from hamburguesas where nombre = '" + nombreBebida + "'");
            ResultSet rs = pst.executeQuery();
            
            //CARGAR LA IMAGEN DE LA BASE DE DATOS---------------------------------------
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                 Iv_cataImagen.setImage(i); //Aqui colocamos la ImageView
                
            //FINALIZA EL CODIGO DE LA CARGA DE LA IMAGEN--------------------------------------    
                
                lbl_cartaNombre.setText(rs.getString("nombre"));
                //txt_fechaBebida.setText(rs.getString("fecha"));
                lbl_cartaPrecio.setText(rs.getString("precio"));
                lbl_cartaIngredientes.setText(rs.getString("descripcion"));
                      
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
    }    
    
}
