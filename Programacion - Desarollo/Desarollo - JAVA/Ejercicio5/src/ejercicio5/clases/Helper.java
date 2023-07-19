package ejercicio5.clases;

public class Helper {

	public static final int HORA = 60;
	public static final int MEDIA_HORA = 30;
	public static final int CINCO = 5;
	public static final int CINCO_MINUTOS_POR_HORA = 12;
	public static final int DIEZ = 10;
	public static final int DIEZ_MINUTOS_POR_HORA = 6;
	
	/**
	 * Indica si un string contiene una patente de auto.
	 */
	public static boolean esPatenteAuto(String patente) {
		return patente != null && patente.matches(TipoVehiculo.AUTO.getRegex());
	}
	
	/**
	 * Indica si un string contiene una patente de moto.
	 */
	public static boolean esPatenteMoto(String patente) {
		return patente != null && patente.matches(TipoVehiculo.MOTOCICLETA.getRegex());
	}
	
	/**
	 * Redondea el n�mero de minutos de egreso a una base, si la base es 5, y el nro
	 * de minutos es 2 devolver� 5, si el nro de minutos es 7 devolvera 10
	 * 
	 * @param minutos
	 * @param i
	 * @return
	 */
	public static int redondear(int minutos, int base) {
		return minutos + (base - minutos % base);
	}
}
