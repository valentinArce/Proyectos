package ejercicio4.Clases;

import ejercicio4.tdas.implementaciones.PilaNodos;
import ejercicio4.tdas.interfaces.Pila;

public class EvaluacionPorContinuidad extends Evaluacion{

	private String motivo; 
	private Pila<Paciente> pacientes;
	
	public EvaluacionPorContinuidad(int nro, String fecha, String nombreExaminador, Puntaje puntaje, String motivo) {
		super(nro, fecha, nombreExaminador, puntaje);
		this.motivo = motivo;
		this.pacientes = new PilaNodos<Paciente>();
		
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		super.mostrar();
		System.out.println("\t"+ this.motivo);
	}



	public String getMotivo() {
		return motivo;
	}



	@Override
	public void informarPacientes() {
		// TODO Auto-generated method stub
		
		Pila<Paciente> aux = new PilaNodos<Paciente>();
		
		while (!pacientes.isEmpty()) {
			aux.push(pacientes.pop());
		}
		
		while (!aux.isEmpty()) {
			System.out.println("EVALUACION NRO: " + this.getNro()+"--"+"CONTINUIDAD");
			pacientes.push(aux.pop());
			pacientes.peek().mostrar();
			
		}
	}



	@Override
	public void evaluarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
	
		pacientes.push(paciente);
	}

	
	
}
