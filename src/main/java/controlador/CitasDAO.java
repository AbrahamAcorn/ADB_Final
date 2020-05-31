/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import modelo.Citas;
import modelo.Paciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham
 */
public class CitasDAO {
      private String sql="";
      Metodos c=new Metodos();
       public boolean generaCita(Citas c){
        boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO [dbo].[Citas]  ([Paciente] ,[Doctor] ,[Fecha],[Hora]) VALUES (?,?,?,?)")) {
                pstm.setInt(1,c.getPaciente());
                pstm.setInt(2, c.getDoctor());
                pstm.setDate(3,java.sql.Date.valueOf(c.getFecha()));
                pstm.setString(4,c.getHora());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR" ,
                    "No se pudo registrar",JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaCita(Citas c){
          boolean actualizado;
          String sql = "UPDATE cita SET " +
                  " fecha = ? , " +
                  " hora = ? " +
                  " WHERE paciente =  ?  and doctor =  ? ;";// and doctor= ?;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
                pstm.setDate(1, java.sql.Date.valueOf(c.getFecha()));
                //System.out.println("fechita:-- "+c.getFecha());
                pstm.setString(2,c.getHora());
                //System.out.println("hora:-- "+c.getHora());
                pstm.setInt(3,c.getPaciente());
                //System.out.println("paciente:-- "+c.getPaciente());
                pstm.setInt(4,c.getDoctor());
                //System.out.println("doctor:-- "+c.getDoctor());
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
     
      public boolean Elimina(String filtro, String clave,String table){
        sql = "DELETE FROM "+table+" WHERE "+filtro+ " = '"+clave+"';";
           boolean eliminado;
	        try {
	            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
	            //preparedStatement.execute();
	            preparedStatement.executeUpdate();
	            eliminado = true;
	            preparedStatement.close();
	        }catch (SQLException e){
	            e.printStackTrace();
	            eliminado = false;
	        }
	        return eliminado;
    }
      
       public Citas buscaCita(String filtro, String clave){
        Citas c = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM Citas WHERE ? = ?";
        try {
            PreparedStatement ps = ConexionBD.getConnection().prepareStatement(sql);
            ps.setString(1, filtro);
            ps.setInt(2, Integer.parseInt(clave));
            rs = ps.executeQuery();
          
            while(rs.next()){
                c = new Citas();
                c.setPaciente(rs.getInt(1));
                c.setDoctor(rs.getInt(2));
                c.setFecha(rs.getDate(3).toString());
                c.setHora(rs.getString(4));
            }
        }
        catch (SQLException e){
            //System.out.println("Errorsito aqui n.n  (¬_¬) / me lleva la verga ");
            e.printStackTrace();   
             System.out.println("No hay registros u.u");
        }
        return c;
    }
       public static void main(String args[]) {
            CitasDAO p = new CitasDAO();
            
            Citas c = new Citas(1,1,"2019-12-12","11:45:AM");
            p.generaCita(c);
           // System.out.println(p.buscaCita();
        }
}
