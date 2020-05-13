package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private ConexionBD(){
 
 String url = "jdbc:mysql://localhost/hospital?useTimezone=true&serverTimezone=UTC";
 String driver = "com.mysql.jdbc.Driver";
 String usuario = "Abraham";
 String password = "pepe";
  
 try{ 
     Class.forName(driver);
     conn = DriverManager.getConnection(url, usuario, password);
     //System.out.println("Se conecto OTRA PUTA VEZ ¬_¬");
 }
 catch(ClassNotFoundException | SQLException e){
     System.out.println("no conecto");
     e.printStackTrace();
 }
    } // Fin constructor
 
    // Métodos
    public static Connection getConnection(){
  
 if (conn == null){
     new ConexionBD();
 }
  
 return conn;
    } // Fin getConnection
    
    public static void main(String[] args) {
        //Connection conexion = ConexionBD.getConnection();
    }
    
}