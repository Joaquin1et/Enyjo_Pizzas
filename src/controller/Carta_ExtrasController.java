/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * FXML Controller class
 *
 * @author joaqu
 */
public class Carta_ExtrasController implements Initializable {

    @FXML
    private AnchorPane contenArea;
    @FXML
    private Button btn_CartaPizzas;
    @FXML
    private Button btn_CartaHambur;
    @FXML
    private Button btn_CartaEntrantes;
    @FXML
    private Button btn_CartasBebidas;
    @FXML
    private Button btn_CartaExtras;
    @FXML
    private Pane pane_CartaExtras_2;
    @FXML
    private Label lbl_nombreExtra2;
    @FXML
    private ImageView Iv_imagenExtra2;
    @FXML
    private Label lbl_precioExtra2;
    @FXML
    private Pane pane_CartaExtras_3;
    @FXML
    private Label lbl_nombreExtra3;
    @FXML
    private ImageView Iv_imagenExtra3;
    @FXML
    private Label lbl_precioExtra3;
    @FXML
    private Pane pane_CartaExtras_4;
    @FXML
    private Label lbl_nombreExtra4;
    @FXML
    private ImageView Iv_imagenExtra4;
    @FXML
    private Label lbl_precioExtra4;
    @FXML
    private Pane pane_CartaExtras_5;
    @FXML
    private Label lbl_nombreExtra5;
    @FXML
    private ImageView Iv_imagenExtra5;
    @FXML
    private Label lbl_precioExtra5;
    @FXML
    private Pane pane_CartaExtras_6;
    @FXML
    private Label lbl_nombreExtra6;
    @FXML
    private ImageView Iv_imagenExtra6;
    @FXML
    private Label lbl_precioExtra6;
    @FXML
    private Pane pane_CartaExtras_7;
    @FXML
    private Label lbl_nombreExtra7;
    @FXML
    private ImageView Iv_imagenExtra7;
    @FXML
    private Label lbl_precioExtra7;
    @FXML
    private Pane pane_CartaExtras_8;
    @FXML
    private Label lbl_nombreExtra8;
    @FXML
    private ImageView Iv_imagenExtra8;
    @FXML
    private Label lbl_precioExtra8;
    @FXML
    private Pane pane_CartaExtras_1;
    @FXML
    private Label lbl_nombreExtra1;
    @FXML
    private ImageView Iv_imagenExtra1;
    @FXML
    private Label lbl_precioExtra1;
    
    public static String nombreExtra = "" ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //-----Primer extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra1.setText(rs.getString("nombre"));
                lbl_precioExtra1.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Segundo extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'2-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra2.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra2.setText(rs.getString("nombre"));
                lbl_precioExtra2.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Tercer extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'3-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra3.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra3.setText(rs.getString("nombre"));
                lbl_precioExtra3.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Cuarto extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'4-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra4.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra4.setText(rs.getString("nombre"));
                lbl_precioExtra4.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Quinto extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'5-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra5.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra5.setText(rs.getString("nombre"));
                lbl_precioExtra5.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Sexto extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'6-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra6.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra6.setText(rs.getString("nombre"));
                lbl_precioExtra6.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Séptimo extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'7-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra7.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra7.setText(rs.getString("nombre"));
                lbl_precioExtra7.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //-----Octavo extra de la carta  --------------
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'8-EX'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                
                Image i = null;
                Blob blob = rs.getBlob("images");
                try {
                    i = SwingFXUtils.toFXImage(javax.imageio.ImageIO.read(blob.getBinaryStream()), null);
                } catch (IOException ex) {
                    Logger.getLogger(Ficha_AdmidBebidasController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    System.out.println("No ha carcado la imagen.");
                }
                
                Iv_imagenExtra8.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_nombreExtra8.setText(rs.getString("nombre"));
                lbl_precioExtra8.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar El producto." + e);
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
             System.out.println("No entro la carta Pizzas");
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
             System.out.println("No entro la carta Hamburguesas");
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
    private void Ficha_Extra_1(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra1.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_2(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra2.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_3(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra3.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_4(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra4.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_5(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra5.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_6(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra6.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_7(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra7.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
    private void Ficha_Extra_8(MouseEvent event) {
        
        nombreExtra = lbl_nombreExtra8.getText().trim();
       
        try {
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Extras.fxml"));
                           
                            Parent root = loader.load();
                            ExtrasController controlador = loader.getController();
                            
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
