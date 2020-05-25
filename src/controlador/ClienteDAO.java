/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cliente;
import conexion.ConexionBD;
import java.sql.ResultSet;

/**
 *
 * @author Abraham
 */
public class ClienteDAO {
    private  String sql="";
    public boolean registraCliente(Cliente c){
     
      boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO [Hotel].[dbo].[CLIENTE] VALUES ('?','?','?','?','?','?',?)")) {
                pstm.setString(1,c.getNombre());
                pstm.setString(2, c.getAp1());
                pstm.setString(3,c.getAp2());
                pstm.setString(4, c.getTel());
                pstm.setString(5, c.getEstado());
                pstm.setString(6, c.getGenero());
                pstm.setInt(7, c.getPago());
                pstm.executeUpdate();
                finalizo = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR" ,
                    "ERROR no se pudo registrar",JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
            finalizo = false;
        }
        return finalizo;
    }
    
    public boolean ModificaCliente(Cliente c){
          boolean actualizado;     
          String sql = "BEGIN TRAN \n UPDATE Cliente SET " +
                  " Nombre = ? , " +
                  " Apellido1 = ? ,  " +
                  " Apellido2 = ? , " +
                  " Telefono = ? , " +
                  " Estado = ? , " +
                  " Genero= ? , " +
                  " Modo_Pago = ? , " +
                  " WHERE  Id_Cliente=?"+
                  "; \n COMMIT TRAN";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
                pstm.setString(1,c.getNombre());
                pstm.setString(2,c.getAp1());
                pstm.setString(3,c.getAp2());
                pstm.setString(4,c.getTel());
                pstm.setString(5,c.getEstado());
                pstm.setString(6,c.getGenero());
                pstm.setInt(7,c.getPago());
                pstm.setInt(8,c.getIdCliente());

              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;                   
    }
    
         public Cliente buscaCita(String filtro, String clave){
        Cliente c = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM Cliente WHERE "+filtro+" = '"+clave+"';";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.last();


                c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setAp1(rs.getString(3));
                c.setAp2(rs.getString(4));
                c.setTel(rs.getString(5));
                c.setEstado(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setPago(rs.getInt(8));

        }
        catch (SQLException e){
            //System.out.println("Errorsito aqui   \(¬_¬)/ me lleva la verga ");
            e.printStackTrace();           
        }
        return c;
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
    
}
