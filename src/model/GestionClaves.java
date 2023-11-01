package model;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * @author Joaquín
 */
public class GestionClaves {
    
    private StringProperty Nombre;
    
    private StringProperty Password;
    
    public GestionClaves(String Nombre, String Password){
        
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Password = new SimpleStringProperty(Password);
        
        
        
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String Nombre) {
        this.Nombre = new SimpleStringProperty(Nombre);
    }

    public String getPassword() {
        return Password.get();
    }

    public void setPassword(String Password) {
        this.Password = new SimpleStringProperty(Password);
    }
    
    
    public static void llenarInformacionGesClaves(Connection conectar, ObservableList<GestionClaves> lista){
        
        try {
            Statement instruccion = conectar.createStatement();
            ResultSet resultado = instruccion.executeQuery("select  nombre, password  from administradores ");
            
            BufferedImage buffimg = null;
            
            while(resultado.next()){
                
                /*Blob blob = resultado.getBlob("images");
                InputStream is = blob.getBinaryStream();*/
                /*try {
                    buffimg = ImageIO.read(is);
                } catch (IOException ex) {
                    Logger.getLogger(Hamburguesas.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                lista.add(
                        new GestionClaves(
                                resultado.getString("nombre"),
                                resultado.getString("password")
                                
                                
                                //resultado.getBlob();
                                
                                //Blob blob = resultado.getBlob("images")
                                        
                                     
                        
                        )
                );
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Hamburguesas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("El método llenar información ha fallado.");
        }
        
    }
    
}
