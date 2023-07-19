package ejercicio4.Clases;


import ejercicio4.tdas.interfaces.Mostrable;

public class Diagnostico implements Mostrable{

	
	private String codigoDiagnostico;
	private Severidad severidad;
	private Evaluacion[][] evaluaciones;
	
	
	public Diagnostico(String codigoDiagnostico, Severidad severidad) {
		
		this.codigoDiagnostico = codigoDiagnostico;
		this.severidad = severidad;
		this.evaluaciones = new Evaluacion[Jornada.values().length][Guardia.values().length];
		
	}
	
	

	public String getCodigo() {
		return codigoDiagnostico;
	}
	
	
	
	public Severidad getSeveridad() {
		return severidad;
	}

	public void agregarEvaluacion(Evaluacion eva, Jornada j, Guardia g) {
		
		if (evaluaciones[j.ordinal()][g.ordinal()] != null) {
			throw new IllegalArgumentException("Ya hay una Evaluacion almacenada el " + j + "--" + g);
		}
		evaluaciones[j.ordinal()][g.ordinal()] = eva;
	}
	
	private void mostrarEvaluaciones() {
		
		for (int f = 0; f < evaluaciones.length; f++) {
			for (int c = 0; c < evaluaciones[f].length; c++) {
				Evaluacion eva = evaluaciones[f][c];
				if (eva != null)
					eva.mostrar();
			}
		}
	}
	
	
	
	@Override
	public void mostrar() {
		
		
		System.out.println("\nCODIGO: " + codigoDiagnostico + " /SEVERIDAD: " + severidad + "\nEVALUACIONES");
		this.mostrarEvaluaciones();
		
	}



	
	
	
	


	
}
