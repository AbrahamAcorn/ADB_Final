package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private ConexionBD(){
 
 String url = "jdbc:sqlserver://DESKTOP-27K6QM8: 1433;databaseName=HOTEL";
 String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 String usuario = "pepe";
 String password = "pepe";
  
 try{ 
     Class.forName(driver);
     conn = DriverManager.getConnection(url, usuario, password);
     System.out.println("Se conecto ");
 }
 catch(ClassNotFoundException | SQLException e){
     System.out.println("no conecto OTRA PUTA VEZ ¬_¬");
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
        Connection conexion = ConexionBD.getConnection();
    }
    
}