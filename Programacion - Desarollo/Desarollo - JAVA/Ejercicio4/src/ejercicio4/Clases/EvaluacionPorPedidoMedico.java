package ejercicio4.Clases;


import ejercicio4.tdas.implementaciones.ColaNodos;
import ejercicio4.tdas.interfaces.Cola;


public class EvaluacionPorPedidoMedico extends Evaluacion{
	
	private Cola<Paciente> pacientes;
	private String nombreSolicitante; 
	
	public EvaluacionPorPedidoMedico(int nro, String fecha, String nombreExaminador, Puntaje puntaje, String nombre) {
		super(nro, fecha, nombreExaminador, puntaje);
		this.nombreSolicitante = nombre;
		this.pacientes = new ColaNodos<Paciente>();
		// TODO Auto-generated constructor stub
	}

	
	
	public String getNombreSolicitante() {
		return nombreSolicitante;
	}


	public void mostrar() {
		// TODO Auto-generated method stub
		super.mostrar();
		System.out.println("\tSOLICITA: " + this.nombreSolicitante);
	}

	@Override
	public void informarPacientes() {
		// TODO Auto-generated method stub
		
		Paciente p = null;
		pacientes.add(p);
		Paciente a = pacientes.remove();
		
		while (a != p) {
			System.out.println("EVALUACION NRO: " + this.getNro()+"--"+"PEDIDO MEDICO ");
			a.mostrar();
			pacientes.add(a);
			a = pacientes.remove();
		}
		
		
	}


	@Override
	public void evaluarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		pacientes.add(paciente);
				
	}
	
	

}
