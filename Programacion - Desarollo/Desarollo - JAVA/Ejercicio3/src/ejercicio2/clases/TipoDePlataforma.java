package ejercicio2.clases;

public enum TipoDePlataforma {

	PC("PC", 1f),
	XBOX("Xbox",1.2f),
	PLAYSTATION("PlayStation",1.3f),
	NINTENDO("Nintendo",1.3f);

	private String descripcion;
	private float multiplicador;

	private TipoDePlataforma(String descripcion, float multiplicador) {
		this.descripcion 	= descripcion;
		this.multiplicador = multiplicador;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public float getMultiplicadorPlataforma() {
		return multiplicador;
	}

}
