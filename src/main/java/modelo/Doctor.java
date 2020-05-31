package modelo;


public class Doctor {
  private int IdDoctor;
  private String Nombre;
  private String Ap1;
  private String Ap2;
  private String Especializacion;
  private int Consultorio ;
  private int Departamento;
  private String Genero;

   public Doctor() {}
    public Doctor(int IdDoctor, String Nombre, String Ap1, String Ap2, String Especializacion, int Consultorio, int Departamento, String Genero) {
        this.IdDoctor = IdDoctor;
        this.Nombre = Nombre;
        this.Ap1 = Ap1;
        this.Ap2 = Ap2;
        this.Especializacion = Especializacion;
        this.Consultorio = Consultorio;
        this.Departamento = Departamento;
        this.Genero = Genero;
    }

   

  

    public int getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(int IdDoctor) {
        this.IdDoctor = IdDoctor;
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

    public String getEspecializacion() {
        return Especializacion;
    }

    public void setEspecializacion(String Especializacion) {
        this.Especializacion = Especializacion;
    }

    public int getConsultorio() {
        return Consultorio;
    }

    public void setConsultorio(int Consultorio) {
        this.Consultorio = Consultorio;
    }

    public int getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(int Departamento) {
        this.Departamento = Departamento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
  
  
}
	
