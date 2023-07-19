package ejercicio2.clases;

public enum ContenidoAdicional {

	DLC("DLC", 1000.21f),
	EXPANSIONES("Expansiones", 2500.1f),
	COSMETICOS("Cosmeticos", 300.5f);

	private String 	descripcion;
	private float adicional;

	private ContenidoAdicional(String descripcion, float adicional) {
		this.descripcion	= descripcion;
		this.adicional = adicional;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public float getAdicional() {
		return adicional;
	}

}
