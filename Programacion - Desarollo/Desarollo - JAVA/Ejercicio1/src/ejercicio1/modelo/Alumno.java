package ejercicio1.modelo;

public abstract class Alumno implements Inscribible {

	private static final int DNI_MINIMO = 5000000;
	private static final int NRO_CURSO_MINIMO = 1;
	private static final int NRO_CURSO_MAXIMO = 10;
	private static final String NUMERO_DE_CURSO_INVALIDO = "Nro de curso invalido";
	private static final String NOMBRE_INVALIDO = "Nombre invalido";
	private static final String NUMERO_DE_DNI_INVALIDO = "Nro de DNI invalido";
	private static final String NOTA_INVALIDA = "Nota invalida";
		
	private int dni;
	private String nombre;
	private int nroCurso;
	private int notaFinalCursada;
	
	/**
	 * 
	 * @param dni No puede ser menor a 5 millones
	 * @param nombre no puede ser nulo ni vacío
	 * @param nroCurso debe estar entre 1 y 10.
	 */
	public Alumno(int dni, String nombre, int nroCurso, int notaFinalCursada) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setNroCurso(nroCurso);
		this.notaFinalCursada = notaFinalCursada;
	}

	private void setDni(int dni) {
		if (dni < DNI_MINIMO) {
			throw new IllegalArgumentException(NUMERO_DE_DNI_INVALIDO);
		}
		this.dni = dni;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	private void setNroCurso(int nroCurso) {
		if (nroCurso < NRO_CURSO_MINIMO || nroCurso > NRO_CURSO_MAXIMO) {
			throw new IllegalArgumentException(NUMERO_DE_CURSO_INVALIDO);
		}
		this.nroCurso = nroCurso;
	}
	
	protected void setNotaFinalCursada(int notaFinalCursada) {
		if (notaFinalCursada < Inscribible.NOTA_MINIMA || notaFinalCursada > Inscribible.NOTA_MAXIMA) {
			throw new IllegalArgumentException(NOTA_INVALIDA);
		}
		this.notaFinalCursada = notaFinalCursada;
	}
	
	@Override
	public boolean materiaAprobada() {
		return this.notaFinalCursada >= Inscribible.NOTA_APROBACION;
	}

	protected int getNotaFinalCursada() {
		return notaFinalCursada;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCurso() {
		return this.nroCurso;
	}

	public int getDni() {
		return dni;
	}
	
	
}
