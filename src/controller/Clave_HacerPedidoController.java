package controller;

import static controller.EnyjoPizzaController.contenArea;
import static controller.LoginAdministradorController.user;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import model.Conexion;

/**
 * @author Joaquín
 */
public class Clave_HacerPedidoController implements Initializable {

    @FXML
    private PasswordField txt_claveNumEmpleado;
    @FXML
    private Button btn_hacerPedido;
    
    public static String numEmpleado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
    }    

    @FXML
    private void Hacer_Pedido(ActionEvent event) {
        
        
        numEmpleado = txt_claveNumEmpleado.getText().trim();
        
        if(!numEmpleado.equals("")){
            
            try{
                
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select numeroempleado from empleados where numeroempleado = '"+numEmpleado+"'");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    
                    
                    try {
                        /*Parent fxml = FXMLLoader.load(getClass().getResource("/view/PedidoPizzas.fxml"));
                        contenArea.getChildren().removeAll();
                        contenArea.getChildren().setAll(fxml);*/
                        
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PedidoPizzas.fxml"));
                           
                            Parent root = loader.load();
                            PedidoPizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle(" Empleado número " + numEmpleado);
                           
                            stage.setScene(scene);
                            /*stage.initModality(Modality.APPLICATION_MODAL);*/
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            stage =(Stage)this.txt_claveNumEmpleado.getScene().getWindow();
                            stage.close();
                            
                            
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Clave_HacerPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }else{
                    
                    Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos de acceso incorrectos.");
            alert.showAndWait();
                    
                }
                
            }catch(SQLException ex){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Error en la base de datos.");
                alert.showAndWait();
                
            }
            
        }else{
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos de acceso no encontrados.");
            alert.showAndWait();
        }
        
        
    }
    
}
