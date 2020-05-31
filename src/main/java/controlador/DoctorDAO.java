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
                ("INSERT INTO Doctor (`Nombre`, `Ap1`, `Ap2`, `Especializacion`, "
                        + "`Consultorio`, `Departamento`, `Genero`) VALUES (?,?,?,?,?,?,?);")) {
                pstm.setString( 1, d.getNombre());
                pstm.setString(2, d.getAp1());
                pstm.setString(3, d.getAp2());
                pstm.setString(4, d.getEspecializacion());
                pstm.setInt(5, d.getConsultorio());
                pstm.setInt(6, d.getDepartamento());
                pstm.setString(7, d.getGenero());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
     public boolean ModificaDoctor(Doctor p){
          boolean actualizado;
          String sql = "UPDATE Doctor SET " +
                  " Nombre = ? , " +
                  " Ap1 = ? , " +
                  " Ap2 = ? , " +
                  " Genero = ?, " +
                  " Especializacion= ? , " +
                  " Consultorio = ? , " +
                  " Departamento = ? " +
                  "WHERE IdDoctor = ? ;";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
              pstm.setString( 1,p.getNombre());
              pstm.setString(2, p.getAp1());
              pstm.setString(3,p.getAp2());
              pstm.setString(4, p.getEspecializacion());
              pstm.setInt(5,p.getConsultorio());
              pstm.setInt(6, p.getDepartamento());
              pstm.setString(7,p.getGenero());
              pstm.setInt(8, p.getIdDoctor());
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
        sql="SELECT * FROM doctor "+filtro+" = '"+clave+"';";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            rs.last();
                d = new Doctor();
         
                preparedStatement.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        
        return d;
    }  
       public static void main(String args[]) {
            DoctorDAO p = new DoctorDAO();
            
            Doctor d = new Doctor(1,"Carla","Bals","Vorneo","Ginecologa", 6 , 7,"Mujer");
            
            System.out.println(p.agregaDoctor(d));
        }
}
