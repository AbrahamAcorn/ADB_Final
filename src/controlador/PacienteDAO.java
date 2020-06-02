/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham
 */
public class PacienteDAO {
    
    private String sql="";
    Metodos c=new Metodos();

    public PacienteDAO() {}
    
    public boolean agregaPaciente(Paciente p){
        boolean finalizo;
        String sql2=" INSERT INTO [dbo].[Paciente] ([Nombre] ,[PrimAP]  ,[SegAp], [Genero],[Calle] ,[Num] ,[Colonia]"+
           ",[Tel] ,[Estado],[Id_Habitacion]) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql2)) {
                pstm.setString( 1, p.getNombre());
                pstm.setString(2, p.getPrimAp());
                pstm.setString(3, p.getSegAp());
                pstm.setString(4, p.getGenero());
                pstm.setString(5, p.getCalle());
                pstm.setInt(6, p.getNum());
                pstm.setString(7, p.getColonia());
                pstm.setString(8,p.getTelefono());
                pstm.setString(9, p.getEstado());
                pstm.setInt(10, p.getHabitacion());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR" ,
                    "No se pudo registrar",JOptionPane.ERROR_MESSAGE);
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaPaciente(Paciente p){
          boolean actualizado;
        String sql=  "UPDATE [dbo].[Paciente]"+
                "SET [Nombre] = ?"+
                " ,[PrimAP] =?"+ 
                ",[SegAp] =?"+
                ",[Genero] =?"+
                ",[Calle] =?"+
                ",[Num] =?"+
                ",[Colonia]=?"+
                ",[Tel] = ?"+
                ",[Estado] =? "+
                ",[Id_Habitacion] =?"+ 
                " WHERE Id_Pac = ?";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setString( 1, p.getNombre());
              pstm.setString(2,p.getPrimAp());
              pstm.setString(3, p.getSegAp());
              pstm.setString(4,p.getGenero());
              pstm.setString(5,p.getCalle());
              pstm.setInt(6, p.getNum());
              pstm.setString(7, p.getColonia());
              pstm.setString(8, p.getTelefono());
              pstm.setString(9, p.getEstado());
              pstm.setInt(10, p.getHabitacion());
              pstm.setInt(11, p.getIdPaciente());
              pstm.executeUpdate();
              pstm.execute();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
              System.out.println("(¬_¬) / me lleva la verga version 2");
          }
          return actualizado;
    }
     
      public boolean Elimina(String filtro, String clave,String table){
        sql = "DELETE FROM "+table+" WHERE  "+filtro+" = "+clave;
           boolean eliminado;
	try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.execute();
	            eliminado = true;
	            preparedStatement.close();

	        }catch (SQLException e){
	            e.printStackTrace();
	            eliminado = false;
	        }

	        return eliminado;
        
    }
      
       public Paciente buscaPaciente(String columna, String clave){
        Paciente p = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM Paciente WHERE  "+columna+" = '"+""+clave+"'";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                    p = new Paciente();
                p.setIdPaciente(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimAp(rs.getString(3));
                p.setSegAp(rs.getString(4));
                p.setGenero(rs.getString(5));
                p.setCalle(rs.getString(6));
                p.setNum(rs.getInt(7));
                p.setColonia(rs.getString(8)); 
                p.setTelefono(rs.getString(9));
                p.setEstado(rs.getString(10));
                p.setHabitacion(rs.getInt(11)); 
        }
                preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.print("No encontro ni vergas");

        }
        
        return p;
    }
        public boolean CitaPaciente(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'Citado' " +
                  " WHERE id_Paciente = ? ;";
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
        
        public boolean QuitaCita(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'De Alta' " +
                  " WHERE idPaciente = ? ;";
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
     
        public boolean DarAlta(int id){
          boolean actualizado;
          String sql = "UPDATE Paciente SET " +
                  " Estado = 'De Alta' " +
                  " WHERE id_Pac = ? ;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.executeUpdate();
              pstm.execute();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;
    }
        public static void main(String args[]) {
            PacienteDAO p = new PacienteDAO();
            
            Paciente n = new Paciente(1,"Ariana", "perez", "Almaza", "Limon", "cutre", 24, "123-345-3456", "De Alta", 3, "Mujer");
            System.out.println(p.buscaPaciente("id_pac", "1"));
            //p.agregaPaciente(n);
            //int idPaciente, String Nombre, String PrimAp, String SegAp, String Colonia, String Calle, int num, String telefono, String Estado, int habitacion, String genero
        }
}
