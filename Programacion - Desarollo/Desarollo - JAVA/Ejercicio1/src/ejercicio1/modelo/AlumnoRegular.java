package ejercicio1.modelo;

public class AlumnoRegular extends Alumno {

	private boolean camaraEncendida;

	public AlumnoRegular(int dni, String nombre, int nroCurso, int notaFinalCursada, boolean camaraEncendida) {
		super(dni, nombre, nroCurso, notaFinalCursada);
		this.camaraEncendida = camaraEncendida;
	}

	@Override
	public TipoExamen obtenerTipoExamen() {
		return !materiaAprobada() ? TipoExamen.RECUPERATORIO : super.getNotaFinalCursada() >= NOTA_ACCESO_TEORICO && camaraEncendida ? TipoExamen.FINAL_TEORICO : TipoExamen.FINAL_PRACTICO;
	}
	
	public void actualizarNota(int nota) {
		this.setNotaFinalCursada(nota);
	}
	
}
