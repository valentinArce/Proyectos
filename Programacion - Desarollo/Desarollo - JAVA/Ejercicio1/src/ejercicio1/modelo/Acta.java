package ejercicio1.modelo;

public class Acta {

	private TipoExamen categoria;
	private AlumnosPorDni alumnos;

	public Acta(TipoExamen categoria) {
		this.categoria = categoria;
		this.alumnos = new AlumnosPorDni();
	}

	public void agregarAlumno(Alumno al) {
		this.alumnos.add(al);
	}
	
	public void removerAlumno(Alumno al) {
		this.alumnos.remove(al);
	}

	public void alumnosPorCurso(int[] cantidadAlumnosPorCurso) {
		for (Alumno alumno : alumnos) {
			cantidadAlumnosPorCurso[alumno.getCurso() - 1]++;
		}
	}

	public TipoExamen getCategoria() {
		return categoria;
	}
}
