/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class HabitacionDAO {
    public boolean liberaHabitacion(int id){
          boolean actualizado;
          String sql = "UPDATE habitacion SET " +
                  " Estado = Libre " +
                  " WHERE idHabitacion = ?;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
    
    public boolean OcupaHabitacion(int id){
          boolean actualizado;
          String sql = "UPDATE habitacion SET " +
                  " Estado = ocupado " +
                  " WHERE idHabitacion = ?;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
}
