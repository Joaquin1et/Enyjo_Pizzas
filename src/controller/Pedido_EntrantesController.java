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
public class Pedido_EntrantesController implements Initializable {

    @FXML
    private Label lbl_pedidoNom_E1;
    @FXML
    private ImageView Iv_pedido_E1;
    @FXML
    private Label lbl_pedidoPrecio_E1;
    @FXML
    private Label lbl_pedidoNom_E2;
    @FXML
    private ImageView Iv_pedido_E2;
    @FXML
    private Label lbl_pedidoPrecio_E2;
    @FXML
    private Label lbl_pedidoNom_E3;
    @FXML
    private ImageView Iv_pedido_E3;
    @FXML
    private Label lbl_pedidoPrecio_E3;
    @FXML
    private Label lbl_pedidoNom_E4;
    @FXML
    private ImageView Iv_pedido_E4;
    @FXML
    private Label lbl_pedidoPrecio_E4;
    @FXML
    private Label lbl_pedidoNom_E5;
    @FXML
    private ImageView Iv_pedido_E5;
    @FXML
    private Label lbl_pedidoPrecio_E5;
    @FXML
    private Label lbl_pedidoNom_E6;
    @FXML
    private ImageView Iv_pedido_E6;
    @FXML
    private Label lbl_pedidoPrecio_E6;
    @FXML
    private Label lbl_pedidoNom_E7;
    @FXML
    private ImageView Iv_pedido_E7;
    @FXML
    private Label lbl_pedidoPrecio_E7;
    @FXML
    private Label lbl_pedidoNom_E8;
    @FXML
    private ImageView Iv_pedido_E8;
    @FXML
    private Label lbl_pedidoPrecio_E8;
    @FXML
    private Spinner<Integer> spi_Entrantes_1;
    @FXML
    private Spinner<Integer> spi_Entrantes_2;
    @FXML
    private Spinner<Integer> spi_Entrantes_3;
    @FXML
    private Spinner<Integer> spi_Entrantes_4;
    @FXML
    private Spinner<Integer> spi_Entrantes_5;
    @FXML
    private Spinner<Integer> spi_Entrantes_6;
    @FXML
    private Spinner<Integer> spi_Entrantes_7;
    @FXML
    private Spinner<Integer> spi_Entrantes_8;
    
    final int valorInicial = 0;
    SpinnerValueFactory<Integer> spi_E_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_E_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        spi_Entrantes_1.setValueFactory(spi_E_1);
        spi_Entrantes_2.setValueFactory(spi_E_2);
        spi_Entrantes_3.setValueFactory(spi_E_3);
        spi_Entrantes_4.setValueFactory(spi_E_4);
        spi_Entrantes_5.setValueFactory(spi_E_5);
        spi_Entrantes_6.setValueFactory(spi_E_6);
        spi_Entrantes_7.setValueFactory(spi_E_7);
        spi_Entrantes_8.setValueFactory(spi_E_8);
        
        //----- PRIMER ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E1.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E1.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E1.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEGUNDO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E2.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E2.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- TERCER ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E3.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E3.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E3.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- CUARTO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E4.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E4.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E4.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- QUINTO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E5.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E5.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E5.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEXTO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E6.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E6.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E6.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- SEPTIMO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E7.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E7.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E7.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
         //----- OCTAVO ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        
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
                
                Iv_pedido_E8.setImage(i); //Aqui colocamos la ImageView
                
                //ID = rs.getInt("id_empleado");

                lbl_pedidoNom_E8.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_E8.setText(rs.getString("precio"));
                
            }

            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }
        
        
        
        
        
    }    
    
}
