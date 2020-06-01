/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import modelo.Doctor;
import modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Abraham
 */
public class DoctorDAO {
   private String sql="";
      Metodos c=new Metodos();
       public boolean agregaDoctor(Doctor d){
        boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO [dbo].[Doctor]\n" +
"           ([Nombre]\n" +
"           ,[Apellido1]\n" +
"           ,[Apellido2]\n" +
"           ,[Genero]\n" +
"           ,[Especialidad]\n" +
"           ,[Consultorio]\n" +
"           ,[Cedula_Prof]\n" +
"           ,[Id_Depto])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?)")) {
                pstm.setString( 1, d.getNombre());
                pstm.setString(2, d.getAp1());
                pstm.setString(3, d.getAp2());
                pstm.setString(4, d.getGenero());
                pstm.setString(5, d.getEspecializacion());
                pstm.setInt(6, d.getConsultorio());
                pstm.setString(7, d.getCedula());
                pstm.setInt(8, d.getDepartamento());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaDoctor(Doctor d){
          boolean actualizado;
          String sql = "UPDATE [dbo].[Doctor] SET [Nombre] = ? ,[Apellido1] = ?,[Apellido2] = ? ,[Genero] = ? ,[Especialidad] = ? ,[Consultorio] = ? ,[Cedula_Prof] = ? ,[Id_Depto] = ?" +
" WHERE Id_doc = ?";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
             pstm.setString( 1, d.getNombre());
                pstm.setString(2, d.getAp1());
                pstm.setString(3, d.getAp2());
                pstm.setString(4, d.getGenero());
                pstm.setString(5, d.getEspecializacion());
                pstm.setInt(6, d.getConsultorio());
                pstm.setString(7, d.getCedula());
                pstm.setInt(8, d.getDepartamento());
                pstm.setInt(9, d.getIdDoctor());
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
        sql = "DELETE FROM "+table+" WHERE "+filtro+" = '"+clave+"';";
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
      
       public Doctor buscaDoctor(String filtro, String clave){
        Doctor d = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM doctor WHERE "+filtro+" = '"+clave+"';";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while(rs.next()){
                d = new Doctor();
                d.setIdDoctor(rs.getInt(1));
                d.setNombre(rs.getString(2));
                d.setAp1(rs.getString(3));
                 d.setAp2(rs.getString(4));
                  d.setGenero(rs.getString(5));
                   d.setEspecializacion(rs.getString(6));
                   d.setConsultorio(rs.getInt(7));
                   d.setCedula(rs.getString(8));
                   d.setDepartamento(rs.getInt(9));
            }
                preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        
        return d;
    }  
       public static void main(String args[]) {
            DoctorDAO p = new DoctorDAO();
            
            Doctor d = new Doctor(1,"Carla","Balsasa","Vorneo","Ginecologa", 7 , 5,"Mujer","12345678");
            
            //System.out.println(p.ModificaDoctor(d));
            p.buscaDoctor("Nombre", "Carla");
            System.out.println(p);
        }
}
