package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionBD {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private ConexionBD(){
 /*
 String url = "jdbc:sqlserver://: 1433;databaseName=Hospital";
 String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 String usuario = "acorn";
 String password = "WYRYKUTa2013'";
 */
 try{ 			// get connection
String full="jdbc:sqlserver://azurserv.database.windows.net:1433;database=Hospital;user=acorn@azurserv;password=WYRYKUTa2013';encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";	
 conn = DriverManager.getConnection(full);
     //Class.forName(driver);
     //conn = DriverManager.getConnection(url, usuario, password);
     System.out.println("Se conecto ");
 }
 catch(SQLException e){
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