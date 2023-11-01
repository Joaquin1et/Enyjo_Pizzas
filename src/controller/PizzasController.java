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
public class PizzasController implements Initializable {

    @FXML
    private Label lbl_CartaNombre;
    @FXML
    private ImageView Iv_cartaImagen;
    @FXML
    private Label lbl_cartaPrecio;
    @FXML
    private Label lbl_CartaIngredientes;
    
    String nombrePizza = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nombrePizza = Carta_PizzasController.nombrePizza;
        
         //MOSTRAR LA INFORMACIÓN DEL PRODUCTO PiIZZAS------------
        
        try {
            
            Connection cn1 = Conexion.conectar();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "select * from hamburguesas where nombre = '" + nombrePizza + "'");
            ResultSet rs1 = pst1.executeQuery();
            
            //CARGAR LA IMAGEN DE LA BASE DE DATOS---------------------------------------
            
            if (rs1.next()) {
                
                Image i = null;
                Blob blob = rs1.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                 Iv_cartaImagen.setImage(i); //Aqui colocamos la ImageView
                
            //FINALIZA EL CODIGO DE LA CARGA DE LA IMAGEN--------------------------------------    
                
                lbl_CartaNombre.setText(rs1.getString("nombre"));
                //txt_fechaBebida.setText(rs.getString("fecha"));
                lbl_cartaPrecio.setText(rs1.getString("precio"));
                lbl_CartaIngredientes.setText(rs1.getString("descripcion"));
                      
            }

            cn1.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
    }    
    
}
