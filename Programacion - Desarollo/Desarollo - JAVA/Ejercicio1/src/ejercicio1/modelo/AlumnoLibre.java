package ejercicio1.modelo;

import ejercicio1.tdas.implementaciones.PilaNodos;
import ejercicio1.tdas.interfaces.Pila;

public class AlumnoLibre extends Alumno {

	private Pila<Integer> notas;

	public AlumnoLibre(int dni, String nombre, int nroCurso, int notaFinalCursada) {
		super(dni, nombre, nroCurso, notaFinalCursada);
		this.notas = new PilaNodos<Integer>();
	}
	
	public void agregarNota(int nota) {
		notas.push(nota);
	}

	public int ultimaNota() {
		return notas.peek();
	}

	@Override
	public TipoExamen obtenerTipoExamen() {
		return TipoExamen.FINAL_PRACTICO;
	}
}
