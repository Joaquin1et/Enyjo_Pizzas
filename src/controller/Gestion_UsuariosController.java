package view;

import controller.AdministradorController;
import controller.Carta_PizzasController;
import controller.FichaClavesUsuariosController;
import static controller.LoginAdministradorController.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Conexion;
import model.GestionClaves;

/**
 * @author Joaquín
 */
public class Gestion_UsuariosController implements Initializable {

    @FXML
    private TableView<GestionClaves> tblv_Ges_Claves;
    @FXML
    private TableColumn<GestionClaves, String> tblc_nombre;
    @FXML
    private TableColumn<GestionClaves, String> tblc_password;
    
    private ObservableList<GestionClaves> listaGestiClaves;
    
    public static String nombreClave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaGestiClaves = FXCollections.observableArrayList(); 
         
         GestionClaves.llenarInformacionGesClaves(Conexion.conectar(), listaGestiClaves);
         
         tblc_nombre.setCellValueFactory(new PropertyValueFactory<GestionClaves, String>("Nombre"));
         tblc_password.setCellValueFactory(new PropertyValueFactory<GestionClaves, String>("Password"));
        
        tblv_Ges_Claves.setItems(listaGestiClaves);
        
        gestionarEventosClaveUsuarios();
        
    }    

    @FXML
    private void Ficha_Claves_Usuario(MouseEvent event) {
        
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FichaClavesUsuarios.fxml"));

                        Parent root = loader.load();
                        FichaClavesUsuariosController controlador = loader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Administrador - Sesión de " + user);
                        stage.setResizable(false);
                        stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

                        stage.show();

                        
                    } catch (IOException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("No se ha podido cargar la ventana de la Gestión de los Usuarios.\n Contacte con el informático.");
                        alert.showAndWait();
                    }
        
    }
    
    public void gestionarEventosClaveUsuarios() {
        tblv_Ges_Claves.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<GestionClaves>() {
            @Override
            public void changed(ObservableValue<? extends GestionClaves> observable, GestionClaves valorAnterior, GestionClaves valorSeleccionado) {

                nombreClave = valorSeleccionado.getNombre();

                //System.out.println("Nombre del alumno seleccionado " + update_user);

            }

        });
    }
    
}
