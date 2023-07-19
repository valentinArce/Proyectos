package ejercicio1.modelo;

public interface Inscribible {
	
	static final int NOTA_MAXIMA = 10;
	static final int NOTA_ACCESO_TEORICO = 7;
	static final int NOTA_APROBACION = 4;
	static final int NOTA_MINIMA = 1;

	TipoExamen obtenerTipoExamen();
	boolean materiaAprobada();
}
