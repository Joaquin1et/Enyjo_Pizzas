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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 * @author Joaquín
 */
public class Pedido_BebidasController implements Initializable {

    @FXML
    private Label lbl_pedidoNom_B1;
    @FXML
    private ImageView Iv_pedido_B1;
    @FXML
    private Label lbl_pedidoPrecio_B1;
    @FXML
    private Label lbl_pedidoNom_B2;
    @FXML
    private ImageView Iv_pedido_B2;
    @FXML
    private Label lbl_pedidoPrecio_B2;
    @FXML
    private Label lbl_pedidoNom_B3;
    @FXML
    private ImageView Iv_pedido_B3;
    @FXML
    private Label lbl_pedidoPrecio_B3;
    @FXML
    private Label lbl_pedidoNom_B4;
    @FXML
    private ImageView Iv_pedido_B4;
    @FXML
    private Label lbl_pedidoPrecio_B4;
    @FXML
    private Label lbl_pedidoNom_B5;
    @FXML
    private ImageView Iv_pedido_B5;
    @FXML
    private Label lbl_pedidoPrecio_B5;
    @FXML
    private Label lbl_pedidoNom_B6;
    @FXML
    private ImageView Iv_pedido_B6;
    @FXML
    private Label lbl_pedidoPrecio_B6;
    @FXML
    private Label lbl_pedidoNom_B7;
    @FXML
    private ImageView Iv_pedido_B7;
    @FXML
    private Label lbl_pedidoPrecio_B7;
    @FXML
    private Label lbl_pedidoNom_B8;
    @FXML
    private ImageView Iv_pedido_B8;
    @FXML
    private Label lbl_pedidoPrecio_B8;
    @FXML
    private Spinner<Integer> spi_Bebidas_1;
    @FXML
    private Spinner<Integer> spi_Bebidas_2;
    @FXML
    private Spinner<Integer> spi_Bebidas_3;
    @FXML
    private Spinner<Integer> spi_Bebidas_4;
    @FXML
    private Spinner<Integer> spi_Bebidas_5;
    @FXML
    private Spinner<Integer> spi_Bebidas_6;
    @FXML
    private Spinner<Integer> spi_Bebidas_7;
    @FXML
    private Spinner<Integer> spi_Bebidas_8;
    
    final int valorInicial = 0;
    
    SpinnerValueFactory<Integer> spi_B_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_B_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        spi_Bebidas_1.setValueFactory(spi_B_1);
        spi_Bebidas_2.setValueFactory(spi_B_2);
        spi_Bebidas_3.setValueFactory(spi_B_3);
        spi_Bebidas_4.setValueFactory(spi_B_4);
        spi_Bebidas_5.setValueFactory(spi_B_5);
        spi_Bebidas_6.setValueFactory(spi_B_6);
        spi_Bebidas_7.setValueFactory(spi_B_7);
        spi_Bebidas_8.setValueFactory(spi_B_8);
        
        
         //----- PRIMER ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B1.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- SEGUNDO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B2.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B2.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- PTERCERO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B3.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B3.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B3.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- CUARTO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B4.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B4.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B4.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- QUINTO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B5.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B5.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B5.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- SEXTO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B6.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B6.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B6.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- SEPTIMO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B7.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B7.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B7.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        //----- OCTAVO ARTICULO DE PEDIDOS DE BEBIDAS------------
        
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
                
                Iv_pedido_B8.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_B8.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_B8.setText(rs.getString("precio"));
               
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        
    }    
    
}
