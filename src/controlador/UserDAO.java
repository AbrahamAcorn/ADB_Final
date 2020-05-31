/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class UserDAO {
    public UserDAO(){
    }
    public boolean addUser(String user, String contra){
        boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO usuarios(`user`, `contra`) VALUES (?,?)")) {
                pstm.setString( 1, user);
                pstm.setString(2, contra);
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
    public boolean busca(String user, String contra){
        String c="";
        String u="";
        ResultSet rs;
        String sql="Select * from Usuarios WHERE user = '"+user+"' and  contra ='"+contra+"';";
        
        try {
            try (PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql)) {
                rs = preparedStatement.executeQuery();
                rs.last();
                u=rs.getString(1);
                c=rs.getString(2);
                return true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}














