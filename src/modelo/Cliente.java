/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Abraham
 */
public class Cliente {
    private int idCliente; 
  private String Nombre; 
  private String Ap2; 
  private String Ap1; 
  private String tel;
  private String nacion;
  private String genero;
  private int pago;

    public Cliente(int idCliente, String Nombre, String Ap2, String Ap1, String tel, String Estado, String genero, int pago) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Ap2 = Ap2;
        this.Ap1 = Ap1;
        this.tel = tel;
        this.nacion = Estado;
        this.genero = genero;
        this.pago = pago;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAp2() {
        return Ap2;
    }

    public void setAp2(String Ap2) {
        this.Ap2 = Ap2;
    }

    public String getAp1() {
        return Ap1;
    }

    public void setAp1(String Ap1) {
        this.Ap1 = Ap1;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
    
    

}
