package ejercicio1.modelo;

public class Materia {

	private static final String MATERIA_SIN_CUPO = "Materia sin cupo";
	private static final String ALUMNO_REPETIDO = "Este alumno ya se encuentra inscripto";
	private static final String ALUMNO_NOT_FOUND = "Este alumno no se encuentra inscripto";
	private static final String ALUMNO_LIBRE = "No se puede actualizar nota de un alumno libre";
	private static final int CANTIDAD_CURSOS = 10;
	private String nombre;
	private Acta[] actas;
	private AlumnosPorDni inscriptos;
	private int cupoMaximo;
	private int cantidadInscriptos;

	public Materia(String nombre, int cupoMaximo) {
		this.nombre = nombre;
		this.cupoMaximo = cupoMaximo;
		inscriptos = new AlumnosPorDni();
	}

	public void inscribir(Alumno a) throws RuntimeException {
		if (cantidadInscriptos == cupoMaximo) {
			throw new RuntimeException(MATERIA_SIN_CUPO);
		}
		if (inscriptos.exists(a.getDni())) {
			throw new RuntimeException(ALUMNO_REPETIDO);
		}
		inscriptos.add(a);
	}

	public void actualizarNota(int dni, int nuevaNota) {
		Alumno alumno = inscriptos.search(dni);
		if (alumno == null) {
			throw new RuntimeException(ALUMNO_NOT_FOUND);
		}
		if (alumno instanceof AlumnoLibre) {
			throw new RuntimeException(ALUMNO_LIBRE);
		}		
		actas[alumno.obtenerTipoExamen().ordinal()].removerAlumno(alumno);
		((AlumnoRegular)alumno).actualizarNota(nuevaNota);
		actas[alumno.obtenerTipoExamen().ordinal()].agregarAlumno(alumno);
		
	}

	public void asignarActas() {
		inicializarActas();
		for (Alumno alumnoAux : inscriptos) {
			TipoExamen tipoExamen = alumnoAux.obtenerTipoExamen();
			if (tipoExamen != null) {
				actas[tipoExamen.ordinal()].agregarAlumno(alumnoAux);
			}
		}
	}

	private void inicializarActas() {
		actas = new Acta[TipoExamen.values().length];
		for (int i = 0; i < actas.length; i++) {
			actas[i] = new Acta(TipoExamen.values()[i]);
		}
	}

	public void informarActasXCurso() {
		if (actas[0] != null) {
			System.out.println("Alumnos por acta de la materia: " + nombre);
			int[][] cantidades = obtenerMatriz();
			mostrarMatriz(cantidades);
		}
	}

	private int[][] obtenerMatriz() {
		int[][] cantidades = new int[TipoExamen.values().length][CANTIDAD_CURSOS];
		for (int iFila = 0; iFila < actas.length; iFila++) {
			Acta acta = actas[iFila];
			acta.alumnosPorCurso(cantidades[iFila]);
		}
		return cantidades;
	}

	private void mostrarMatriz(int[][] cantidades) {
		int [] totales = new int[CANTIDAD_CURSOS];
		System.out.printf("%15s", "Curso");
		for (int i = 0; i < CANTIDAD_CURSOS; i++) {
			System.out.printf("%5d", i+1);
			totales[i] = 0;
		}
		System.out.println();
		for (int iFila = 0; iFila < TipoExamen.values().length; iFila++) {
			TipoExamen te = TipoExamen.values()[iFila];
			System.out.printf("%15s", te);
			for (int iColumna = 0; iColumna < cantidades[iFila].length; iColumna++) {
				System.out.printf("%5d", cantidades[iFila][iColumna]);
				totales[iColumna] += cantidades[iFila][iColumna];
			}
			System.out.println();
		}
		System.out.printf("%15s", "TOTAL");
		for (int i = 0; i < CANTIDAD_CURSOS; i++) {
			System.out.printf("%5d", totales[i]);
		}
		System.out.println();
	}

	public String getNombre() {
		return nombre;
	}

}