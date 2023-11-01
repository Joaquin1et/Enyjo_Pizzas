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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 
 * @author Joaquín
 */
public class CartaController implements Initializable {

    @FXML
    private Pane pane_CartaHambur_1;
    @FXML
    private Pane pane_CartaHambur_2;
    @FXML
    private Pane pane_CartaHambur_3;
    @FXML
    private Pane pane_CartaHambur_4;
    @FXML
    private Pane pane_CartaHambur_5;
    @FXML
    private Pane pane_CartaHambur_6;
    @FXML
    private Pane pane_CartaHambur_7;
    @FXML
    private Pane pane_CartaHambur_8;
    @FXML
    private Pane areapaneHamburguesa;
    @FXML
    private ImageView lv_imagenHambur1;
    @FXML
    private ImageView lv_imagenHambur2;
    @FXML
    private ImageView Iv_imagenHambur3;
    @FXML
    private ImageView Iv_imagenHambur4;
    @FXML
    private ImageView Iv_imagenHambur5;
    @FXML
    private ImageView Iv_imagenHambur6;
    @FXML
    private ImageView Iv_imagenHambur7;
    @FXML
    private ImageView Iv_imagenHambur8;
    @FXML
    private Label lbl_nombreCartaHambur1;
    @FXML
    private Label lbl_nombreCartaHambur2;
    @FXML
    private Label lbl_nombreCartaHambur3;
    @FXML
    private Label lbl_nombreCartaHambur4;
    @FXML
    private Label lbl_nombreCartaHambur5;
    @FXML
    private Label lbl_nombreCartaHambur6;
    @FXML
    private Label lbl_nombreCartaHambur7;
    @FXML
    private Label lbl_nombreCartaHambur8;
    @FXML
    private Label lbl_PrecioBurguer1;
    @FXML
    private Label lbl_precioBurger2;
    @FXML
    private Label lbl_precioBurger3;
    @FXML
    private Label lbl_precioBurguer4;
    @FXML
    private Label lbl_precioBurguer5;
    @FXML
    private Label lbl_precioBurguer6;
    @FXML
    private Label lbl_precioBurguer7;
    @FXML
    private Label lbl_precioBurguer8;
    
    public static String nombreBurguer = "" ;
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-H'");
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
                
                lv_imagenHambur1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreCartaHambur1.setText(rs.getString("nombre"));
                lbl_PrecioBurguer1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        //-----Segundo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'2-H'");
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
                
                lbl_nombreCartaHambur2.setText(rs.getString("nombre"));
                lbl_precioBurger2.setText(rs.getString("precio"));
                lv_imagenHambur2.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Tercer plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'3-H'");
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
                
                lbl_nombreCartaHambur3.setText(rs.getString("nombre"));
                lbl_precioBurger3.setText(rs.getString("precio"));
                Iv_imagenHambur3.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Cuarto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'4-H'");
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
                
                lbl_nombreCartaHambur4.setText(rs.getString("nombre"));
                lbl_precioBurguer4.setText(rs.getString("precio"));
                Iv_imagenHambur4.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Quinto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'5-H'");
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
                
                lbl_nombreCartaHambur5.setText(rs.getString("nombre"));
                lbl_precioBurguer5.setText(rs.getString("precio"));
                Iv_imagenHambur5.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Sexto plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'6-H'");
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
                
                lbl_nombreCartaHambur6.setText(rs.getString("nombre"));
                lbl_precioBurguer6.setText(rs.getString("precio"));
                Iv_imagenHambur6.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Séptimo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'7-H'");
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
                
                lbl_nombreCartaHambur7.setText(rs.getString("nombre"));
                lbl_precioBurguer7.setText(rs.getString("precio"));
                Iv_imagenHambur7.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Octavo plato de la carta--------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'8-H'");
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
                
                lbl_nombreCartaHambur8.setText(rs.getString("nombre"));
                lbl_precioBurguer8.setText(rs.getString("precio"));
                Iv_imagenHambur8.setImage(i); //Aqui colocamos la ImageView
                
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        
        
    }   
    
    @FXML
    private void Ficha_Hambur1(MouseEvent event) {
        
       nombreBurguer = lbl_nombreCartaHambur1.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur2(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur2.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur3(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur3.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur4(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur4.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur5(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur5.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur6(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur6.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur7(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur7.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void FichaHambur8(MouseEvent event) {
        
        nombreBurguer = lbl_nombreCartaHambur8.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Hamburguesas.fxml"));
                           
                            Parent root = loader.load();
                            HamburguesasController controlador = loader.getController();
                            
                            Scene scene = new Scene(root);
                            Stage stage =new Stage();
                            stage.setTitle("HAMBURGUESAS ENYJO ");
                           
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
    private void Carta_entrantes(ActionEvent event) {
        
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
    private void Carta_bebida(ActionEvent event) {
        
        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("/view/Carta_Bebidas.fxml"));
            contenArea.getChildren().removeAll();
            contenArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
             System.out.println("Valla mierda");
            Logger.getLogger(Carta_PizzasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
