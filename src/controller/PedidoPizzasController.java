package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import model.Conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 * @author Joaquín
 */
public class PedidoPizzasController implements Initializable {

    @FXML
    private Pane contenAreaPedidos;
    @FXML
    private Label lbl_Hora_Pedidos;
    @FXML
    private Label lbl_Fecha_Pedidos;
    @FXML
    private TextField txt_Cliente_Pedidos;
    @FXML
    private TextField txt_numero_Pedido;
    @FXML
    private TextField txt_Cantidad_Pagada;
    @FXML
    private Button btn_pagar;
    @FXML
    private Label lbl_total_pagar;
    @FXML
    private Label lbl_Cambio;
    @FXML
    private Label lbl_pedidoNom_P1;
    @FXML
    private ImageView Iv_pedido_P1;
    @FXML
    private Label lbl_pedidoPrecio_P1;
    @FXML
    private CheckBox check_P1;
    @FXML
    private CheckBox check_P6;
    @FXML
    private CheckBox check_P2;
    @FXML
    private CheckBox check_P7;
    @FXML
    private CheckBox check_P3;
    @FXML
    private CheckBox check_P8;
    @FXML
    private CheckBox check_P4;
    @FXML
    private CheckBox check_P5;
    @FXML
    private Label lbl_pedidoNom_P6;
    @FXML
    private ImageView Iv_pedido_P6;
    @FXML
    private Label lbl_pedidoPrecio_P6;
    @FXML
    private Label lbl_pedidoNom_P2;
    @FXML
    private ImageView Iv_pedido_P2;
    @FXML
    private Label lbl_pedidoPrecio_P2;
    @FXML
    private Label lbl_pedidoNom_P7;
    @FXML
    private ImageView Iv_pedido_P7;
    @FXML
    private Label lbl_pedidoPrecio_P7;
    @FXML
    private Label lbl_pedidoNom_P3;
    @FXML
    private ImageView Iv_pedido_P3;
    @FXML
    private Label lbl_pedidoPrecio_P3;
    @FXML
    private Label lbl_pedidoNom_P8;
    @FXML
    private ImageView Iv_pedido_P8;
    @FXML
    private Label lbl_pedidoPrecio_P8;
    @FXML
    private Label lbl_pedidoNom_P4;
    @FXML
    private ImageView Iv_pedido_P4;
    @FXML
    private Label lbl_pedidoPrecio_P4;
    @FXML
    private Label lbl_pedidoNom_P5;
    @FXML
    private ImageView Iv_pedido_P5;
    @FXML
    private Label lbl_pedidoPrecio_P5;

    String total_Pagar_Pizza1;
    public static String total_A_Pagar_P1 = "";
    public static String total_A_Pagar_P2 = "";

    @FXML
    private Spinner<Integer> spi_Pizzas_1;
    @FXML
    private Spinner<Integer> spi_Pizzas_2;
    @FXML
    private Spinner<Integer> spi_Pizzas_3;
    @FXML
    private Spinner<Integer> spi_Pizzas_4;
    @FXML
    private Spinner<Integer> spi_Pizzas_5;
    @FXML
    private Spinner<Integer> spi_Pizzas_6;
    @FXML
    private Spinner<Integer> spi_Pizzas_7;
    @FXML
    private Spinner<Integer> spi_Pizzas_8;

    final int valorInicial = 1;
    SpinnerValueFactory<Integer> spi_P_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);
    SpinnerValueFactory<Integer> spi_P_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial);

    //------------PEDIDO HAMBURGUESAS--------------
    @FXML
    private Label lbl_pedidoNom_H1;
    @FXML
    private ImageView Iv_pedido_H1;
    @FXML
    private Label lbl_pedidoPrecio_H1;
    @FXML
    private Label lbl_pedidoNom_H6;
    @FXML
    private ImageView Iv_pedido_H6;
    @FXML
    private Label lbl_pedidoPrecio_H6;
    @FXML
    private Label lbl_pedidoNom_H5;
    @FXML
    private ImageView Iv_pedido_H5;
    @FXML
    private Label lbl_pedidoPrecio_H5;
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
    private Label lbl_pedidoNom_H7;
    @FXML
    private ImageView Iv_pedido_H7;
    @FXML
    private Label lbl_pedidoPrecio_H7;
    @FXML
    private Label lbl_pedidoNom_H4;
    @FXML
    private ImageView Iv_pedido_H4;
    @FXML
    private Label lbl_pedidoPrecio_H4;
    @FXML
    private ImageView Iv_pedido_H8;
    @FXML
    private Label lbl_pedidoPrecio_H8;
    @FXML
    private CheckBox check_H1;
    @FXML
    private CheckBox check_H2;
    @FXML
    private CheckBox check_H3;
    @FXML
    private CheckBox check_H4;
    @FXML
    private CheckBox check_H5;
    @FXML
    private CheckBox check_H6;
    @FXML
    private CheckBox check_H7;
    @FXML
    private CheckBox check_H8;
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

    final int valorInicial_H = 1;
    SpinnerValueFactory<Integer> spi_H_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);
    SpinnerValueFactory<Integer> spi_H_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_H);

    //------------PEDIDO ENTRANTES Y POSTRES  --------------
    @FXML
    private Label lbl_pedidoNom_H8;
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
    private Label lbl_pedidoPrecio_E7;
    @FXML
    private Label lbl_pedidoNom_E7;
    @FXML
    private ImageView Iv_pedido_E7;
    @FXML
    private Label lbl_pedidoPrecio_E8;
    @FXML
    private Label lbl_pedidoNom_E8;
    @FXML
    private ImageView Iv_pedido_E8;
    @FXML
    private CheckBox check_E1;
    @FXML
    private CheckBox check_E2;
    @FXML
    private CheckBox check_E3;
    @FXML
    private CheckBox check_E4;
    @FXML
    private CheckBox check_E5;
    @FXML
    private CheckBox check_E6;
    @FXML
    private CheckBox check_E7;
    @FXML
    private CheckBox check_E8;
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

    final int valorInicial_E = 1;
    SpinnerValueFactory<Integer> spi_E_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);
    SpinnerValueFactory<Integer> spi_E_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_E);

    //------------   PEDIDO BEBIDAS --------------
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
    private CheckBox check_B1;
    @FXML
    private CheckBox check_B2;
    @FXML
    private CheckBox check_B3;
    @FXML
    private CheckBox check_B4;
    @FXML
    private CheckBox check_B5;
    @FXML
    private CheckBox check_B6;
    @FXML
    private CheckBox check_B7;
    @FXML
    private CheckBox check_B8;
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

    final int valorInicial_B = 1;
    SpinnerValueFactory<Integer> spi_B_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);
    SpinnerValueFactory<Integer> spi_B_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_B);

    //------------      PEDIDO EXTRAS    --------------
    @FXML
    private Label lbl_pedidoNom_EX1;
    @FXML
    private ImageView Iv_pedido_EX1;
    @FXML
    private Label lbl_pedidoPrecio_EX1;
    @FXML
    private Label lbl_pedidoNom_EX2;
    @FXML
    private ImageView Iv_pedido_EX2;
    @FXML
    private Label lbl_pedidoPrecio_EX2;
    @FXML
    private Label lbl_pedidoNom_EX3;
    @FXML
    private ImageView Iv_pedido_EX3;
    @FXML
    private Label lbl_pedidoPrecio_EX3;
    @FXML
    private Label lbl_pedidoNom_EX4;
    @FXML
    private ImageView Iv_pedido_EX4;
    @FXML
    private Label lbl_pedidoPrecio_EX4;
    @FXML
    private Label lbl_pedidoNom_EX5;
    @FXML
    private ImageView Iv_pedido_EX5;
    @FXML
    private Label lbl_pedidoPrecio_EX5;
    @FXML
    private Label lbl_pedidoNom_EX6;
    @FXML
    private ImageView Iv_pedido_EX6;
    @FXML
    private Label lbl_pedidoPrecio_EX6;
    @FXML
    private Label lbl_pedidoNom_EX7;
    @FXML
    private ImageView Iv_pedido_EX7;
    @FXML
    private Label lbl_pedidoPrecio_EX7;
    @FXML
    private Label lbl_pedidoNom_EX8;
    @FXML
    private ImageView Iv_pedido_EX8;
    @FXML
    private Label lbl_pedidoPrecio_EX8;
    @FXML
    private CheckBox check_EX1;
    @FXML
    private CheckBox check_EX2;
    @FXML
    private CheckBox check_EX3;
    @FXML
    private CheckBox check_EX4;
    @FXML
    private CheckBox check_EX5;
    @FXML
    private CheckBox check_EX6;
    @FXML
    private CheckBox check_EX7;
    @FXML
    private CheckBox check_EX8;
    @FXML
    private Spinner<Integer> spi_Extras_1;
    @FXML
    private Spinner<Integer> spi_Extras_2;
    @FXML
    private Spinner<Integer> spi_Extras_3;
    @FXML
    private Spinner<Integer> spi_Extras_4;
    @FXML
    private Spinner<Integer> spi_Extras_5;
    @FXML
    private Spinner<Integer> spi_Extras_6;
    @FXML
    private Spinner<Integer> spi_Extras_7;
    @FXML
    private Spinner<Integer> spi_Extras_8;

    final int valorInicial_EX = 1;
    SpinnerValueFactory<Integer> spi_EX_1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);
    SpinnerValueFactory<Integer> spi_EX_8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, valorInicial_EX);

    @FXML
    private Label lbl_falso;
    @FXML
    private Label lbl_nuevoPedido;
       
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //INSERTAR FECHA Y HORA
        java.util.Date fecha = new java.util.Date();
        DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        lbl_Fecha_Pedidos.setText(formatofecha.format(fecha));

        DateFormat formatohora = new SimpleDateFormat("HH:mm"); //PARA PONER LOS SEGUNDOS INCLUIR DOS PUNTOS Y SS (" hh:mm:ss" )
        lbl_Hora_Pedidos.setText(formatohora.format(fecha));

        spi_Pizzas_1.setValueFactory(spi_P_1);
        spi_Pizzas_2.setValueFactory(spi_P_2);
        spi_Pizzas_3.setValueFactory(spi_P_3);
        spi_Pizzas_4.setValueFactory(spi_P_4);
        spi_Pizzas_5.setValueFactory(spi_P_5);
        spi_Pizzas_6.setValueFactory(spi_P_6);
        spi_Pizzas_7.setValueFactory(spi_P_7);
        spi_Pizzas_8.setValueFactory(spi_P_8);

        //----- PRIMER ARTICULO DE PEDIDOS PIZZAS------------
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'1-P'");
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

                Iv_pedido_P1.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P1.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P1.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEGUNDO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P2.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P2.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- TERCERO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P3.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P3.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P3.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- CUARTO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P4.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P4.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P4.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- QUINTO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P5.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P5.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P5.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEXTO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P6.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P6.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P6.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEPTIMO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P7.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P7.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P7.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- OCTAVO ARTICULO DE PEDIDOS PIZZAS------------
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

                Iv_pedido_P2.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_P2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_P2.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //---- RECOGER DATOS DE HAMBURGUESAS-----------
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

        //----- SEPTIMO ARTICULO DE PEDIDOS HAMBURGUESAS------------
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

        //------------RECOGER DATOS DE ENTRANTES Y POSTRES ------------------
        spi_Entrantes_1.setValueFactory(spi_E_1);
        spi_Entrantes_2.setValueFactory(spi_E_2);
        spi_Entrantes_3.setValueFactory(spi_E_3);
        spi_Entrantes_4.setValueFactory(spi_E_4);
        spi_Entrantes_5.setValueFactory(spi_E_5);
        spi_Entrantes_6.setValueFactory(spi_E_6);
        spi_Entrantes_7.setValueFactory(spi_E_7);
        spi_Entrantes_8.setValueFactory(spi_E_8);

        //----- PRIMER  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- SEGUNDO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- TERCERO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- CUARTO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from hamburguesas where id like'14-EP'");
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

        //----- QUINTO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- SEXTO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- SEPTIMO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //----- OCTAVO  ARTICULO DE PEDIDOS ENTRANTES Y POSTRES------------
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

        //---------- RECOGER DATOS DE BEBIDAS  ------------------------------
        spi_Bebidas_1.setValueFactory(spi_B_1);
        spi_Bebidas_2.setValueFactory(spi_B_2);
        spi_Bebidas_3.setValueFactory(spi_B_3);
        spi_Bebidas_4.setValueFactory(spi_B_4);
        spi_Bebidas_5.setValueFactory(spi_B_5);
        spi_Bebidas_6.setValueFactory(spi_B_6);
        spi_Bebidas_7.setValueFactory(spi_B_7);
        spi_Bebidas_8.setValueFactory(spi_B_8);

        //----- PRIMER  ARTICULO DE BEBIDAS     ------------
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
        //----- SEGUNDO  ARTICULO DE BEBIDAS     ------------
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

        //----- TERCER  ARTICULO DE BEBIDAS     ------------
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

        //----- CUARTO  ARTICULO DE BEBIDAS     ------------
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

        //----- QUINTO  ARTICULO DE BEBIDAS     ------------
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

        //----- SEXTO  ARTICULO DE BEBIDAS     ------------
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

        //----- SEPTIMO  ARTICULO DE BEBIDAS     ------------
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

        //----- OCTAVO  ARTICULO DE BEBIDAS     ------------
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

        //-----------RECOGER DATOS DE EXTRAS ----------------------
        spi_Extras_1.setValueFactory(spi_EX_1);
        spi_Extras_2.setValueFactory(spi_EX_2);
        spi_Extras_3.setValueFactory(spi_EX_3);
        spi_Extras_4.setValueFactory(spi_EX_4);
        spi_Extras_5.setValueFactory(spi_EX_5);
        spi_Extras_6.setValueFactory(spi_EX_6);
        spi_Extras_7.setValueFactory(spi_EX_7);
        spi_Extras_8.setValueFactory(spi_EX_8);

        //----- PRIMER  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX1.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX1.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX1.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEGUNDO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX2.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX2.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX2.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- TERCER  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX3.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX3.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX3.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- CUARTO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX4.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX4.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX4.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- QUINTO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX5.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX5.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX5.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEXTO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX6.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX6.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX6.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- SEPTIMO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX7.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX7.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX7.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        //----- OCTAVO  ARTICULO DE EXTRAS     ------------
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

                    System.out.println("Me cago en tu padre.");
                }

                Iv_pedido_EX8.setImage(i); //Aqui colocamos la ImageView

                //ID = rs.getInt("id_empleado");
                lbl_pedidoNom_EX8.setText(rs.getString("nombre"));
                lbl_pedidoPrecio_EX8.setText(rs.getString("precio"));

            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al cargar empleado." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al cargar!! Contacte con el administrador.");

        }

        // ------------ VARIABLES PARA CUANDO EL CHECK ESTÉ ACTIVO--------------------------
        spi_Pizzas_1.setDisable(true);
        spi_Pizzas_2.setDisable(true);
        spi_Pizzas_3.setDisable(true);
        spi_Pizzas_4.setDisable(true);
        spi_Pizzas_5.setDisable(true);
        spi_Pizzas_6.setDisable(true);
        spi_Pizzas_7.setDisable(true);
        spi_Pizzas_8.setDisable(true);

        spi_Hamburguesas_1.setDisable(true);
        spi_Hamburguesas_2.setDisable(true);
        spi_Hamburguesas_3.setDisable(true);
        spi_Hamburguesas_4.setDisable(true);
        spi_Hamburguesas_5.setDisable(true);
        spi_Hamburguesas_6.setDisable(true);
        spi_Hamburguesas_7.setDisable(true);
        spi_Hamburguesas_8.setDisable(true);

        spi_Entrantes_1.setDisable(true);
        spi_Entrantes_2.setDisable(true);
        spi_Entrantes_3.setDisable(true);
        spi_Entrantes_4.setDisable(true);
        spi_Entrantes_5.setDisable(true);
        spi_Entrantes_6.setDisable(true);
        spi_Entrantes_7.setDisable(true);
        spi_Entrantes_8.setDisable(true);

        spi_Bebidas_1.setDisable(true);
        spi_Bebidas_2.setDisable(true);
        spi_Bebidas_3.setDisable(true);
        spi_Bebidas_4.setDisable(true);
        spi_Bebidas_5.setDisable(true);
        spi_Bebidas_6.setDisable(true);
        spi_Bebidas_7.setDisable(true);
        spi_Bebidas_8.setDisable(true);

        spi_Extras_1.setDisable(true);
        spi_Extras_2.setDisable(true);
        spi_Extras_3.setDisable(true);
        spi_Extras_4.setDisable(true);
        spi_Extras_5.setDisable(true);
        spi_Extras_6.setDisable(true);
        spi_Extras_7.setDisable(true);
        spi_Extras_8.setDisable(true);

    }

    //------------ TOTAL DE GASTOS EN PIZZAS -------------------------------------
    String preci_P1 = "", preci_P2 = "", preci_P3 = "", preci_P4 = "", preci_P5 = "", preci_P6 = "", preci_P7 = "", preci_P8 = "";
    public static double preci_P1_Conv, preci_P2_Conv, preci_P3_Conv, preci_P4_Conv, preci_P5_Conv, preci_P6_Conv, preci_P7_Conv, preci_P8_Conv;
    double subPrecio_P1 = 0, subPrecio_P2 = 0, subPrecio_P3 = 0, subPrecio_P4 = 0, subPrecio_P5 = 0, subPrecio_P6 = 0, subPrecio_P7 = 0, subPrecio_P8 = 0;
    int qty_P1 = 0, qty_P2 = 0, qty_P3 = 0, qty_P4 = 0, qty_P5 = 0, qty_P6 = 0, qty_P7 = 0, qty_P8 = 0;

    @FXML
    private void check_Pizza_1(MouseEvent event) {

        if (check_P1.isSelected()) {
            spi_Pizzas_1.setDisable(false);
            preci_P1 = lbl_pedidoPrecio_P1.getText();
            preci_P1_Conv = Double.parseDouble(preci_P1);

            subPrecio_P1 = subPrecio_P1 + preci_P1_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_1.setDisable(true);

            subPrecio_P1 = 0;
            spi_P_1.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }

        total();
    }

    @FXML
    private void Cantidad_P1(MouseEvent event) {

        double spin_P1 = preci_P1_Conv;

        if (check_P1.isSelected()) {

            int preQty_P1;
            preQty_P1 = (Integer) spi_Pizzas_1.getValue();

            if (preQty_P1 > qty_P1) {

                qty_P1 = preQty_P1;
                subPrecio_P1 = spin_P1 * preQty_P1;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P1 <= qty_P1) {

                qty_P1 = preQty_P1;
                subPrecio_P1 = spin_P1 * preQty_P1;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }
            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();
    }

    @FXML
    private void check_Pizza_2(MouseEvent event) {

        if (check_P2.isSelected()) {
            spi_Pizzas_2.setDisable(false);
            preci_P2 = lbl_pedidoPrecio_P2.getText();
            preci_P2_Conv = Double.parseDouble(preci_P2);

            subPrecio_P2 = subPrecio_P2 + preci_P2_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_2.setDisable(true);

            subPrecio_P2 = 0;
            spi_P_2.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P2(MouseEvent event) {

        double spin_P2 = preci_P2_Conv;

        if (check_P2.isSelected()) {

            int preQty_P2;
            preQty_P2 = (Integer) spi_Pizzas_2.getValue();

            if (preQty_P2 > qty_P2) {

                qty_P2 = preQty_P2;

                subPrecio_P2 = spin_P2 * preQty_P2;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P2 <= qty_P2) {

                qty_P2 = preQty_P2;

                subPrecio_P2 = spin_P2 * preQty_P2;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_3(MouseEvent event) {

        if (check_P3.isSelected()) {
            spi_Pizzas_3.setDisable(false);
            preci_P3 = lbl_pedidoPrecio_P3.getText();
            preci_P3_Conv = Double.parseDouble(preci_P3);

            subPrecio_P3 = subPrecio_P3 + preci_P3_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_3.setDisable(true);

            subPrecio_P3 = 0;
            spi_P_3.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P3(MouseEvent event) {

        double spin_P3 = preci_P3_Conv;

        if (check_P3.isSelected()) {

            int preQty_P3;
            preQty_P3 = (Integer) spi_Pizzas_3.getValue();

            if (preQty_P3 > qty_P3) {

                qty_P3 = preQty_P3;

                subPrecio_P3 = spin_P3 * preQty_P3;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P3 <= qty_P3) {

                qty_P3 = preQty_P3;

                subPrecio_P3 = spin_P3 * preQty_P3;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_4(MouseEvent event) {

        if (check_P4.isSelected()) {
            spi_Pizzas_4.setDisable(false);
            preci_P4 = lbl_pedidoPrecio_P4.getText();
            preci_P4_Conv = Double.parseDouble(preci_P4);

            subPrecio_P4 = subPrecio_P4 + preci_P4_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_4.setDisable(true);

            subPrecio_P4 = 0;
            spi_P_4.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P4(MouseEvent event) {

        double spin_P4 = preci_P4_Conv;

        if (check_P4.isSelected()) {

            int preQty_P4;
            preQty_P4 = (Integer) spi_Pizzas_4.getValue();

            if (preQty_P4 > qty_P4) {

                qty_P4 = preQty_P4;

                subPrecio_P4 = spin_P4 * preQty_P4;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P4 <= qty_P4) {

                qty_P4 = preQty_P4;

                subPrecio_P4 = spin_P4 * preQty_P4;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_5(MouseEvent event) {

        if (check_P5.isSelected()) {
            spi_Pizzas_5.setDisable(false);
            preci_P5 = lbl_pedidoPrecio_P5.getText();
            preci_P5_Conv = Double.parseDouble(preci_P5);

            subPrecio_P5 = subPrecio_P5 + preci_P5_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_5.setDisable(true);

            subPrecio_P5 = 0;
            spi_P_5.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P5(MouseEvent event) {

        double spin_P5 = preci_P5_Conv;

        if (check_P5.isSelected()) {

            int preQty_P5;
            preQty_P5 = (Integer) spi_Pizzas_5.getValue();

            if (preQty_P5 > qty_P5) {

                qty_P5 = preQty_P5;

                subPrecio_P5 = spin_P5 * preQty_P5;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P5 <= qty_P5) {

                qty_P5 = preQty_P5;

                subPrecio_P5 = spin_P5 * preQty_P5;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_6(MouseEvent event) {

        if (check_P6.isSelected()) {
            spi_Pizzas_6.setDisable(false);
            preci_P6 = lbl_pedidoPrecio_P6.getText();
            preci_P6_Conv = Double.parseDouble(preci_P6);

            subPrecio_P6 = subPrecio_P6 + preci_P6_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_6.setDisable(true);

            subPrecio_P6 = 0;
            spi_P_6.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P6(MouseEvent event) {

        double spin_P6 = preci_P6_Conv;

        if (check_P6.isSelected()) {

            int preQty_P6;
            preQty_P6 = (Integer) spi_Pizzas_6.getValue();

            if (preQty_P6 > qty_P6) {

                qty_P6 = preQty_P6;

                subPrecio_P6 = spin_P6 * preQty_P6;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P6 <= qty_P6) {

                qty_P6 = preQty_P6;

                subPrecio_P6 = spin_P6 * preQty_P6;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_7(MouseEvent event) {

        if (check_P7.isSelected()) {
            spi_Pizzas_7.setDisable(false);
            preci_P7 = lbl_pedidoPrecio_P7.getText();
            preci_P7_Conv = Double.parseDouble(preci_P7);

            subPrecio_P7 = subPrecio_P7 + preci_P7_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_7.setDisable(true);

            subPrecio_P7 = 0;
            spi_P_7.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P7(MouseEvent event) {

        double spin_P7 = preci_P7_Conv;

        if (check_P7.isSelected()) {

            int preQty_P7;
            preQty_P7 = (Integer) spi_Pizzas_7.getValue();

            if (preQty_P7 > qty_P7) {

                qty_P7 = preQty_P7;

                subPrecio_P7 = spin_P7 * preQty_P7;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P7 <= qty_P7) {

                qty_P7 = preQty_P7;

                subPrecio_P7 = spin_P7 * preQty_P7;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    @FXML
    private void check_Pizza_8(MouseEvent event) {

        if (check_P8.isSelected()) {
            spi_Pizzas_8.setDisable(false);
            preci_P8 = lbl_pedidoPrecio_P8.getText();
            preci_P8_Conv = Double.parseDouble(preci_P8);

            subPrecio_P8 = subPrecio_P8 + preci_P8_Conv;
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        } else {
            spi_Pizzas_8.setDisable(true);

            subPrecio_P8 = 0;
            spi_P_8.setValue(1);
            totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;
            lbl_falso.setText(String.valueOf(totalPizzas));

        }
        total();

    }

    @FXML
    private void Cantidad_P8(MouseEvent event) {

        double spin_P8 = preci_P8_Conv;

        if (check_P8.isSelected()) {

            int preQty_P8;
            preQty_P8 = (Integer) spi_Pizzas_8.getValue();

            if (preQty_P8 > qty_P8) {

                qty_P8 = preQty_P8;

                subPrecio_P8 = spin_P8 * preQty_P8;

                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            } else if (preQty_P8 <= qty_P8) {

                qty_P8 = preQty_P8;

                subPrecio_P8 = spin_P8 * preQty_P8;
                totalPizzas = subPrecio_P2 + subPrecio_P1 + subPrecio_P3 + subPrecio_P4 + subPrecio_P5 + subPrecio_P6 + subPrecio_P7 + subPrecio_P8;

            }

            lbl_falso.setText(String.valueOf(totalPizzas));
            total();
        }
        total();

    }

    //-------------- TERMINA EL PEDIDO DE LAS PIZZAS --------------------------------------------------
    //-------------- Empieza EL PEDIDO DE LAS HAMBURGUESAS --------------------------------------------------
    // ------------ VARIABLES PARA CUANDO EL CHECK ESTÉ ACTIVO--------------------------
    //------------ TOTAL DE GASTOS EN HAMBURGUESAS -------------------------------------
    String preci_H1 = "", preci_H2 = "", preci_H3 = "", preci_H4 = "", preci_H5 = "", preci_H6 = "", preci_H7 = "", preci_H8 = "";
    public static double preci_H1_Conv, preci_H2_Conv, preci_H3_Conv, preci_H4_Conv, preci_H5_Conv, preci_H6_Conv, preci_H7_Conv, preci_H8_Conv;
    double subPrecio_H1 = 0, subPrecio_H2 = 0, subPrecio_H3 = 0, subPrecio_H4 = 0, subPrecio_H5 = 0, subPrecio_H6 = 0, subPrecio_H7 = 0, subPrecio_H8 = 0;
    int qty_H1 = 0, qty_H2 = 0, qty_H3 = 0, qty_H4 = 0, qty_H5 = 0, qty_H6 = 0, qty_H7 = 0, qty_H8 = 0;

    @FXML
    private void check_Hamburguesas_1(MouseEvent event) {

        if (check_H1.isSelected()) {
            spi_Hamburguesas_1.setDisable(false);
            preci_H1 = lbl_pedidoPrecio_H1.getText();
            preci_H1_Conv = Double.parseDouble(preci_H1);

            subPrecio_H1 = subPrecio_H1 + preci_H1_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_1.setDisable(true);

            subPrecio_H1 = 0;
            spi_H_1.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H1(MouseEvent event) {

        double spin_H1 = preci_H1_Conv;

        if (check_H1.isSelected()) {

            int preQty_H1;
            preQty_H1 = (Integer) spi_Hamburguesas_1.getValue();

            if (preQty_H1 > qty_H1) {

                qty_H1 = preQty_H1;

                subPrecio_H1 = spin_H1 * preQty_H1;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H1 <= qty_H1) {

                qty_H1 = preQty_H1;

                subPrecio_H1 = spin_H1 * preQty_H1;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_2(MouseEvent event) {

        if (check_H2.isSelected()) {
            spi_Hamburguesas_2.setDisable(false);
            preci_H2 = lbl_pedidoPrecio_H2.getText();
            preci_H2_Conv = Double.parseDouble(preci_H2);

            subPrecio_H2 = subPrecio_H2 + preci_H2_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_2.setDisable(true);

            subPrecio_H2 = 0;
            spi_H_2.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H2(MouseEvent event) {

        double spin_H2 = preci_H2_Conv;

        if (check_H2.isSelected()) {

            int preQty_H2;
            preQty_H2 = (Integer) spi_Hamburguesas_2.getValue();

            if (preQty_H2 > qty_H2) {

                qty_H2 = preQty_H2;

                subPrecio_H2 = spin_H2 * preQty_H2;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H2 <= qty_H2) {

                qty_H2 = preQty_H2;

                subPrecio_H2 = spin_H2 * preQty_H2;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_3(MouseEvent event) {

        if (check_H3.isSelected()) {
            spi_Hamburguesas_3.setDisable(false);
            preci_H3 = lbl_pedidoPrecio_H3.getText();
            preci_H3_Conv = Double.parseDouble(preci_H3);

            subPrecio_H3 = subPrecio_H3 + preci_H3_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_3.setDisable(true);

            subPrecio_H3 = 0;
            spi_H_3.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H3(MouseEvent event) {

        double spin_H3 = preci_H3_Conv;

        if (check_H3.isSelected()) {

            int preQty_H3;
            preQty_H3 = (Integer) spi_Hamburguesas_3.getValue();

            if (preQty_H3 > qty_H3) {

                qty_H3 = preQty_H3;

                subPrecio_H3 = spin_H3 * preQty_H3;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H3 <= qty_H3) {

                qty_H3 = preQty_H3;

                subPrecio_H3 = spin_H3 * preQty_H3;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_4(MouseEvent event) {

        if (check_H4.isSelected()) {
            spi_Hamburguesas_4.setDisable(false);
            preci_H4 = lbl_pedidoPrecio_H4.getText();
            preci_H4_Conv = Double.parseDouble(preci_H4);

            subPrecio_H4 = subPrecio_H4 + preci_H4_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_4.setDisable(true);

            subPrecio_H4 = 0;
            spi_H_4.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H4(MouseEvent event) {

        double spin_H4 = preci_H4_Conv;

        if (check_H4.isSelected()) {

            int preQty_H4;
            preQty_H4 = (Integer) spi_Hamburguesas_4.getValue();

            if (preQty_H4 > qty_H4) {

                qty_H4 = preQty_H4;

                subPrecio_H4 = spin_H4 * preQty_H4;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H4 <= qty_H4) {

                qty_H4 = preQty_H4;

                subPrecio_H4 = spin_H4 * preQty_H4;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_5(MouseEvent event) {

        if (check_H5.isSelected()) {
            spi_Hamburguesas_5.setDisable(false);
            preci_H5 = lbl_pedidoPrecio_H5.getText();
            preci_H5_Conv = Double.parseDouble(preci_H5);

            subPrecio_H5 = subPrecio_H5 + preci_H5_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_5.setDisable(true);

            subPrecio_H5 = 0;
            spi_H_5.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H5(MouseEvent event) {

        double spin_H5 = preci_H5_Conv;

        if (check_H5.isSelected()) {

            int preQty_H5;
            preQty_H5 = (Integer) spi_Hamburguesas_5.getValue();

            if (preQty_H5 > qty_H5) {

                qty_H5 = preQty_H5;

                subPrecio_H5 = spin_H5 * preQty_H5;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H5 <= qty_H5) {

                qty_H5 = preQty_H5;

                subPrecio_H5 = spin_H5 * preQty_H5;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_6(MouseEvent event) {

        if (check_H6.isSelected()) {
            spi_Hamburguesas_6.setDisable(false);
            preci_H6 = lbl_pedidoPrecio_H6.getText();
            preci_H6_Conv = Double.parseDouble(preci_H6);

            subPrecio_H6 = subPrecio_H6 + preci_H6_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_6.setDisable(true);

            subPrecio_H6 = 0;
            spi_H_6.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H6(MouseEvent event) {

        double spin_H6 = preci_H6_Conv;

        if (check_H6.isSelected()) {

            int preQty_H6;
            preQty_H6 = (Integer) spi_Hamburguesas_6.getValue();

            if (preQty_H6 > qty_H6) {

                qty_H6 = preQty_H6;

                subPrecio_H6 = spin_H6 * preQty_H6;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H6 <= qty_H6) {

                qty_H6 = preQty_H6;

                subPrecio_H6 = spin_H6 * preQty_H6;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_7(MouseEvent event) {

        if (check_H7.isSelected()) {
            spi_Hamburguesas_7.setDisable(false);
            preci_H7 = lbl_pedidoPrecio_H7.getText();
            preci_H7_Conv = Double.parseDouble(preci_H7);

            subPrecio_H7 = subPrecio_H7 + preci_H7_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_7.setDisable(true);

            subPrecio_H7 = 0;
            spi_H_7.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H7(MouseEvent event) {

        double spin_H7 = preci_H7_Conv;

        if (check_H7.isSelected()) {

            int preQty_H7;
            preQty_H7 = (Integer) spi_Hamburguesas_7.getValue();

            if (preQty_H7 > qty_H7) {

                qty_H7 = preQty_H7;

                subPrecio_H7 = spin_H7 * preQty_H7;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H7 <= qty_H7) {

                qty_H7 = preQty_H7;

                subPrecio_H7 = spin_H7 * preQty_H7;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    @FXML
    private void check_Hamburguesas_8(MouseEvent event) {

        if (check_H8.isSelected()) {
            spi_Hamburguesas_8.setDisable(false);
            preci_H8 = lbl_pedidoPrecio_H8.getText();
            preci_H8_Conv = Double.parseDouble(preci_H8);

            subPrecio_H8 = subPrecio_H8 + preci_H8_Conv;
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        } else {
            spi_Hamburguesas_8.setDisable(true);

            subPrecio_H8 = 0;
            spi_H_8.setValue(1);
            totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;
            lbl_falso.setText(String.valueOf(totalHamburguesas));

        }

        total();

    }

    @FXML
    private void Cantidad_H8(MouseEvent event) {

        double spin_H8 = preci_H8_Conv;

        if (check_H8.isSelected()) {

            int preQty_H8;
            preQty_H8 = (Integer) spi_Hamburguesas_8.getValue();

            if (preQty_H8 > qty_H8) {

                qty_H7 = preQty_H8;

                subPrecio_H7 = spin_H8 * preQty_H8;

                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            } else if (preQty_H8 <= qty_H8) {

                qty_H8 = preQty_H8;

                subPrecio_H8 = spin_H8 * preQty_H8;
                totalHamburguesas = subPrecio_H2 + subPrecio_H1 + subPrecio_H3 + subPrecio_H4 + subPrecio_H5 + subPrecio_H6 + subPrecio_H7 + subPrecio_H8;

            }

            lbl_falso.setText(String.valueOf(totalHamburguesas));
            total();
        }
        total();

    }

    //-------------- TERMINA EL PEDIDO DE LAS HAMBURGUESAS --------------------------------------------------
    //-------------- EMPIEZA EL PEDIDO DE LOS ENTRANTES --------------------------------------------------
    //------------ TOTAL DE GASTOS EN ENTRANTES -------------------------------------
    String preci_E1 = "", preci_E2 = "", preci_E3 = "", preci_E4 = "", preci_E5 = "", preci_E6 = "", preci_E7 = "", preci_E8 = "";
    public static double preci_E1_Conv, preci_E2_Conv, preci_E3_Conv, preci_E4_Conv, preci_E5_Conv, preci_E6_Conv, preci_E7_Conv, preci_E8_Conv;
    double subPrecio_E1 = 0, subPrecio_E2 = 0, subPrecio_E3 = 0, subPrecio_E4 = 0, subPrecio_E5 = 0, subPrecio_E6 = 0, subPrecio_E7 = 0, subPrecio_E8 = 0;
    int qty_E1 = 0, qty_E2 = 0, qty_E3 = 0, qty_E4 = 0, qty_E5 = 0, qty_E6 = 0, qty_E7 = 0, qty_E8 = 0;

    @FXML
    private void check_Entrantes_1(MouseEvent event) {

        if (check_E1.isSelected()) {
            spi_Entrantes_1.setDisable(false);
            preci_E1 = lbl_pedidoPrecio_E1.getText();
            preci_E1_Conv = Double.parseDouble(preci_E1);

            subPrecio_E1 = subPrecio_E1 + preci_E1_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_1.setDisable(true);

            subPrecio_E1 = 0;
            spi_E_1.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E1(MouseEvent event) {

        double spin_E1 = preci_E1_Conv;

        if (check_E1.isSelected()) {

            int preQty_E1;
            preQty_E1 = (Integer) spi_Entrantes_1.getValue();

            if (preQty_E1 > qty_E1) {

                qty_E1 = preQty_E1;

                subPrecio_E1 = spin_E1 * preQty_E1;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E1 <= qty_E1) {

                qty_E1 = preQty_E1;

                subPrecio_E1 = spin_E1 * preQty_E1;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_2(MouseEvent event) {

        if (check_E2.isSelected()) {
            spi_Entrantes_2.setDisable(false);
            preci_E2 = lbl_pedidoPrecio_E2.getText();
            preci_E2_Conv = Double.parseDouble(preci_E2);

            subPrecio_E2 = subPrecio_E2 + preci_E2_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_2.setDisable(true);

            subPrecio_E2 = 0;
            spi_E_2.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E2(MouseEvent event) {

        double spin_E2 = preci_E2_Conv;

        if (check_E2.isSelected()) {

            int preQty_E2;
            preQty_E2 = (Integer) spi_Entrantes_2.getValue();

            if (preQty_E2 > qty_E2) {

                qty_E2 = preQty_E2;

                subPrecio_E2 = spin_E2 * preQty_E2;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E2 <= qty_E2) {

                qty_E2 = preQty_E2;

                subPrecio_E2 = spin_E2 * preQty_E2;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_3(MouseEvent event) {

        if (check_E3.isSelected()) {
            spi_Entrantes_3.setDisable(false);
            preci_E3 = lbl_pedidoPrecio_E3.getText();
            preci_E3_Conv = Double.parseDouble(preci_E3);

            subPrecio_E3 = subPrecio_E3 + preci_E3_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_3.setDisable(true);

            subPrecio_E3 = 0;
            spi_E_3.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E3(MouseEvent event) {

        double spin_E3 = preci_E3_Conv;

        if (check_E3.isSelected()) {

            int preQty_E3;
            preQty_E3 = (Integer) spi_Entrantes_3.getValue();

            if (preQty_E3 > qty_E3) {

                qty_E3 = preQty_E3;

                subPrecio_E3 = spin_E3 * preQty_E3;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E3 <= qty_E3) {

                qty_E3 = preQty_E3;

                subPrecio_E3 = spin_E3 * preQty_E3;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_4(MouseEvent event) {

        if (check_E4.isSelected()) {
            spi_Entrantes_4.setDisable(false);
            preci_E4 = lbl_pedidoPrecio_E4.getText();
            preci_E4_Conv = Double.parseDouble(preci_E4);

            subPrecio_E4 = subPrecio_E4 + preci_E4_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_4.setDisable(true);

            subPrecio_E4 = 0;
            spi_E_4.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E4(MouseEvent event) {

        double spin_E4 = preci_E4_Conv;

        if (check_E4.isSelected()) {

            int preQty_E4;
            preQty_E4 = (Integer) spi_Entrantes_4.getValue();

            if (preQty_E4 > qty_E4) {

                qty_E4 = preQty_E4;

                subPrecio_E4 = spin_E4 * preQty_E4;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E4 <= qty_E4) {

                qty_E4 = preQty_E4;

                subPrecio_E4 = spin_E4 * preQty_E4;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_5(MouseEvent event) {

        if (check_E5.isSelected()) {
            spi_Entrantes_5.setDisable(false);
            preci_E5 = lbl_pedidoPrecio_E5.getText();
            preci_E5_Conv = Double.parseDouble(preci_E5);

            subPrecio_E5 = subPrecio_E5 + preci_E5_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_5.setDisable(true);

            subPrecio_E5 = 0;
            spi_E_5.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E5(MouseEvent event) {

        double spin_E5 = preci_E5_Conv;

        if (check_E5.isSelected()) {

            int preQty_E5;
            preQty_E5 = (Integer) spi_Entrantes_5.getValue();

            if (preQty_E5 > qty_E5) {

                qty_E5 = preQty_E5;

                subPrecio_E5 = spin_E5 * preQty_E5;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E5 <= qty_E5) {

                qty_E5 = preQty_E5;

                subPrecio_E5 = spin_E5 * preQty_E5;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_6(MouseEvent event) {

        if (check_E6.isSelected()) {
            spi_Entrantes_6.setDisable(false);
            preci_E6 = lbl_pedidoPrecio_E6.getText();
            preci_E6_Conv = Double.parseDouble(preci_E6);

            subPrecio_E6 = subPrecio_E6 + preci_E6_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_6.setDisable(true);

            subPrecio_E6 = 0;
            spi_E_6.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E6(MouseEvent event) {

        double spin_E6 = preci_E6_Conv;

        if (check_E6.isSelected()) {

            int preQty_E6;
            preQty_E6 = (Integer) spi_Entrantes_6.getValue();

            if (preQty_E6 > qty_E6) {

                qty_E6 = preQty_E6;

                subPrecio_E6 = spin_E6 * preQty_E6;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E6 <= qty_E6) {

                qty_E6 = preQty_E6;

                subPrecio_E6 = spin_E6 * preQty_E6;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_7(MouseEvent event) {

        if (check_E7.isSelected()) {
            spi_Entrantes_7.setDisable(false);
            preci_E7 = lbl_pedidoPrecio_E7.getText();
            preci_E7_Conv = Double.parseDouble(preci_E7);

            subPrecio_E7 = subPrecio_E7 + preci_E7_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_7.setDisable(true);

            subPrecio_E7 = 0;
            spi_E_7.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E7(MouseEvent event) {

        double spin_E7 = preci_E7_Conv;

        if (check_E7.isSelected()) {

            int preQty_E7;
            preQty_E7 = (Integer) spi_Entrantes_7.getValue();

            if (preQty_E7 > qty_E7) {

                qty_E7 = preQty_E7;

                subPrecio_E7 = spin_E7 * preQty_E7;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E7 <= qty_E7) {

                qty_E7 = preQty_E7;

                subPrecio_E7 = spin_E7 * preQty_E7;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    @FXML
    private void check_Entrantes_8(MouseEvent event) {

        if (check_E8.isSelected()) {
            spi_Entrantes_8.setDisable(false);
            preci_E8 = lbl_pedidoPrecio_E8.getText();
            preci_E8_Conv = Double.parseDouble(preci_E8);

            subPrecio_E8 = subPrecio_E8 + preci_E8_Conv;
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        } else {
            spi_Entrantes_8.setDisable(true);

            subPrecio_E8 = 0;
            spi_E_8.setValue(1);
            totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;
            lbl_falso.setText(String.valueOf(totalEntrantes));

        }

        total();

    }

    @FXML
    private void Cantidad_E8(MouseEvent event) {

        double spin_E8 = preci_E8_Conv;

        if (check_E8.isSelected()) {

            int preQty_E8;
            preQty_E8 = (Integer) spi_Entrantes_8.getValue();

            if (preQty_E8 > qty_E8) {

                qty_E8 = preQty_E8;

                subPrecio_E8 = spin_E8 * preQty_E8;

                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            } else if (preQty_E8 <= qty_E8) {

                qty_E8 = preQty_E8;

                subPrecio_E8 = spin_E8 * preQty_E8;
                totalEntrantes = subPrecio_E2 + subPrecio_E1 + subPrecio_E3 + subPrecio_E4 + subPrecio_E5 + subPrecio_E6 + subPrecio_E7 + subPrecio_E8;

            }

            lbl_falso.setText(String.valueOf(totalEntrantes));
            total();
        }
        total();

    }

    //-------------- TERMINA EL PEDIDO DE LOS ENTRANTES --------------------------------------------------
    //-------------- EMPIEZA EL PEDIDO DE LAS BEBIDAS --------------------------------------------------
    //------------ TOTAL DE GASTOS EN HAMBURGUESAS -------------------------------------
    String preci_B1 = "", preci_B2 = "", preci_B3 = "", preci_B4 = "", preci_B5 = "", preci_B6 = "", preci_B7 = "", preci_B8 = "";
    public static double preci_B1_Conv, preci_B2_Conv, preci_B3_Conv, preci_B4_Conv, preci_B5_Conv, preci_B6_Conv, preci_B7_Conv, preci_B8_Conv;
    double subPrecio_B1 = 0, subPrecio_B2 = 0, subPrecio_B3 = 0, subPrecio_B4 = 0, subPrecio_B5 = 0, subPrecio_B6 = 0, subPrecio_B7 = 0, subPrecio_B8 = 0;
    int qty_B1 = 0, qty_B2 = 0, qty_B3 = 0, qty_B4 = 0, qty_B5 = 0, qty_B6 = 0, qty_B7 = 0, qty_B8 = 0;

    @FXML
    private void check_Bebidas_1(MouseEvent event) {

        if (check_B1.isSelected()) {
            spi_Bebidas_1.setDisable(false);
            preci_B1 = lbl_pedidoPrecio_B1.getText();
            preci_B1_Conv = Double.parseDouble(preci_B1);

            subPrecio_B1 = subPrecio_B1 + preci_B1_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_1.setDisable(true);

            subPrecio_B1 = 0;
            spi_B_1.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B1(MouseEvent event) {

        double spin_B1 = preci_B1_Conv;

        if (check_B1.isSelected()) {

            int preQty_B1;
            preQty_B1 = (Integer) spi_Bebidas_1.getValue();

            if (preQty_B1 > qty_B1) {

                qty_B1 = preQty_B1;

                subPrecio_B1 = spin_B1 * preQty_B1;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B1 <= qty_B1) {

                qty_B1 = preQty_B1;

                subPrecio_B1 = spin_B1 * preQty_B1;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_2(MouseEvent event) {

        if (check_B2.isSelected()) {
            spi_Bebidas_2.setDisable(false);
            preci_B2 = lbl_pedidoPrecio_B2.getText();
            preci_B2_Conv = Double.parseDouble(preci_B2);

            subPrecio_B2 = subPrecio_B2 + preci_B2_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_2.setDisable(true);

            subPrecio_B2 = 0;
            spi_B_2.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B2(MouseEvent event) {

        double spin_B2 = preci_B2_Conv;

        if (check_B2.isSelected()) {

            int preQty_B2;
            preQty_B2 = (Integer) spi_Bebidas_2.getValue();

            if (preQty_B2 > qty_B2) {

                qty_B2 = preQty_B2;

                subPrecio_B2 = spin_B2 * preQty_B2;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B2 <= qty_B2) {

                qty_B2 = preQty_B2;

                subPrecio_B2 = spin_B2 * preQty_B2;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_3(MouseEvent event) {

        if (check_B3.isSelected()) {
            spi_Bebidas_3.setDisable(false);
            preci_B3 = lbl_pedidoPrecio_B3.getText();
            preci_B3_Conv = Double.parseDouble(preci_B3);

            subPrecio_B3 = subPrecio_B3 + preci_B3_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_3.setDisable(true);

            subPrecio_B3 = 0;
            spi_B_3.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B3(MouseEvent event) {

        double spin_B3 = preci_B3_Conv;

        if (check_B3.isSelected()) {

            int preQty_B3;
            preQty_B3 = (Integer) spi_Bebidas_3.getValue();

            if (preQty_B3 > qty_B3) {

                qty_B3 = preQty_B3;

                subPrecio_B3 = spin_B3 * preQty_B3;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B3 <= qty_B3) {

                qty_B3 = preQty_B3;

                subPrecio_B3 = spin_B3 * preQty_B3;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_4(MouseEvent event) {

        if (check_B4.isSelected()) {
            spi_Bebidas_4.setDisable(false);
            preci_B4 = lbl_pedidoPrecio_B4.getText();
            preci_B4_Conv = Double.parseDouble(preci_B4);

            subPrecio_B4 = subPrecio_B4 + preci_B4_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_4.setDisable(true);

            subPrecio_B4 = 0;
            spi_B_4.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B4(MouseEvent event) {

        double spin_B4 = preci_B4_Conv;

        if (check_B4.isSelected()) {

            int preQty_B4;
            preQty_B4 = (Integer) spi_Bebidas_4.getValue();

            if (preQty_B4 > qty_B4) {

                qty_B4 = preQty_B4;

                subPrecio_B4 = spin_B4 * preQty_B4;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B4 <= qty_B4) {

                qty_B4 = preQty_B4;

                subPrecio_B4 = spin_B4 * preQty_B4;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_5(MouseEvent event) {

        if (check_B5.isSelected()) {
            spi_Bebidas_5.setDisable(false);
            preci_B5 = lbl_pedidoPrecio_B5.getText();
            preci_B5_Conv = Double.parseDouble(preci_B5);

            subPrecio_B5 = subPrecio_B5 + preci_B5_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_5.setDisable(true);

            subPrecio_B5 = 0;
            spi_B_5.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B5(MouseEvent event) {

        double spin_B5 = preci_B5_Conv;

        if (check_B5.isSelected()) {

            int preQty_B5;
            preQty_B5 = (Integer) spi_Bebidas_5.getValue();

            if (preQty_B5 > qty_B5) {

                qty_B5 = preQty_B5;

                subPrecio_B5 = spin_B5 * preQty_B5;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B5 <= qty_B5) {

                qty_B5 = preQty_B5;

                subPrecio_B5 = spin_B5 * preQty_B5;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_6(MouseEvent event) {

        if (check_B6.isSelected()) {
            spi_Bebidas_6.setDisable(false);
            preci_B6 = lbl_pedidoPrecio_B6.getText();
            preci_B6_Conv = Double.parseDouble(preci_B6);

            subPrecio_B6 = subPrecio_B6 + preci_B6_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_6.setDisable(true);

            subPrecio_B6 = 0;
            spi_B_6.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B6(MouseEvent event) {

        double spin_B6 = preci_B6_Conv;

        if (check_B6.isSelected()) {

            int preQty_B6;
            preQty_B6 = (Integer) spi_Bebidas_6.getValue();

            if (preQty_B6 > qty_B6) {

                qty_B6 = preQty_B6;

                subPrecio_B6 = spin_B6 * preQty_B6;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B6 <= qty_B6) {

                qty_B6 = preQty_B6;

                subPrecio_B6 = spin_B6 * preQty_B6;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_7(MouseEvent event) {

        if (check_B7.isSelected()) {
            spi_Bebidas_7.setDisable(false);
            preci_B7 = lbl_pedidoPrecio_B7.getText();
            preci_B7_Conv = Double.parseDouble(preci_B7);

            subPrecio_B7 = subPrecio_B7 + preci_B7_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_7.setDisable(true);

            subPrecio_B7 = 0;
            spi_B_7.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B7(MouseEvent event) {

        double spin_B7 = preci_B7_Conv;

        if (check_B7.isSelected()) {

            int preQty_B7;
            preQty_B7 = (Integer) spi_Bebidas_7.getValue();

            if (preQty_B7 > qty_B7) {

                qty_B7 = preQty_B7;

                subPrecio_B7 = spin_B7 * preQty_B7;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B7 <= qty_B7) {

                qty_B7 = preQty_B7;

                subPrecio_B7 = spin_B7 * preQty_B7;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    @FXML
    private void check_Bebidas_8(MouseEvent event) {

        if (check_B8.isSelected()) {
            spi_Bebidas_8.setDisable(false);
            preci_B8 = lbl_pedidoPrecio_B8.getText();
            preci_B8_Conv = Double.parseDouble(preci_B8);

            subPrecio_B8 = subPrecio_B8 + preci_B8_Conv;
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        } else {
            spi_Bebidas_8.setDisable(true);

            subPrecio_B8 = 0;
            spi_B_8.setValue(1);
            totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;
            lbl_falso.setText(String.valueOf(totalBebidas));

        }

        total();

    }

    @FXML
    private void Cantidad_B8(MouseEvent event) {

        double spin_B8 = preci_B8_Conv;

        if (check_B8.isSelected()) {

            int preQty_B8;
            preQty_B8 = (Integer) spi_Bebidas_8.getValue();

            if (preQty_B8 > qty_B8) {

                qty_B8 = preQty_B8;

                subPrecio_B8 = spin_B8 * preQty_B8;

                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            } else if (preQty_B8 <= qty_B8) {

                qty_B8 = preQty_B8;

                subPrecio_B8 = spin_B8 * preQty_B8;
                totalBebidas = subPrecio_B2 + subPrecio_B1 + subPrecio_B3 + subPrecio_B4 + subPrecio_B5 + subPrecio_B6 + subPrecio_B7 + subPrecio_B8;

            }

            lbl_falso.setText(String.valueOf(totalBebidas));
            total();
        }
        total();

    }

    //-------------- TERMINA EL PEDIDO DE LAS BEBIDAS --------------------------------------------------
    //-------------- EMPIEZA EL PEDIDO DE LOS EXTRAS --------------------------------------------------
    //------------ TOTAL DE GASTOS EN EXTRAS -------------------------------------
    String preci_EX1 = "", preci_EX2 = "", preci_EX3 = "", preci_EX4 = "", preci_EX5 = "", preci_EX6 = "", preci_EX7 = "", preci_EX8 = "";
    public static double preci_EX1_Conv, preci_EX2_Conv, preci_EX3_Conv, preci_EX4_Conv, preci_EX5_Conv, preci_EX6_Conv, preci_EX7_Conv, preci_EX8_Conv;
    double subPrecio_EX1 = 0, subPrecio_EX2 = 0, subPrecio_EX3 = 0, subPrecio_EX4 = 0, subPrecio_EX5 = 0, subPrecio_EX6 = 0, subPrecio_EX7 = 0, subPrecio_EX8 = 0;
    int qty_EX1 = 0, qty_EX2 = 0, qty_EX3 = 0, qty_EX4 = 0, qty_EX5 = 0, qty_EX6 = 0, qty_EX7 = 0, qty_EX8 = 0;

    @FXML
    private void check_Extras_1(MouseEvent event) {

        if (check_EX1.isSelected()) {
            spi_Extras_1.setDisable(false);
            preci_EX1 = lbl_pedidoPrecio_EX1.getText();
            preci_EX1_Conv = Double.parseDouble(preci_EX1);

            subPrecio_EX1 = subPrecio_EX1 + preci_EX1_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_1.setDisable(true);

            subPrecio_EX1 = 0;
            spi_EX_1.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX1(MouseEvent event) {

        double spin_EX1 = preci_EX1_Conv;

        if (check_EX1.isSelected()) {

            int preQty_EX1;
            preQty_EX1 = (Integer) spi_Extras_1.getValue();

            if (preQty_EX1 > qty_EX1) {

                qty_EX1 = preQty_EX1;

                subPrecio_EX1 = spin_EX1 * preQty_EX1;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX1 <= qty_EX1) {

                qty_EX1 = preQty_EX1;

                subPrecio_EX1 = spin_EX1 * preQty_EX1;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_2(MouseEvent event) {

        if (check_EX2.isSelected()) {
            spi_Extras_2.setDisable(false);
            preci_EX2 = lbl_pedidoPrecio_EX2.getText();
            preci_EX2_Conv = Double.parseDouble(preci_EX2);

            subPrecio_EX2 = subPrecio_EX2 + preci_EX2_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_2.setDisable(true);

            subPrecio_EX2 = 0;
            spi_EX_2.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX2(MouseEvent event) {

        double spin_EX2 = preci_EX2_Conv;

        if (check_EX2.isSelected()) {

            int preQty_EX2;
            preQty_EX2 = (Integer) spi_Extras_2.getValue();

            if (preQty_EX2 > qty_EX2) {

                qty_EX2 = preQty_EX2;

                subPrecio_EX2 = spin_EX2 * preQty_EX2;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX2 <= qty_EX2) {

                qty_EX2 = preQty_EX2;

                subPrecio_EX2 = spin_EX2 * preQty_EX2;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_3(MouseEvent event) {

        if (check_EX3.isSelected()) {
            spi_Extras_3.setDisable(false);
            preci_EX3 = lbl_pedidoPrecio_EX3.getText();
            preci_EX3_Conv = Double.parseDouble(preci_EX3);

            subPrecio_EX3 = subPrecio_EX3 + preci_EX3_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_3.setDisable(true);

            subPrecio_EX3 = 0;
            spi_EX_3.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX3(MouseEvent event) {

        double spin_EX3 = preci_EX3_Conv;

        if (check_EX3.isSelected()) {

            int preQty_EX3;
            preQty_EX3 = (Integer) spi_Extras_3.getValue();

            if (preQty_EX3 > qty_EX3) {

                qty_EX3 = preQty_EX3;

                subPrecio_EX3 = spin_EX3 * preQty_EX3;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX3 <= qty_EX3) {

                qty_EX3 = preQty_EX3;

                subPrecio_EX3 = spin_EX3 * preQty_EX3;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_4(MouseEvent event) {

        if (check_EX4.isSelected()) {
            spi_Extras_4.setDisable(false);
            preci_EX4 = lbl_pedidoPrecio_EX4.getText();
            preci_EX4_Conv = Double.parseDouble(preci_EX4);

            subPrecio_EX4 = subPrecio_EX4 + preci_EX4_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_4.setDisable(true);

            subPrecio_EX4 = 0;
            spi_EX_4.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX4(MouseEvent event) {

        double spin_EX4 = preci_EX4_Conv;

        if (check_EX4.isSelected()) {

            int preQty_EX4;
            preQty_EX4 = (Integer) spi_Extras_4.getValue();

            if (preQty_EX4 > qty_EX4) {

                qty_EX4 = preQty_EX4;

                subPrecio_EX4 = spin_EX4 * preQty_EX4;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX4 <= qty_EX4) {

                qty_EX4 = preQty_EX4;

                subPrecio_EX4 = spin_EX4 * preQty_EX4;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_5(MouseEvent event) {

        if (check_EX5.isSelected()) {
            spi_Extras_5.setDisable(false);
            preci_EX5 = lbl_pedidoPrecio_EX5.getText();
            preci_EX5_Conv = Double.parseDouble(preci_EX5);

            subPrecio_EX5 = subPrecio_EX5 + preci_EX5_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_5.setDisable(true);

            subPrecio_EX5 = 0;
            spi_EX_5.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX5(MouseEvent event) {

        double spin_EX5 = preci_EX5_Conv;

        if (check_EX5.isSelected()) {

            int preQty_EX5;
            preQty_EX5 = (Integer) spi_Extras_5.getValue();

            if (preQty_EX5 > qty_EX5) {

                qty_EX5 = preQty_EX5;

                subPrecio_EX5 = spin_EX5 * preQty_EX5;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX5 <= qty_EX5) {

                qty_EX5 = preQty_EX5;

                subPrecio_EX5 = spin_EX5 * preQty_EX5;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_6(MouseEvent event) {

        if (check_EX6.isSelected()) {
            spi_Extras_6.setDisable(false);
            preci_EX6 = lbl_pedidoPrecio_EX6.getText();
            preci_EX6_Conv = Double.parseDouble(preci_EX6);

            subPrecio_EX6 = subPrecio_EX6 + preci_EX6_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_6.setDisable(true);

            subPrecio_EX6 = 0;
            spi_EX_6.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX6(MouseEvent event) {

        double spin_EX6 = preci_EX6_Conv;

        if (check_EX6.isSelected()) {

            int preQty_EX6;
            preQty_EX6 = (Integer) spi_Extras_6.getValue();

            if (preQty_EX6 > qty_EX6) {

                qty_EX6 = preQty_EX6;

                subPrecio_EX6 = spin_EX6 * preQty_EX6;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX6 <= qty_EX6) {

                qty_EX6 = preQty_EX6;

                subPrecio_EX6 = spin_EX6 * preQty_EX6;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_7(MouseEvent event) {

        if (check_EX7.isSelected()) {
            spi_Extras_7.setDisable(false);
            preci_EX7 = lbl_pedidoPrecio_EX7.getText();
            preci_EX7_Conv = Double.parseDouble(preci_EX7);

            subPrecio_EX7 = subPrecio_EX7 + preci_EX7_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_7.setDisable(true);

            subPrecio_EX7 = 0;
            spi_EX_7.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX7(MouseEvent event) {

        double spin_EX7 = preci_EX7_Conv;

        if (check_EX7.isSelected()) {

            int preQty_EX7;
            preQty_EX7 = (Integer) spi_Extras_7.getValue();

            if (preQty_EX7 > qty_EX7) {

                qty_EX7 = preQty_EX7;

                subPrecio_EX7 = spin_EX7 * preQty_EX7;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX7 <= qty_EX7) {

                qty_EX7 = preQty_EX7;

                subPrecio_EX7 = spin_EX7 * preQty_EX7;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    @FXML
    private void check_Extras_8(MouseEvent event) {

        if (check_EX8.isSelected()) {
            spi_Extras_8.setDisable(false);
            preci_EX8 = lbl_pedidoPrecio_EX8.getText();
            preci_EX8_Conv = Double.parseDouble(preci_EX8);

            subPrecio_EX8 = subPrecio_EX8 + preci_EX8_Conv;
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        } else {
            spi_Extras_8.setDisable(true);

            subPrecio_EX8 = 0;
            spi_EX_8.setValue(1);
            totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;
            lbl_falso.setText(String.valueOf(totalExtras));

        }

        total();

    }

    @FXML
    private void Cantidad_EX8(MouseEvent event) {

        double spin_EX8 = preci_EX8_Conv;

        if (check_EX8.isSelected()) {

            int preQty_EX8;
            preQty_EX8 = (Integer) spi_Extras_8.getValue();

            if (preQty_EX8 > qty_EX8) {

                qty_EX8 = preQty_EX8;

                subPrecio_EX8 = spin_EX8 * preQty_EX8;

                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            } else if (preQty_EX8 <= qty_EX8) {

                qty_EX8 = preQty_EX8;

                subPrecio_EX8 = spin_EX8 * preQty_EX8;
                totalExtras = subPrecio_EX2 + subPrecio_EX1 + subPrecio_EX3 + subPrecio_EX4 + subPrecio_EX5 + subPrecio_EX6 + subPrecio_EX7 + subPrecio_EX8;

            }

            lbl_falso.setText(String.valueOf(totalExtras));
            total();
        }
        total();

    }

    double total_double;
    public static String total_string = "";

    double total;
    double totalPizzas;
    double totalHamburguesas;
    double totalEntrantes;
    double totalBebidas;
    double totalExtras;

    public void total() {

        total = totalPizzas + totalHamburguesas + totalEntrantes + totalBebidas + totalExtras;
        total = Math.round(total * 100) / 100d;
        lbl_total_pagar.setText(String.valueOf(total));

    }

    String cantidadPagada = "";
    public static int numeroFacturaInt;
    @FXML
    private void Pagar(ActionEvent event) {

        double pagado;
        double vueltas;

        String nunFactura;
        // int numeroFacturaInt;

        cantidadPagada = txt_Cantidad_Pagada.getText();
        pagado = Integer.parseInt(cantidadPagada);

        nunFactura = txt_numero_Pedido.getText();
        numeroFacturaInt = Integer.parseInt(nunFactura);

        if (pagado > total) {

            vueltas = pagado - total;
            vueltas = Math.round(vueltas * 100) / 100d;
            lbl_Cambio.setText(String.valueOf(vueltas));

        } else {

            JOptionPane.showMessageDialog(null, "Te intentan engañar,\n la cantidad pagada es menor que el producto que se ha consumido.");
        }

        String fecha1;
        String fecha2;

        fecha1 = lbl_Fecha_Pedidos.getText();
        fecha2 = lbl_Fecha_Pedidos.getText();

        if (fecha1 == fecha2) {

            numeroFacturaInt++;
            txt_numero_Pedido.setText(String.valueOf(numeroFacturaInt));

        } else {
            numeroFacturaInt = 1;
        }

        
    }

    public PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    public void LimpiarFactura() {

        check_P1.setSelected(false);
        check_P2.setSelected(false);
        check_P3.setSelected(false);
        check_P4.setSelected(false);
        check_P5.setSelected(false);
        check_P6.setSelected(false);
        check_P7.setSelected(false);
        check_P8.setSelected(false);
        //---------------------------------
        check_H1.setSelected(false);
        check_H2.setSelected(false);
        check_H3.setSelected(false);
        check_H4.setSelected(false);
        check_H5.setSelected(false);
        check_H6.setSelected(false);
        check_H7.setSelected(false);
        check_H8.setSelected(false);
        //-----------------------------------
        check_E1.setSelected(false);
        check_E2.setSelected(false);
        check_E3.setSelected(false);
        check_E4.setSelected(false);
        check_E5.setSelected(false);
        check_E6.setSelected(false);
        check_E7.setSelected(false);
        check_E8.setSelected(false);
        //-------------------------------------
        check_B1.setSelected(false);
        check_B2.setSelected(false);
        check_B3.setSelected(false);
        check_B4.setSelected(false);
        check_B5.setSelected(false);
        check_B6.setSelected(false);
        check_B7.setSelected(false);
        check_B8.setSelected(false);
        //------------------------------------
        check_EX1.setSelected(false);
        check_EX2.setSelected(false);
        check_EX3.setSelected(false);
        check_EX4.setSelected(false);
        check_EX5.setSelected(false);
        check_EX6.setSelected(false);
        check_EX7.setSelected(false);
        check_EX8.setSelected(false);

        txt_Cliente_Pedidos.setText("");
        txt_Cantidad_Pagada.setText("");
        lbl_total_pagar.setText("");
        lbl_Cambio.setText("");

        spi_Pizzas_1.setDisable(true);
        spi_P_1.setValue(1);
        spi_Pizzas_2.setDisable(true);
        spi_P_2.setValue(1);
        spi_Pizzas_3.setDisable(true);
        spi_P_3.setValue(1);
        spi_Pizzas_4.setDisable(true);
        spi_P_4.setValue(1);
        spi_Pizzas_5.setDisable(true);
        spi_P_5.setValue(1);
        spi_Pizzas_6.setDisable(true);
        spi_P_6.setValue(1);
        spi_Pizzas_7.setDisable(true);
        spi_P_7.setValue(1);
        spi_Pizzas_8.setDisable(true);
        spi_P_8.setValue(1);

        spi_Hamburguesas_1.setDisable(true);
        spi_H_1.setValue(1);
        spi_Hamburguesas_2.setDisable(true);
        spi_H_2.setValue(1);
        spi_Hamburguesas_3.setDisable(true);
        spi_H_3.setValue(1);
        spi_Hamburguesas_4.setDisable(true);
        spi_H_4.setValue(1);
        spi_Hamburguesas_5.setDisable(true);
        spi_H_5.setValue(1);
        spi_Hamburguesas_6.setDisable(true);
        spi_H_6.setValue(1);
        spi_Hamburguesas_7.setDisable(true);
        spi_H_7.setValue(1);
        spi_Hamburguesas_8.setDisable(true);
        spi_H_8.setValue(1);

        spi_Entrantes_1.setDisable(true);
        spi_E_1.setValue(1);
        spi_Entrantes_2.setDisable(true);
        spi_E_2.setValue(1);
        spi_Entrantes_3.setDisable(true);
        spi_E_3.setValue(1);
        spi_Entrantes_4.setDisable(true);
        spi_E_4.setValue(1);
        spi_Entrantes_5.setDisable(true);
        spi_E_5.setValue(1);
        spi_Entrantes_6.setDisable(true);
        spi_E_6.setValue(1);
        spi_Entrantes_7.setDisable(true);
        spi_E_7.setValue(1);
        spi_Entrantes_8.setDisable(true);
        spi_E_8.setValue(1);

        spi_Bebidas_1.setDisable(true);
        spi_B_1.setValue(1);
        spi_Bebidas_2.setDisable(true);
        spi_B_2.setValue(1);
        spi_Bebidas_3.setDisable(true);
        spi_B_3.setValue(1);
        spi_Bebidas_4.setDisable(true);
        spi_B_4.setValue(1);
        spi_Bebidas_5.setDisable(true);
        spi_B_5.setValue(1);
        spi_Bebidas_6.setDisable(true);
        spi_B_6.setValue(1);
        spi_Bebidas_7.setDisable(true);
        spi_B_7.setValue(1);
        spi_Bebidas_8.setDisable(true);
        spi_B_8.setValue(1);

        spi_Extras_1.setDisable(true);
        spi_EX_1.setValue(1);
        spi_Extras_2.setDisable(true);
        spi_EX_2.setValue(1);
        spi_Extras_3.setDisable(true);
        spi_EX_3.setValue(1);
        spi_Extras_4.setDisable(true);
        spi_EX_4.setValue(1);
        spi_Extras_5.setDisable(true);
        spi_EX_5.setValue(1);
        spi_Extras_6.setDisable(true);
        spi_EX_6.setValue(1);
        spi_Extras_7.setDisable(true);
        spi_EX_7.setValue(1);
        spi_Extras_8.setDisable(true);
        spi_EX_8.setValue(1);

        total = 0;
        totalPizzas = 0;
        totalHamburguesas = 0;
        totalEntrantes = 0;
        totalBebidas = 0;
        totalExtras = 0;

        subPrecio_P2 = 0;
        subPrecio_P1 = 0;
        subPrecio_P3 = 0;
        subPrecio_P4 = 0;
        subPrecio_P5 = 0;
        subPrecio_P6 = 0;
        subPrecio_P7 = 0;
        subPrecio_P8 = 0;
        subPrecio_H1 = 0;
        subPrecio_H2 = 0;
        subPrecio_H3 = 0;
        subPrecio_H4 = 0;
        subPrecio_H5 = 0;
        subPrecio_H6 = 0;
        subPrecio_H7 = 0;
        subPrecio_H8 = 0;
        subPrecio_E1 = 0;
        subPrecio_E2 = 0;
        subPrecio_E3 = 0;
        subPrecio_E4 = 0;
        subPrecio_E5 = 0;
        subPrecio_E6 = 0;
        subPrecio_E7 = 0;
        subPrecio_E8 = 0;
        subPrecio_B2 = 0;
        subPrecio_B1 = 0;
        subPrecio_B3 = 0;
        subPrecio_B4 = 0;
        subPrecio_B5 = 0;
        subPrecio_B6 = 0;
        subPrecio_B7 = 0;
        subPrecio_B8 = 0;
        subPrecio_EX2 = 0;
        subPrecio_EX1 = 0;
        subPrecio_EX3 = 0;
        subPrecio_EX4 = 0;
        subPrecio_EX5 = 0;
        subPrecio_EX6 = 0;
        subPrecio_EX7 = 0;
        subPrecio_EX8 = 0;

    }

    @FXML
    private void Nuevo_Pedido(MouseEvent event) {
        
        java.util.Date fecha = new java.util.Date();
        DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        lbl_Fecha_Pedidos.setText(formatofecha.format(fecha));
        
        String fechaPedi = lbl_Fecha_Pedidos.getText();
        String numOrden = txt_numero_Pedido.getText();
        String cliente = txt_Cliente_Pedidos.getText();
        String total = lbl_total_pagar.getText();
        String canticadPagada = txt_Cantidad_Pagada.getText();
        String cambio = lbl_Cambio.getText();
        
        //----------CREAR PDF -------------------------------------------------------
        Document documento = new Document();

        try {
            int numFacPdf =  numeroFacturaInt - 1 ;
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Tiket"+numFacPdf+".pdf"));
            documento.open();
            
            Font fuente = new Font(Font.FontFamily.COURIER);
            fuente.setSize(24);
            
            
            Paragraph p = new Paragraph("TIKET FULL",fuente);
            p.getFont().setSize(12);
            p.getExtraParagraphSpace();
            p.getFont().setStyle(Font.BOLD);
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            
            Paragraph p1 = new Paragraph("p");
            p1.getFont().setSize(4);
            p1.getFont().setColor(BaseColor.WHITE);
            documento.add(p1);

            PdfPTable tabla1 = new PdfPTable(1);
            tabla1.setWidthPercentage(35);
            
            Paragraph columna1 = new Paragraph("FECHA: "+fechaPedi,fuente);
            columna1.getFont().setStyle(Font.BOLD);
            columna1.getFont().setSize(8);
            columna1.getFont().setColor(BaseColor.BLUE);
            tabla1.addCell(columna1);
            documento.add(tabla1);
            
            Paragraph p2 = new Paragraph("p");
            p2.getFont().setSize(4);
            p2.getFont().setColor(BaseColor.WHITE);
            documento.add(p2);
            
            PdfPTable tabla2 = new PdfPTable(1);
            tabla2.setWidthPercentage(35);
            
            Paragraph columna2 = new Paragraph("Nº PEDIDO: "+numFacPdf,fuente);
            columna2.getFont().setStyle(Font.BOLD);
            columna2.getFont().setSize(8);
            columna2.getFont().setColor(BaseColor.BLUE);
            tabla2.addCell(columna2);
            documento.add(tabla2);
            
            Paragraph p3 = new Paragraph("p");
            p3.getFont().setSize(4);
            p3.getFont().setColor(BaseColor.WHITE);
            documento.add(p3);
            
            PdfPTable tabla3 = new PdfPTable(1);
            tabla3.setWidthPercentage(35);
            
            Paragraph columna3 = new Paragraph("CLIENTE: "+cliente,fuente);
            columna3.getFont().setStyle(Font.BOLD);
            columna3.getFont().setSize(8);
            columna3.getFont().setColor(BaseColor.BLUE);
            tabla3.addCell(columna3);
            documento.add(tabla3);
            
            Paragraph p4 = new Paragraph("p");
            p4.getFont().setSize(4);
            p4.getFont().setColor(BaseColor.WHITE);
            documento.add(p4);
            
            PdfPTable tabla4 = new PdfPTable(1);
            tabla4.setWidthPercentage(35);
            
            Paragraph columna4 = new Paragraph("TOTAL: "+total,fuente);
            columna4.getFont().setStyle(Font.BOLD);
            columna4.getFont().setSize(8);
            columna4.getFont().setColor(BaseColor.BLUE);
            tabla4.addCell(columna4);
            documento.add(tabla4);
            
            Paragraph p5 = new Paragraph("p");
            p5.getFont().setSize(4);
            p5.getFont().setColor(BaseColor.WHITE);
            documento.add(p5);
            
            PdfPTable tabla5 = new PdfPTable(1);
            tabla5.setWidthPercentage(35);
            
            Paragraph columna5 = new Paragraph("CANTIDAD PAGADA: "+canticadPagada,fuente);
            columna5.getFont().setStyle(Font.BOLD);
            columna5.getFont().setSize(8);
            columna5.getFont().setColor(BaseColor.BLUE);
            tabla5.addCell(columna5);
            documento.add(tabla5);
            
            Paragraph p6 = new Paragraph("p");
            p6.getFont().setSize(4);
            p6.getFont().setColor(BaseColor.WHITE);
            documento.add(p6);
            
            PdfPTable tabla6 = new PdfPTable(1);
            tabla6.setWidthPercentage(35);
            
            Paragraph columna6 = new Paragraph("CAMBIO: "+cambio,fuente);
            columna6.getFont().setStyle(Font.BOLD);
            columna6.getFont().setSize(8);
            columna6.getFont().setColor(BaseColor.BLUE);
            tabla6.addCell(columna6);
            documento.add(tabla6);
            
            Paragraph p7 = new Paragraph("p");
            p7.getFont().setSize(4);
            p7.getFont().setColor(BaseColor.WHITE);
            documento.add(p7);
            
            Paragraph p8 = new Paragraph("Gracias por su visita");
            p8.getFont().setSize(8);
            p8.setAlignment(Element.ALIGN_CENTER);
            p8.getFont().setColor(BaseColor.DARK_GRAY);
            documento.add(p8);
            
            documento.close();
            JOptionPane.showMessageDialog(null, "El informe se creó con éxito.");

        } catch (Exception e) {

        }

        //----------FIN DEL PDF -----------------------------------------------------
        
        
        
        
        
        
        
        
        

        LimpiarFactura();

    }

}
