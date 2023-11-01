
package controller;

import static controller.LoginAdministradorController.user;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import model.Conexion;
import model.Hamburguesas;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class AdminHamburguesasController implements Initializable {
    
    
    public static String update_user = "";

    @FXML
    private Label lbl_Fecha;
    @FXML
    private Label lbl_Hora;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextArea txt_Descripcion;
    @FXML
    private TextField txt_Precio;
    @FXML
    private TextField id_producto;
    @FXML
    private TableView<Hamburguesas> tblv_hamburguesas;
    @FXML
    private TableColumn<Hamburguesas, String> tblc_id;
    @FXML
    private TableColumn<Hamburguesas, String> tblc_nombreHamburg;
    @FXML
    private TableColumn<Hamburguesas, String> tblc_descripcionHanbur;
    @FXML
    private TableColumn<Hamburguesas, String> tblc_precioHanbur;
    @FXML
    private TableColumn<Hamburguesas, String> tblc_fechaHambur;
    @FXML
    private TableColumn<Hamburguesas, Blob> tblc_imagenHambur;

    private ObservableList<Hamburguesas> listaHamburguesas;
    @FXML
    private Button btn_guardarHambur;
    @FXML
    private ComboBox<String> cmb_claProducto;
    
    public static String producto;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listaHamburguesas = FXCollections.observableArrayList(); 
         
         Hamburguesas.llenarInformacionEmpleados(Conexion.conectar(), listaHamburguesas);
         
         tblc_id.setCellValueFactory(new PropertyValueFactory<Hamburguesas, String>("Id"));
         tblc_nombreHamburg.setCellValueFactory(new PropertyValueFactory<Hamburguesas, String>("Nombre"));
         tblc_descripcionHanbur.setCellValueFactory(new PropertyValueFactory<Hamburguesas, String>("Ingredientes"));
         tblc_precioHanbur.setCellValueFactory(new PropertyValueFactory<Hamburguesas, String>("Precio"));
         tblc_fechaHambur.setCellValueFactory(new PropertyValueFactory<Hamburguesas, String>("Fecha"));
         tblc_imagenHambur.setCellValueFactory(new PropertyValueFactory<Hamburguesas, Blob>("Imagen"));
         
         
        
         
        tblv_hamburguesas.setItems(listaHamburguesas);
        
        gestionarEventosHambur();
        
        
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
        
        cmb_claProducto.getItems().addAll(listaClaProducto);
        
        //------ Fin del Combo Box ----------------------
        
    }
    
    

public void gestionarEventosHambur() {
        tblv_hamburguesas.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Hamburguesas>() {
            @Override
            public void changed(ObservableValue<? extends Hamburguesas> observable, Hamburguesas valorAnterior, Hamburguesas valorSeleccionado) {

                producto = valorSeleccionado.getNombre();

                //System.out.println("Nombre del alumno seleccionado " + update_user);

            }

        });
    }   

    @FXML
    private void FichaHamburguesas(MouseEvent event) {
        
        user = LoginAdministradorController.user;
        
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ficha_Hamburguesa.fxml"));

            Parent root = loader.load();
            Ficha_HamburguesaController controlador = loader.getController();

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

    @FXML
    private void GuardarHamburguesas(ActionEvent event) {
        
        int validacion = 0, claProducto;
        String  num_producto, nombre, ingredientes, precio, fecha, claProducto_String="";
        
        num_producto = id_producto.getText().trim();
        nombre = txt_nombre.getText().trim();
        claProducto = cmb_claProducto.getSelectionModel().getSelectedIndex()+1;
        ingredientes = txt_Descripcion.getText().trim();
        precio = txt_Precio.getText().trim();
        fecha = lbl_Fecha.getText().trim();
        
        
        if (num_producto.equals("")) {
            id_producto.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (nombre.equals("")) {
            txt_nombre.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (ingredientes.equals("")) {
            txt_Descripcion.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        if (precio.equals("")) {
            txt_Precio.setStyle("-fx-background-color: #F64104 ;");
            validacion++;
        }
        
        // Combo Box de los Productos
        
         if (claProducto == 1) {
            claProducto_String = "Pizzas";
        } else if (claProducto == 2) {
            claProducto_String = "Hamburguesas";
        } else if (claProducto == 3) {
            claProducto_String = "Entrantes y Poatres";
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
                txt_nombre.setStyle("-fx-background-color: #F64104 ;");

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
                       
                        Limpiar();
                        
                        id_producto.setStyle("-fx-background-color: #6DF80C ;");
                        txt_nombre.setStyle("-fx-background-color: #6DF80C ;");
                        txt_Descripcion.setStyle("-fx-background-color: #6DF80C ;");
                        txt_Precio.setStyle("-fx-background-color: #6DF80C ;");

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

        id_producto.setText("");
        txt_nombre.setText("");
        txt_Descripcion.setText("");
        txt_Precio.setText("");

    }

}
