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
public class Estancia {
    private int IdEstancia ;
private int IdCliente;
private String entrada ;
private String salida;
private int ModoPago;
private double Cuenta;

    public Estancia(int IdEstancia, int IdCliente, String entrada, String salida, int ModoPago, double Cuenta) {
        this.IdEstancia = IdEstancia;
        this.IdCliente = IdCliente;
        this.entrada = entrada;
        this.salida = salida;
        this.ModoPago = ModoPago;
        this.Cuenta = Cuenta;
    }

    public Estancia() {
    }

    public int getIdEstancia() {
        return IdEstancia;
    }

    public void setIdEstancia(int IdEstancia) {
        this.IdEstancia = IdEstancia;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public int getModoPago() {
        return ModoPago;
    }

    public void setModoPago(int ModoPago) {
        this.ModoPago = ModoPago;
    }

    public double getCuenta() {
        return Cuenta;
    }

    public void setCuenta(double Cuenta) {
        this.Cuenta = Cuenta;
    }


}
