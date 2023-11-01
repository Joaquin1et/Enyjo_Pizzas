package controller;

import static controller.LoginAdministradorController.user;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import model.Conexion;
import model.Entrantes;

/**
 * @author Joaquín
 */
public class AdminEntrantesController implements Initializable {

    @FXML
    private Label lbl_Fecha;
    @FXML
    private Label lbl_Hora;
    @FXML
    private Button btn_guardarEntrantes;
    @FXML
    private TextField txt_idProductoEntrante;
    @FXML
    private ComboBox<String> cmb_claProductoEntrante;
    @FXML
    private TextField txt_nombreEntrante;
    @FXML
    private TextArea txt_descripcionEntrante;
    @FXML
    private TextField txt_precioEntrante;
    @FXML
    private TableView<Entrantes> tblv_entrante;
    @FXML
    private TableColumn<Entrantes, String> tblc_idEntrante;
    @FXML
    private TableColumn<Entrantes, String> tblc_nombreEntrante;
    @FXML
    private TableColumn<Entrantes, String> tblc_ingredientesEntrante;
    @FXML
    private TableColumn<Entrantes, String> tblc_precioEntrante;
    @FXML
    private TableColumn<Entrantes, String> tblc_fechaEntrante;
    @FXML
    private TableColumn<Entrantes, Blob> tblc_ImagenEntrante;
    
    private ObservableList<Entrantes> listaEntrantes;
    
     public static String producto;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         listaEntrantes = FXCollections.observableArrayList(); 
         
         Entrantes.llenarInformacionEntrantes(Conexion.conectar(), listaEntrantes);
         
         tblc_idEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, String>("Id"));
         tblc_nombreEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, String>("Nombre"));
         tblc_ingredientesEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, String>("Ingredientes"));
         tblc_precioEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, String>("Precio"));
         tblc_fechaEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, String>("Fecha"));
         tblc_ImagenEntrante.setCellValueFactory(new PropertyValueFactory<Entrantes, Blob>("Imagen"));
         
         
        
         
        tblv_entrante.setItems(listaEntrantes);
        
        gestionarEventosEntrante();
        
        //INSERTAR FECHA Y HORA
        java.util.Date fecha = new java.util.Date();
        DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        lbl_Fecha.setText(formatofecha.format(fecha));

        DateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
        lbl_Hora.setText(formatohora.format(fecha));

        //txt_fecha.setText(formatofecha.format(fecha));
        //txt_fecha.setText(dia+" / "+(mes+1)+" / "+aa); 
        
        //Inicio del COMBO BOX ------------------------
        
        ArrayList<String> listaClaProducto = new ArrayList<>();
        Collections.addAll(listaClaProducto, new String[]{"Pizzas", "Hamburguesas", "Entrantes y Postres", "Bebidas", "Extras" });
        
        cmb_claProductoEntrante.getItems().addAll(listaClaProducto);
        
        //------ Fin del Combo Box ----------------------
        
    } 
    
    public void gestionarEventosEntrante() {
        tblv_entrante.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Entrantes>() {
            @Override
            public void changed(ObservableValue<? extends Entrantes> observable, Entrantes valorAnterior, Entrantes valorSeleccionado) {

                producto = valorSeleccionado.getNombre();

                //System.out.println("Nombre del alumno seleccionado " + update_user);

            }

        });
    }

    @FXML
    private void GuardarEntrantes(ActionEvent event) {
        
        int validacion = 0,claProducto;
        String  num_producto, nombre, ingredientes, precio, fecha, claProducto_String="";
        
        num_producto = txt_idProductoEntrante.getText().trim();
        nombre = txt_nombreEntrante.getText().trim();
        claProducto = cmb_claProductoEntrante.getSelectionModel().getSelectedIndex()+1;
        ingredientes = txt_descripcionEntrante.getText().trim();
        precio = txt_precioEntrante.getText().trim();
        fecha = lbl_Fecha.getText().trim();
        
        
       /* if (num_producto.equals("")) {
            Id_productoPizza.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }*/
        if (nombre.equals("")) {
            txt_nombreEntrante.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (ingredientes.equals("")) {
            txt_descripcionEntrante.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (precio.equals("")) {
            txt_precioEntrante.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        
        // Combo Box de los Productos
        
         if (claProducto == 1) {
            claProducto_String = "Hamburguesas";
        } else if (claProducto == 2) {
            claProducto_String = "Pizzas";
        } else if (claProducto == 3) {
            claProducto_String = "Entrantes y Postres";
        } else if (claProducto == 4) {
            claProducto_String = "Bebidas";
        } else if (claProducto == 5) {
            claProducto_String = "Extras";
        }
        //---FIN del Combo Box de los Productos
        
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre from hamburguesas where nombre = '" + nombre + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_nombreEntrante.setStyle("-fx-background-color: #F64104 ;");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Informacion");
                alert.setContentText("Producto ya registrado.");
                alert.showAndWait();

                cn.close();
            } else {

                cn.close();
                
        // ----- GUARDAR LA IMAGEN EN LA BASE DE DATOS ---------------------------------        

                if (validacion == 0) {
                    
                    try {
                        
                        JFileChooser escoger = new JFileChooser();
                        escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        int estado = escoger.showOpenDialog(null);
                        
                        if(estado == JFileChooser.APPROVE_OPTION){
                            File archivo = escoger.getSelectedFile();
                            
                            long longitud = archivo.length();
                            
                            try{
                                
                                FileInputStream flujo = new FileInputStream(archivo);

                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "insert into hamburguesas (id,nombre,descripcion,precio,fecha,images,claseproducto) values (?,?,?,?,?,?,?)");
                        
                        pst2.setString(1, num_producto);
                        pst2.setString(2, nombre);
                        pst2.setString(3, ingredientes);
                        pst2.setString(4, precio);
                        pst2.setString(5, fecha);
                        pst2.setBlob(6, flujo, longitud);
                        pst2.setString(7, claProducto_String);

                        
                        pst2.executeUpdate();
                        cn2.close();
                        
        //--------- FINALIZA EL CODIGO DE GUARDAR DATOS CON IMAGENES EN BASE DE DATOS -----------------------
                                
                            }catch(FileNotFoundException e){
                                
                            }
                        }
                        
                        try{
                       
                        //Limpiar();
                        
                        txt_idProductoEntrante.setStyle("-fx-background-color: #6DF80C ;");
                        txt_nombreEntrante.setStyle("-fx-background-color: #6DF80C ;");
                        txt_descripcionEntrante.setStyle("-fx-background-color: #6DF80C ;");
                        txt_precioEntrante.setStyle("-fx-background-color: #6DF80C ;");

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Informacion");
                        alert.setContentText("Guardado correctamente.");
                        alert.showAndWait();
                        
                        
                        
                        }catch(Exception ex){
                            System.out.println("Error al guardar la foto.");
                        }


                    } catch (SQLException e) {
                        System.err.println("Error al guardar producto. " + e);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Informacion");
                        alert.setContentText("¡¡ERROR al guardar!! El Id está repetido.\n Elija otro Id.");
                        alert.showAndWait();

                    }

                } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Informacion");
                    alert.setContentText("Debes de rellenar todos los campos.");
                    alert.showAndWait();

                }

            }

        } catch (SQLException e) {
            System.err.println("Error al validar el nombre de empleado" + e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("¡¡Error al validar el pedido!! Contacte con el administrador.");
            alert.showAndWait();
        }
        
        Limpiar();
        
    }
    
    public void Limpiar() {

        txt_idProductoEntrante.setText("");
        txt_nombreEntrante.setText("");
        txt_descripcionEntrante.setText("");
        txt_precioEntrante.setText("");

    }

    @FXML
    private void FichaAdminEntrantes(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FichaAdminEntrantes.fxml"));

            Parent root = loader.load();
            FichaAdminEntrantesController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Información del producto - Sesión de "+user);
            stage.setResizable(false);
            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(AdminEntrantesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
