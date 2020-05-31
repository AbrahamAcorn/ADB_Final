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
public class Paciente {
  private int idPaciente; 
  private String Nombre; 
  private String PrimAp; 
  private String SegAp; 
  private String Colonia; 
  private String Calle;
  private int num;
  private String telefono;
  private String Estado;
  private int habitacion;
  private String genero;

    public Paciente(int idPaciente, String Nombre, String PrimAp, String SegAp, String Colonia, String Calle, int num, String telefono, String Estado, int habitacion, String genero) {
        this.idPaciente = idPaciente;
        this.Nombre = Nombre;
        this.PrimAp = PrimAp;
        this.SegAp = SegAp;
        this.Colonia = Colonia;
        this.Calle = Calle;
        this.num = num;
        this.telefono = telefono;
        this.Estado = Estado;
        this.habitacion = habitacion;
        this.genero = genero;
    }

    public Paciente() { }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrimAp() {
        return PrimAp;
    }

    public void setPrimAp(String PrimAp) {
        this.PrimAp = PrimAp;
    }

    public String getSegAp() {
        return SegAp;
    }

    public void setSegAp(String SegAp) {
        this.SegAp = SegAp;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
  
  
}
