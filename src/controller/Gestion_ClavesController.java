package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * @author Joaquín
 */
public class Gestion_ClavesController implements Initializable {

    @FXML
    private Button btn_registroUsuarios;
    @FXML
    private Button btn_gestion_Usuarios;
    @FXML
    private Pane contenArea_2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Registro_Usuarios.fxml"));
            contenArea_2.getChildren().removeAll();
            contenArea_2.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Vaya mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    @FXML
    private void Registro_Usuarios(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Registro_Usuarios.fxml"));
            contenArea_2.getChildren().removeAll();
            contenArea_2.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Vaya mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void Gestion_Usuarios(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Gestion_Usuarios.fxml"));
            contenArea_2.getChildren().removeAll();
            contenArea_2.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Vaya mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
