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

 * @author Joaquín
 */
public class Carta_BebidasController implements Initializable {

    @FXML
    private AnchorPane contenArea;
    @FXML
    private Label lbl_nombreBebida_1;
    @FXML
    private ImageView Iv_imagenBebida_1;
    @FXML
    private Label lbl_precioBebida_1;
    @FXML
    private Label lbl_nombreBebida_2;
    @FXML
    private ImageView Iv_imagenBebida_2;
    @FXML
    private Label lbl_precioBebida_2;
    @FXML
    private Label lbl_nombreBebida_3;
    @FXML
    private ImageView Iv_imagenBebida_3;
    @FXML
    private Label lbl_precioBebida_3;
    @FXML
    private Label lbl_nombreBebida_4;
    @FXML
    private ImageView Iv_imagenBebida_4;
    @FXML
    private Label lbl_precioBebida_4;
    @FXML
    private Label lbl_nombreBebida_5;
    @FXML
    private ImageView Iv_imagenBebida_5;
    @FXML
    private Label lbl_precioBebida_5;
    @FXML
    private Label lbl_nombreBebida_8;
    @FXML
    private ImageView Iv_imagenBebida_8;
    @FXML
    private Label lbl_precioBebida_8;
    @FXML
    private Label lbl_nombreBebida_6;
    @FXML
    private ImageView Iv_imagenBebida_6;
    @FXML
    private Label lbl_precioBebida_6;
    @FXML
    private Label lbl_nombreBebida_7;
    @FXML
    private ImageView Iv_imagenBebida_7;
    @FXML
    private Label lbl_precioBebida_7;
    @FXML
    private Button btn_CartaPizzas;
    @FXML
    private Button btn_CartaHamburguesas;
    @FXML
    private Button btn_CartaEntrantes;
    @FXML
    private Button btn_CartaBebidas;
    @FXML
    private Pane pane_CartaBebidas_1;
    @FXML
    private Pane pane_CartaBebidas_2;
    @FXML
    private Pane pane_CartaBebidas_3;
    @FXML
    private Pane pane_CartaBebidas_4;
    @FXML
    private Pane pane_CartaBebidas_5;
    @FXML
    private Pane pane_CartaBebidas_8;
    @FXML
    private Pane pane_CartaBebidas_6;
    @FXML
    private Pane pane_CartaBebidas_7;
    
    public static String nombreBebida = "" ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-B'");
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
                
                Iv_imagenBebida_1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreBebida_1.setText(rs.getString("nombre"));
                lbl_precioBebida_1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        //-----Segundo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'2-B'");
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
                
                lbl_nombreBebida_2.setText(rs.getString("nombre"));
                lbl_precioBebida_2.setText(rs.getString("precio"));
                Iv_imagenBebida_2.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Tercer plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'3-B'");
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
                
                lbl_nombreBebida_3.setText(rs.getString("nombre"));
                lbl_precioBebida_3.setText(rs.getString("precio"));
                Iv_imagenBebida_3.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Cuarto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'4-B'");
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
                
                lbl_nombreBebida_4.setText(rs.getString("nombre"));
                lbl_precioBebida_4.setText(rs.getString("precio"));
                Iv_imagenBebida_4.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Quinto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'5-B'");
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
                
                lbl_nombreBebida_5.setText(rs.getString("nombre"));
                lbl_precioBebida_5.setText(rs.getString("precio"));
                Iv_imagenBebida_5.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Sexto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'6-B'");
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
                
                lbl_nombreBebida_6.setText(rs.getString("nombre"));
                lbl_precioBebida_6.setText(rs.getString("precio"));
                Iv_imagenBebida_6.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Séptimo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'7-B'");
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
                
                lbl_nombreBebida_7.setText(rs.getString("nombre"));
                lbl_precioBebida_7.setText(rs.getString("precio"));
                Iv_imagenBebida_7.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Octavo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'8-B'");
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
                
                lbl_nombreBebida_8.setText(rs.getString("nombre"));
                lbl_precioBebida_8.setText(rs.getString("precio"));
                Iv_imagenBebida_8.setImage(i); //Aqui colocamos la ImageView
                
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
    private void Ficha_Bebida_1(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_1.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_2(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_2.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_3(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_3.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_4(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_4.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_5(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_5.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_6(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_6.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_7(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_7.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
    private void Ficha_Bebida_8(MouseEvent event) {
        
        nombreBebida = lbl_nombreBebida_8.getText().trim();
        
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bebidas.fxml"));
                           
                            Parent root = loader.load();
                            BebidasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("BEBIDAS ENYJO ");
                           
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
