/**
 * 
 */
package ejercicio5.clases;

/**
 * Representa una motocicleta a ser estacionada. el precio de los autos se
 * fracciona cada 5 minutos.
 */
public class Motocicleta extends Vehiculo {
	/**
	 * Precio de los 5 minutos de estacionamiento
	 */
	private float precioCincoMinutos;

	/**
	 * Constructor de motocicleta
	 * 
	 * @param patente       patente de la motocicleta
	 * @param horaIngreso   hora del ingreso
	 * @param minutoIngreso minutos del ingreso
	 * @param precioPorHora precio de la hora completa de las motocicletas
	 */
	public Motocicleta(String patente, Hora horaIngreso, float precioPorHora) {
		super(patente, horaIngreso);
		this.setPrecioCincoMinutos(precioPorHora / (float)Helper.CINCO_MINUTOS_POR_HORA);
	}

	/**
	 * @param precioCincoMinutos
	 */
	private void setPrecioCincoMinutos(float precioCincoMinutos) {
		this.precioCincoMinutos = precioCincoMinutos;
	}

	/**
	 * Valida que una patente sea v�lida para el tipo de vehiculo auto. debe tener
	 * formato de tres n�meros y tres letas por ejemplo '182ABC'.
	 * TODO: Completar
	 */
	@Override
	public void validarPatente(String patente) throws IllegalArgumentException {

		if (!Helper.esPatenteMoto(patente)) {
			throw new IllegalArgumentException("Patente err�nea");
		}

	}

	/**
	 * Calcula el importe de la estadia del auto, recibiendo la hora y minutos de
	 * salida. Debe redondearse a 5 minutos la cantidad de minutos de la estad�a, si
	 * la duraci�n da 12 minutos, se deben cobrar 15. si la duraci�n da 7 minutos,
	 * se deben cobrar 10.
	 * TODO: completar
	 */
	@Override
	public float calcularImporte(Hora horaEgreso) throws IllegalArgumentException {
		this.validarHoraEgreso(horaEgreso);

		Hora tiempo = super.calcularTiempoEstadia(horaEgreso);
		int minutos = Helper.redondear(tiempo.getMinuto(), Helper.CINCO);
		float importe = 0;
		if (tiempo.getHora() == 0 && minutos < Helper.MEDIA_HORA) {
			importe = (float) (Helper.MEDIA_HORA / Helper.CINCO) * this.precioCincoMinutos;
		} else {
			importe += (float) (minutos / Helper.CINCO) * this.precioCincoMinutos;
			importe += (float) (tiempo.getHora() * Helper.CINCO_MINUTOS_POR_HORA) * this.precioCincoMinutos;
		}

		return importe;
	}

}
