/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import modelo.Citas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class ForGraphics {
        public int Cuenta (String sql){
        int i=0;
        ResultSet rs;
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.last();
                i=rs.getInt(1);
        }
        catch (SQLException e){
            //System.out.println("Errorsito aqui n.n  (¬_¬) / me lleva la verga ");
            e.printStackTrace();           
        }
        return i;
    }
}
