package controller;

import static controller.LoginAdministradorController.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AdministradorController implements Initializable {

    @FXML
    private Pane contenArea;
    @FXML
    private Label lbl_adminHamburguesas;
    @FXML
    private Label lbl_adminPizzas;
    @FXML
    private Label lbl_adminEntrantes;
    @FXML
    private Label lbl_AdminBebidas;
    @FXML
    private Pane btn_gestionClaves;
    
     //public static String user = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AdminHamburguesas(MouseEvent event) {
        
       user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminHamburguesas.fxml"));

                        Parent root = loader.load();
                        AdminHamburguesasController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }

    @FXML
    private void AdminPizzas(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminPizzas.fxml"));

                        Parent root = loader.load();
                        AdminPizzasController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
        
    }

    @FXML
    private void AdminEntrantes(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminEntrantes.fxml"));

                        Parent root = loader.load();
                        AdminEntrantesController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }

    @FXML
    private void AdminBebidas(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminBebidas.fxml"));

                        Parent root = loader.load();
                        AdminBebidasController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }

    @FXML
    private void AdminHaburguesas(MouseEvent event) {
        
       user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminHamburguesas.fxml"));

                        Parent root = loader.load();
                        AdminHamburguesasController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    } 
        
    }

    @FXML
    private void Gestion_Claves(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Gestion_Claves.fxml"));

                        Parent root = loader.load();
                        Gestion_ClavesController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        //stage = (Stage) this.btn_LoginAdmin.getScene().getWindow();
                        //stage.close();
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana del Administrador.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }
    
}
