/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Abraham
 */
public class Metodos {
    ResultSet rs = null;
    private Statement stm;
    Connection conexion = ConexionBD.getConnection();
     public boolean ejecutarInstruccion(String sql) {
		try {
			stm = conexion.createStatement();
			int ejecucion;
			ejecucion = stm.executeUpdate(sql);
                        if (ejecucion==1){
                            System.out.println("SE EJECUTO LA INSTRUCCION!!!!!");
                        }else{
                    System.out.println("NO SE EJECUTO LA PINCHE INSTRUCCION!!!!!");
                }
			return ejecucion==1?true:false;
		} catch (SQLException e) {
                    System.out.println("NO SE EJECUTO LA PINCHE INSTRUCCION!!!!!");
			System.out.println(e);
			return false;
		}
	}
	
	//Metodo para SQL (Consultas)
	public ResultSet ejecutarConsultaRegistros(String sql) {
		
		try {
			stm = conexion.createStatement();
			rs = stm.executeQuery(sql);
                        System.out.println("SE EJECUTO LACONSULTA!!!!!");
		} catch (SQLException e) {
			System.out.println("No se puedo ejecutar la consulta");
		}
		return rs;
	}
        
        
         public static void main(String[] args) {  
    }
    
}
