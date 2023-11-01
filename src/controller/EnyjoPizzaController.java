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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Sonidos;
import sun.plugin2.ipc.windows.WindowsEvent;

/**
 *
 * @author Joaquín Martín de ENYJO SYSTEM
 */
public class EnyjoPizzaController implements Initializable {

    public static  Pane contenArea;
    @FXML
    private Button carta;
    @FXML
    private Button Home;
    @FXML
    private Button btn_Administrador;
    @FXML
    private Button btn_hacerPedidoPrincipal;
    @FXML
    private Pane contenArea_Prin;
    
    Sonidos sonidoInicio = new Sonidos();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        sonidoInicio.InicioPrograma();
        // TODO
        /*try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/EnyjoPizza.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EnyjoPizzaController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }    

    @FXML
    private void carta(ActionEvent event) {
        
         try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Pizzas.fxml"));
            contenArea_Prin.getChildren().removeAll();
            contenArea_Prin.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Home(ActionEvent event) {
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EnyjoPizza.fxml"));
                           
                            Parent root = loader.load();
                            EnyjoPizzaController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                           
                            stage.setScene(scene);
                            /*stage.initModality(Modality.APPLICATION_MODAL);*/
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            stage =(Stage)this.contenArea.getScene().getWindow();
                            stage.close();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(EnyjoPizzaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void btn_Administrador(ActionEvent event) {
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginAdministrador.fxml"));
                           
                            Parent root = loader.load();
                            LoginAdministradorController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                           
                            stage.setScene(scene);
                            /*stage.initModality(Modality.APPLICATION_MODAL);*/
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            //stage =(Stage)this.contenArea.getScene().getWindow();
                            //stage.close();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(EnyjoPizzaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void Hacer_Pedido_Principal(ActionEvent event) {
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Clave_HacerPedido.fxml"));
                           
                            Parent root = loader.load();
                            Clave_HacerPedidoController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            
                            stage.setTitle("ENYJO PIZZAS ");
                            stage.setScene(scene);
                            stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                            /*PARA VOLVER A LA PANTALLA PRINCIPAL CREAR EL  METODO closeWindow en la carpeta
                              PedidoPizzasController                            
                            */
                            
                            //stage.setOnCloseRequest(e -> controlador.closeWindows());
                            
                            //Stage myStage = (Stage) this.btn_hacerPedidoPrincipal.getScene().getWindow();
                            //myStage.close();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(EnyjoPizzaController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
    
}
