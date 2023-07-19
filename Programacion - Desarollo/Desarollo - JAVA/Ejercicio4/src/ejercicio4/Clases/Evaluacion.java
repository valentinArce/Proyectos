package ejercicio4.Clases;

import ejercicio4.tdas.interfaces.Mostrable;

public abstract class Evaluacion implements Mostrable{

	private int nro;
	private String fechaAplicacion;
	private String nombreExaminador; 
	private Puntaje puntaje;
	
	Evaluacion(int nro, String fechaAplicacion, String nombreExaminador, Puntaje puntaje){
		this.nro = nro;
		this.nombreExaminador = nombreExaminador;
		this.puntaje = puntaje;
		this.fechaAplicacion = fechaAplicacion;
	}
	
	public String getNombreExaminador() {
		return this.nombreExaminador;
	}
	

	public String getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(String fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

	public int getNro() {
		return nro;
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
		System.out.println("\tEVALUACION NRO: "+this.getNro()+"-"+"EVALUACION REALIZADA EL: " + this.fechaAplicacion + 
						   " POR " + this.nombreExaminador +
						   "\n\tPUNTAJE: " + this.puntaje);
		
	}

	public abstract void informarPacientes();
	public abstract void evaluarPaciente(Paciente paciente);

	
	
	
	
	
}
