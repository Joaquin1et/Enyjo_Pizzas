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
public class Entrantes {
    
    private StringProperty Id;
    private StringProperty Nombre;
    private StringProperty Ingredientes;
    private StringProperty Precio;
    private StringProperty Fecha;
    private StringProperty Imagen;
    
    public Entrantes(String Id, String Nombre, String Ingredientes, String Precio, String Fecha, String Imagen) {
        this.Id = new SimpleStringProperty(Id);
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Ingredientes = new SimpleStringProperty(Ingredientes);
        this.Precio = new SimpleStringProperty(Precio);
        this.Fecha = new SimpleStringProperty(Fecha);
        this.Imagen = new SimpleStringProperty(Imagen);
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String Id) {
        this.Id = new SimpleStringProperty(Id);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String Nombre) {
        this.Nombre = new SimpleStringProperty(Nombre);
    }

    public String getIngredientes() {
        return Ingredientes.get();
    }

    public void setIngredientes(String Ingredientes) {
        this.Ingredientes = new SimpleStringProperty(Ingredientes);
    }

    public String getPrecio() {
        return Precio.get();
    }

    public void setPrecio(String Precio) {
        this.Precio = new SimpleStringProperty(Precio);
    }

    public String getFecha() {
        return Fecha.get();
    }

    public void setFecha(String Fecha) {
        this.Fecha = new SimpleStringProperty(Fecha);
    }

    public String getImagen() {
        return Imagen.get();
    }

    public void setImagen(String Imagen) {
        this.Imagen = new SimpleStringProperty(Imagen);
    }
    
    public static void llenarInformacionEntrantes(Connection conectar, ObservableList<Entrantes> lista){
        
        try {
            Statement instruccion = conectar.createStatement();
            ResultSet resultado = instruccion.executeQuery("select id, nombre, descripcion, precio, fecha, images  from hamburguesas where claseproducto like'Entrantes y Postres'");
            
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
                        new Entrantes(
                                resultado.getString("id"),
                                resultado.getString("nombre"),
                                resultado.getString("Descripcion"),
                                resultado.getString("Precio"),
                                resultado.getString("fecha"),
                                resultado.getString("images")
                                
                                //resultado.getBlob();
                                
                                //Blob blob = resultado.getBlob("images")
                                        
                                     
                        
                        )
                );
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Hamburguesas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("El metodo llenar informacion ha fallado.");
        }
        
    }
    
    
    
}
