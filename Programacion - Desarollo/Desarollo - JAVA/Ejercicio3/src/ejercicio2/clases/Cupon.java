package ejercicio2.clases;

public enum Cupon {

	NINGUNO("Sin cupon", 0.0f),
	DIEZ("Cupon de 10%", 10.0f),
	VEINTE("Cupon de 20%", 20.0f),
	TREINTA("Cupon de 30%", 30.0f),
	CUARENTA("Cupon de 40%", 40.0f);

	private String nombre;

	private float porcentaje;

	private Cupon(String nombre, float porcentaje) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public float getPorcentaje() {
		return porcentaje;
	}
}
