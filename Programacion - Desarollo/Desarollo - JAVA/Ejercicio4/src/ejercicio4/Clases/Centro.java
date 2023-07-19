package ejercicio4.Clases;

import java.util.List;

import ejercicio4.tdas.interfaces.Mostrable;

public class Centro implements Mostrable{

	private String nombreCentro; 
	private static final String MSG_NOMBRE_INVALIDO = "El nombre del Centro no puede estar VACÍO, ni ser NULO";
	private ListaDiagnosticoPorSeveridad diagnosticos;
	
	public Centro(List<Diagnostico> diagnosticos, String nombre) {
		this.setNombreCentro(nombre);
		this.diagnosticos = new ListaDiagnosticoPorSeveridad();
		traspasarDiagnosticos(diagnosticos);
	}
	
	private void traspasarDiagnosticos(List<Diagnostico> diagnosticos) {
		for (Diagnostico d : diagnosticos) {
			this.diagnosticos.add(d);
		}
	}
	
	
	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombre) throws IllegalArgumentException{
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}
		this.nombreCentro = nombre;
	}
	@Override
	public void mostrar() {
		
		System.out.println("\nMOSTRANDO DIAGNOSTICOS --- ");
		for (Diagnostico d : diagnosticos) {
			d.mostrar();
		}
		
		System.out.println("\nFINALIZANDO PROCESO --- " + this.getNombreCentro());
	}
	
	
	
	
	
}
