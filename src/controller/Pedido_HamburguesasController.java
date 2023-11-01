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
public class Pedido_HamburguesasController implements Initializable {

    @FXML
    private Label lbl_pedidoNom_H1;
    @FXML
    private ImageView Iv_pedido_H1;
    @FXML
    private Label lbl_pedidoPrecio_H1;
    @FXML
    private Label lbl_pedidoNom_H2;
    @FXML
    private ImageView Iv_pedido_H2;
    @FXML
    private Label lbl_pedidoPrecio_H2;
    @FXML
    private Label lbl_pedidoNom_H3;
    @FXML
    private ImageView Iv_pedido_H3;
    @FXML
    private Label lbl_pedidoPrecio_H3;
    @FXML
    private Label lbl_pedidoNom_H4;
    @FXML
    private ImageView Iv_pedido_H4;
    @FXML
    private Label lbl_pedidoPrecio_H4;
    @FXML
    private Label lbl_pedidoNom_H5;
    @FXML
    private ImageView Iv_pedido_H5;
    @FXML
    private Label lbl_pedidoPrecio_H5;
    @FXML
    private Label lbl_pedidoNom_H6;
    @FXML
    private ImageView Iv_pedido_H6;
    @FXML
    private Label lbl_pedidoPrecio_H6;
    @FXML
    private Label lbl_pedidoNom_H7;
    @FXML
    private ImageView Iv_pedido_H7;
    @FXML
    private Label lbl_pedidoPrecio_H7;
    @FXML
    private Label lbl_pedidoNom_H8;
    @FXML
    private ImageView Iv_pedido_H8;
    @FXML
    private Label lbl_pedidoPrecio_H8;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_1;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_2;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_3;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_4;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_5;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_6;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_7;
    @FXML
    private Spinner<Integer> spi_Hamburguesas_8;

    final int valorInicial = 0;
    SpinnerValueFactory<Integer> spi_H_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_H_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        spi_Hamburguesas_1.setValueFactory(spi_H_1);
        spi_Hamburguesas_2.setValueFactory(spi_H_2);
        spi_Hamburguesas_3.setValueFactory(spi_H_3);
        spi_Hamburguesas_4.setValueFactory(spi_H_4);
        spi_Hamburguesas_5.setValueFactory(spi_H_5);
        spi_Hamburguesas_6.setValueFactory(spi_H_6);
        spi_Hamburguesas_7.setValueFactory(spi_H_7);
        spi_Hamburguesas_8.setValueFactory(spi_H_8);
        
        
         //----- PRIMER ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H1.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H1.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEGUNDO ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H2.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H2.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- TERCER ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H3.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H3.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H3.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- CUARTO ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H4.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H4.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H4.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- QUINTO ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H5.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H5.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H5.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEXTO ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H6.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H6.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H6.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEPTIMOARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H7.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H7.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H7.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- OCTAVO ARTICULO DE PEDIDOS HAMBURGUESAS------------
        
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
                
                Iv_pedido_H8.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_H8.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_H8.setText(rs.getString("precio"));
                
                
                
                
            
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

    }

}
