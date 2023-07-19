package ejercicio2.clases;

public interface Apreciable {

	/**
	 * Devuelve el precio.
	 * 
	 * @return el precio
	 */
	double obtenerPrecio();

	/**
	 * Aplica un ajuste en el precio del producto. El ajuste contiene la regla
	 * de ajuste de precio.
	 * 
	 * @param ajuste
	 *            La regla de ajuste de Precio a aplicar.
	 * @throws RuntimeException
	 *             En caso de que el ajuste sea null.
	 */
	void aplicarActualizacion(Actualizacion ajuste) throws RuntimeException;

}
