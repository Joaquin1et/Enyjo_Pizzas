package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {
    public static Connection conectar(){
        Connection con = null;
        try {
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            Class.forName("org.hsqldb.jdbcDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\joaqu\\Documents\\NetBeansProjects\\EnyjoPizza\\base\\enyjopizza","tito","");
            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/enyjopizza");
            
        } catch (Exception ex) {
            System.out.println("Error no entra en la base de datos"+ex);
        }
        return con;
        
    }
    
}
