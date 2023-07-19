/**
 * 
 */
package ejercicio5.clases;

/**
 * Tipos de veh�culo
 * 
 */
public enum TipoVehiculo {
	AUTO("[a-zA-Z]{2,2}[0-9]{3,3}[a-zA-Z]{2,2}|[a-zA-Z]{3,3}[0-9]{3,3}"), 
	MOTOCICLETA("[0-9]{3,3}[a-zA-Z]{3,3}|[a-zA-Z]{1,1}[0-9]{3,3}[a-zA-Z]{3,3}");

	private String regex;

	/**
	 * Constructor del enum.
	 */
	private TipoVehiculo(String regex) {
		this.regex = regex;
	}

	/**
	 * Devuelve un String con la regex de la patente del tipo de veh�culo
	 * 
	 * @return
	 */
	public String getRegex() {
		return this.regex;
	}
}
