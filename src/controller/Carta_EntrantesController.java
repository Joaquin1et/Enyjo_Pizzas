
package controller;

import static controller.Carta_BebidasController.nombreBebida;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class Carta_EntrantesController implements Initializable {

    @FXML
    private Button btn_CartaPizzas;
    @FXML
    private Button btn_CartaHambur;
    @FXML
    private Button btn_CartaEntrantes;
    @FXML
    private Button btn_CartaBebidas;
    @FXML
    private Pane pane_CartaEntran_1;
    @FXML
    private AnchorPane contenArea;
    @FXML
    private ImageView Iv_imagenEntra_2;
    @FXML
    private Label lbl_precioEntra_2;
    @FXML
    private Label lbl_nombreEntra_2;
    @FXML
    private Label lbl_nombreEntra_1;
    @FXML
    private ImageView Iv_imagenEntra_1;
    @FXML
    private Label lbl_precioEntra_1;
    @FXML
    private Label lbl_nombreEntra_3;
    @FXML
    private ImageView Iv_imagenEntra_3;
    @FXML
    private Label lbl_precioEntra_3;
    @FXML
    private Label lbl_nombreEntra_4;
    @FXML
    private ImageView Iv_imagenEntra_4;
    @FXML
    private Label lbl_precioEntra_4;
    @FXML
    private Label lbl_nombreEntra_5;
    @FXML
    private ImageView Iv_imagenEntra_5;
    @FXML
    private Label lbl_precioEntra_5;
    @FXML
    private Label lbl_nombreEntra_6;
    @FXML
    private ImageView Iv_imagenEntra_6;
    @FXML
    private Label lbl_precioEntra_6;
    @FXML
    private Label lbl_nombreEntra_7;
    @FXML
    private ImageView Iv_imagenEntrta_7;
    @FXML
    private Label lbl_precioEntra_7;
    @FXML
    private Label lbl_nombreEntra_8;
    @FXML
    private ImageView Iv_imagenEntra_8;
    @FXML
    private Label lbl_precioEntra_8;
    @FXML
    private Pane pane_CartaEntran_2;
    @FXML
    private Pane pane_CartaEntran_3;
    @FXML
    private Pane pane_CartaEntran_4;
    @FXML
    private Pane pane_CartaEntran_5;
    @FXML
    private Pane pane_CartaEntran_6;
    @FXML
    private Pane pane_CartaEntran_7;
    @FXML
    private Pane pane_CartaEntran_8;
    
    public static String nombreEntrante = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                Iv_imagenEntra_1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreEntra_1.setText(rs.getString("nombre"));
                lbl_precioEntra_1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        //-----Segundo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'2-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_2.setText(rs.getString("nombre"));
                lbl_precioEntra_2.setText(rs.getString("precio"));
                Iv_imagenEntra_2.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Tercer plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'3-EP'");
            ResultSet rs = pst.executeQuery();
           
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_3.setText(rs.getString("nombre"));
                lbl_precioEntra_3.setText(rs.getString("precio"));
                Iv_imagenEntra_3.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Cuarto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'4-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_4.setText(rs.getString("nombre"));
                lbl_precioEntra_4.setText(rs.getString("precio"));
                Iv_imagenEntra_4.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Quinto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'5-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_5.setText(rs.getString("nombre"));
                lbl_precioEntra_5.setText(rs.getString("precio"));
                Iv_imagenEntra_5.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Sexto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'6-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_6.setText(rs.getString("nombre"));
                lbl_precioEntra_6.setText(rs.getString("precio"));
                Iv_imagenEntra_6.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Séptimo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'7-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_7.setText(rs.getString("nombre"));
                lbl_precioEntra_7.setText(rs.getString("precio"));
                Iv_imagenEntrta_7.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Octavo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'8-EP'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("Me cago en tu padre.");
                }
                
                lbl_nombreEntra_8.setText(rs.getString("nombre"));
                lbl_precioEntra_8.setText(rs.getString("precio"));
                Iv_imagenEntra_8.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
    }    

    @FXML
    private void Carta_Pizzas(ActionEvent event) {
        
         try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Pizzas.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Carta_Hamburguesas(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Carta_Entrantes(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Entrantes.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Carta_Bebidas(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Bebidas.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @FXML
    private void Ficha_entran_1(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_1.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
    @FXML
    private void Ficha_entran_2(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_2.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
    @FXML
    private void Ficha_entran_3(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_3.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Ficha_entran_4(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_4.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Ficha_entran_5(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_5.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Ficha_entran_6(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_6.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Ficha_entran_7(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_7.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void Ficha_entran_8(MouseEvent event) {
        
        nombreEntrante = lbl_nombreEntra_8.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Entrantes.fxml"));
                           
                            Parent root = loader.load();
                            EntrantesController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("ENTRANTES Y POSTRES ENYJO ");
                           
                            stage.setScene(scene);
                            //stage.initModality(Modality.APPLICATION_MODAL);
                            
                            stage.getIcons().add(new javafx.scene.image.Image("images/gorrologo.png"));
                            stage.setResizable(false);
                            
                            stage.show();
                            
                            
                        }catch (IOException ex) {
                            Logger.getLogger(HamburguesasController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
    
}
