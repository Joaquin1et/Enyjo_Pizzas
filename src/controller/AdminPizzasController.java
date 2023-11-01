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
import model.Pizzas;

/**
 
 * @author joaquín
 */
public class AdminPizzasController implements Initializable {

    @FXML
    private Label lbl_Fecha;
    @FXML
    private Label lbl_Hora;
    @FXML
    private Label lbl_AdminPizzas;
    @FXML
    private TextField Id_productoPizza;
    @FXML
    private TextField txt_nombrePizza;
    @FXML
    private TextArea txt_descripcionPizza;
    @FXML
    private TextField txt_precioPizza;
    @FXML
    private Button btn_guardarPizza;
    @FXML
    private TableView<Pizzas> tblv_pizzas;
    @FXML
    private TableColumn<Pizzas, String> tblc_idPizzas;
    @FXML
    private TableColumn<Pizzas, String> tblc_nombrePizzas;
    @FXML
    private TableColumn<Pizzas, String> tblc_ingredientesPizzas;
    @FXML
    private TableColumn<Pizzas, String> tblc_precioPizzas;
    @FXML
    private TableColumn<Pizzas, String> tblc_fechaPizzas;
    @FXML
    private TableColumn<Pizzas, Blob> tblc_imagenPizzas;
    
    private ObservableList<Pizzas> listaPizzas;
    @FXML
    private ComboBox<String> cmb_claProducto;
    
    public static String producto;
    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaPizzas = FXCollections.observableArrayList(); 
         
         Pizzas.llenarInformacionPizzas(Conexion.conectar(), listaPizzas);
         
         tblc_idPizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, String>("Id"));
         tblc_nombrePizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, String>("Nombre"));
         tblc_ingredientesPizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, String>("Ingredientes"));
         tblc_precioPizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, String>("Precio"));
         tblc_fechaPizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, String>("Fecha"));
         tblc_imagenPizzas.setCellValueFactory(new PropertyValueFactory<Pizzas, Blob>("Imagen"));
         
         tblv_pizzas.setItems(listaPizzas);
         
         gestionarEventosPizzas();
         
         //INSERTAR FECHA Y HORA
        java.util.Date fecha = new java.util.Date();
        DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        lbl_Fecha.setText(formatofecha.format(fecha));

        DateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
        lbl_Hora.setText(formatohora.format(fecha));

        //txt_fecha.setText(formatofecha.format(fecha));
        //txt_fecha.setText(dia+" / "+(mes+1)+" / "+aa);
        
        //------ Inicio del COMBO BOX -----------------------
        
        ArrayList<String> listaClaProducto = new ArrayList<>();
        Collections.addAll(listaClaProducto, new String[]{"Pizzas", "Hamburguesas", "Entrantes y Postres", "Bebidas", "Extras" });
        
        cmb_claProducto.getItems().addAll(listaClaProducto);
        
        //------ FIN DEL COMBO BOX ---------------------------
        
    } 
    
    public void gestionarEventosPizzas() {
        tblv_pizzas.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Pizzas>() {
            @Override
            public void changed(ObservableValue<? extends Pizzas> observable, Pizzas valorAnterior, Pizzas valorSeleccionado) {

                producto = valorSeleccionado.getNombre();

                //System.out.println("Nombre del alumno seleccionado " + update_user);

            }

        });
    }

    @FXML
    private void GuardarPizzas(ActionEvent event) {
        
        int validacion = 0,claProducto;
        String  num_producto, nombre, ingredientes, precio, fecha, claProducto_String="";
        
        num_producto = Id_productoPizza.getText().trim();
        nombre = txt_nombrePizza.getText().trim();
        claProducto = cmb_claProducto.getSelectionModel().getSelectedIndex()+1;
        ingredientes = txt_descripcionPizza.getText().trim();
        precio = txt_precioPizza.getText().trim();
        fecha = lbl_Fecha.getText().trim();
        
        
       /* if (num_producto.equals("")) {
            Id_productoPizza.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }*/
        if (nombre.equals("")) {
            txt_nombrePizza.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (ingredientes.equals("")) {
            txt_descripcionPizza.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (precio.equals("")) {
            txt_precioPizza.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        
        // Combo Box de los Productos
        
         if (claProducto == 1) {
            claProducto_String = "Pizzas";
        } else if (claProducto == 2) {
            claProducto_String = "Hamburguesas";
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
                txt_nombrePizza.setStyle("-fx-background-color: #F64104 ;");

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
                        
                        Id_productoPizza.setStyle("-fx-background-color: #6DF80C ;");
                        txt_nombrePizza.setStyle("-fx-background-color: #6DF80C ;");
                        txt_descripcionPizza.setStyle("-fx-background-color: #6DF80C ;");
                        txt_precioPizza.setStyle("-fx-background-color: #6DF80C ;");

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

    @FXML
    private void FichaAdminPizzas(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha_AdminPizzas.fxml"));

            Parent root = loader.load();
            Ficha_AdminPizzasController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Información del producto - Sesión de "+user);
            stage.setResizable(false);
            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));

            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(AdminHamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Limpiar() {

        Id_productoPizza.setText("");
        txt_nombrePizza.setText("");
        txt_descripcionPizza.setText("");
        txt_precioPizza.setText("");

    }

    
    
}
