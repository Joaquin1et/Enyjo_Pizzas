package controller;

import static controller.CartaController.nombreBurguer;
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
import model.Sonidos;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class Carta_PizzasController implements Initializable {

    @FXML
    private Button btn_CartaPizzas;
    @FXML
    private Button btn_CartaHambur;
    @FXML
    private Button btn_CartaEntrantes;
    @FXML
    private Button btn_CartasBebidas;
    @FXML
    private AnchorPane contenArea;
    @FXML
    private Pane pane_CartaPizza_1;
    @FXML
    private Pane pane_CartaPizza_2;
    @FXML
    private Pane pane_CartaPizza_3;
    @FXML
    private Pane pane_CartaPizza_4;
    @FXML
    private Pane pane_CartaPizza_5;
    @FXML
    private Pane pane_CartaPizza_6;
    @FXML
    private Pane pane_CartaPizza_7;
    @FXML
    private Pane pane_CartaPizza_8;
    @FXML
    private Label lbl_nombrePizza1;
    @FXML
    private Label lbl_nombrePizza2;
    @FXML
    private Label lbl_nombrePizza3;
    @FXML
    private Label lbl_nombrePizza4;
    @FXML
    private Label lbl_nombrePizza5;
    @FXML
    private Label lbl_nombrePizza6;
    @FXML
    private Label lbl_nombrePizza7;
    @FXML
    private Label lbl_nombrePizza8;
    @FXML
    private ImageView Iv_imagenPizza1;
    @FXML
    private ImageView Iv_imagenPizza2;
    @FXML
    private ImageView Iv_imagenPizza3;
    @FXML
    private ImageView Iv_imagenPizza4;
    @FXML
    private ImageView Iv_imagenPizza5;
    @FXML
    private ImageView Iv_imagenPizza6;
    @FXML
    private ImageView Iv_imagenPizza7;
    @FXML
    private ImageView Iv_imagenPizza8;
    @FXML
    private Label lbl_precioPizza1;
    @FXML
    private Label lbl_precioPizza2;
    @FXML
    private Label lbl_precioPizza3;
    @FXML
    private Label lbl_precioPizza4;
    @FXML
    private Label lbl_precioPizza5;
    @FXML
    private Label lbl_precioPizza6;
    @FXML
    private Label lbl_precioPizza7;
    @FXML
    private Label lbl_precioPizza8;
    
    //public static String nombreBurguer = "" ;
    public static String nombrePizza = "" ;
    
    Sonidos carta_Pizza = new Sonidos();
    @FXML
    private Button btn_CartaExtras;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-P'");
            ResultSet rs = pst.executeQuery();
            
            carta_Pizza.Carta_Pizzas();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha cargado la imagen.");
                }
                
                Iv_imagenPizza1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombrePizza1.setText(rs.getString("nombre"));
                lbl_precioPizza1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        //-----Segundo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'2-P'");
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
                
                lbl_nombrePizza2.setText(rs.getString("nombre"));
                lbl_precioPizza2.setText(rs.getString("precio"));
                Iv_imagenPizza2.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Tercer plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'3-P'");
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
                
                lbl_nombrePizza3.setText(rs.getString("nombre"));
                lbl_precioPizza3.setText(rs.getString("precio"));
                Iv_imagenPizza3.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Cuarto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'4-P'");
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
                
                lbl_nombrePizza4.setText(rs.getString("nombre"));
                lbl_precioPizza4.setText(rs.getString("precio"));
                Iv_imagenPizza4.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Quinto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'5-P'");
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
                
                lbl_nombrePizza5.setText(rs.getString("nombre"));
                lbl_precioPizza5.setText(rs.getString("precio"));
                Iv_imagenPizza5.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Sexto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'6-P'");
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
                
                lbl_nombrePizza6.setText(rs.getString("nombre"));
                lbl_precioPizza6.setText(rs.getString("precio"));
                Iv_imagenPizza6.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Séptimo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'7-P'");
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
                
                lbl_nombrePizza7.setText(rs.getString("nombre"));
                lbl_precioPizza7.setText(rs.getString("precio"));
                Iv_imagenPizza7.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Octavo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'8-P'");
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
                
                lbl_nombrePizza8.setText(rs.getString("nombre"));
                lbl_precioPizza8.setText(rs.getString("precio"));
                Iv_imagenPizza8.setImage(i); //Aqui colocamos la ImageView
                
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
             System.out.println("No entro la carta de Las Pizzas");
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
             System.out.println("No entro la carta de Las Hamburguesas");
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
             System.out.println("No entro la carta de Los Entrantes");
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
             System.out.println("No entro la carta de Las Bebidas");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void CartaExtras(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Extras.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("No entro la carta de Los Extras");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Ficha_Pizza_1(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza1.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizzas.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_2(MouseEvent event) {
        
        nombrePizza= lbl_nombrePizza2.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizzas.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                           stage.setTitle("PIZZAS ENYJO ");
                            
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
    private void Ficha_Pizza_3(MouseEvent event) {
        
            nombrePizza = lbl_nombrePizza3.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizzas.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_4(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza4.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizzas.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_5(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza5.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizza.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_6(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza6.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizza.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_7(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza7.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizza.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
    private void Ficha_Pizza_8(MouseEvent event) {
        
        nombrePizza = lbl_nombrePizza8.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Pizza.fxml"));
                           
                            Parent root = loader.load();
                            PizzasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("PIZZAS ENYJO ");
                           
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
