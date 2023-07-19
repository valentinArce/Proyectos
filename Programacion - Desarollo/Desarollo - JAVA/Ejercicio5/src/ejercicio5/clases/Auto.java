/**
 * 
 */
package ejercicio5.clases;

/**
 * Representa un auto a ser estacionado. El precio de los autos se fracciona
 * cada 10 minutos.
 */
public class Auto extends Vehiculo {

	/**
	 * Precio de los 10 minutos de estacionamiento
	 */
	private float precioDiezMinutos;

	/**
	 * Constructor de auto
	 * 
	 * @param patente       patente del auto
	 * @param horaIngreso   hora del ingreso
	 * @param minutoIngreso minutos del ingreso
	 * @param precioPorHora precio de la hora completa de los autos
	 */
	public Auto(String patente, Hora hora, float precioPorHora) {
		super(patente, hora);
		this.setPrecioDiezMinutos(precioPorHora / (float)Helper.DIEZ_MINUTOS_POR_HORA);
	}

	/**
	 * @param precioCincoMinutos
	 */
	private void setPrecioDiezMinutos(float precioDiezMinutos) {
		this.precioDiezMinutos = precioDiezMinutos;
	}

	/**
	 * Valida que una patente sea v�lida para el tipo de vehiculo auto. debe tener
	 * formato de tres letras y tres n�meros por ejemplo 'DSA182' o dos letras tres
	 * numeros y dos letras ejemplo 'AB123CD'
	 * TODO: Completar
	 */
	@Override
	public void validarPatente(String patente) throws EstacionamientoException {

		if (!Helper.esPatenteAuto(patente)) {
			throw new IllegalArgumentException("Patente err�nea");
		}

	}

	/**
	 * Calcula el importe de la estadia del auto, recibiendo el horario de salida.
	 * Debe redondearse a 10 minutos la cantidad de minutos de la estad�a, si la
	 * duraci�n da 7 minutos, se deben cobrar 10.
	 * TODO: Completar
	 */
	@Override
	public float calcularImporte(Hora hora) throws IllegalArgumentException {

		super.validarHoraEgreso(hora);

		Hora tiempo = this.calcularTiempoEstadia(hora);
		int minutos = Helper.redondear(tiempo.getMinuto(), Helper.DIEZ);
		float importe = 0;
		if (tiempo.getHora() == 0 && minutos < Helper.MEDIA_HORA) {
			importe = (float) (Helper.MEDIA_HORA / Helper.DIEZ) * this.precioDiezMinutos;
		} else {
			importe += (float) (minutos / Helper.DIEZ) * this.precioDiezMinutos;
			importe += (float) (tiempo.getHora() * Helper.DIEZ_MINUTOS_POR_HORA) * this.precioDiezMinutos;
		}
		return importe;
	}

}
