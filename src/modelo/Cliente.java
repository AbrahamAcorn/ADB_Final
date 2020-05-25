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
    private String Ap1;
    private String Ap2;
    private String Tel;
    private String Estado;
    private String Genero;
    private int pago;

    public Cliente() {
    }

    public Cliente(int idCliente, String Nombre, String Ap1, String Ap2, String Tel, String Estado, String Genero, int pago) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Ap1 = Ap1;
        this.Ap2 = Ap2;
        this.Tel = Tel;
        this.Estado = Estado;
        this.Genero = Genero;
        this.pago = pago;
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

    public String getAp1() {
        return Ap1;
    }

    public void setAp1(String Ap1) {
        this.Ap1 = Ap1;
    }

    public String getAp2() {
        return Ap2;
    }

    public void setAp2(String Ap2) {
        this.Ap2 = Ap2;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
    
}
