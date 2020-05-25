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
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Estancia;

/**
 *
 * @author Abraham
 */
public class EstanciaDAO {
    private  String sql="";
    public boolean registraEstancia(Estancia es){
      boolean finalizo;
        try {
            try (PreparedStatement pstm = ConexionBD.getConnection().prepareStatement
                ("INSERT INTO [Hotel].[dbo].[ESTANCIA] VALUES ('?','?','?','?',?)")) {
                pstm.setInt(1,es.getIdCliente());
                pstm.setString(2,es.getEntrada());
                pstm.setString(3,es.getSalida());
                pstm.setInt(4,es.getModoPago());
                pstm.setDouble(5,es.getCuenta());
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
    
    public boolean ModificaEstancia(Estancia es){
          boolean actualizado;     

          String sql = "BEGIN TRAN \n UPDATE Estancia SET " +
                  " Id_Cliente = ? , " +
                  " Entrada = ? ,  " +
                  " Salida = ? , " +
                  " Id_Modo_Pago = ? , " +
                  " Cuenta = ? , " +
                  " WHERE  Id_Estancia=?"+
                  "; \n COMMIT TRAN";
          try {
              PreparedStatement pstm = ConexionBD.getConnection().prepareStatement(sql);
                pstm.setInt(1,es.getIdCliente());
                pstm.setString(2,es.getEntrada());
                pstm.setString(3,es.getSalida());
                pstm.setInt(4,es.getModoPago());
                pstm.setDouble(5,es.getCuenta());
              pstm.executeUpdate();
              actualizado = true;
              pstm.close();
          }catch (SQLException e){
              e.printStackTrace();
              actualizado = false;
          }
          return actualizado;                   
    }
    
         public Estancia buscaEstancia(String filtro, String clave){
        Estancia c = null;
        ResultSet rs;
        sql="";
        sql="SELECT * FROM Estancia WHERE "+filtro+" = '"+clave+"';";
        try {
            PreparedStatement preparedStatement = ConexionBD.getConnection().prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.last();
                c = new Estancia();
                c.setIdEstancia(rs.getInt(1));
                c.setIdCliente(rs.getInt(2));
                c.setEntrada(rs.getString(3));
                c.setSalida(rs.getString(4));
                c.setModoPago(rs.getInt(5));
                c.setCuenta(rs.getDouble(6));    
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

    