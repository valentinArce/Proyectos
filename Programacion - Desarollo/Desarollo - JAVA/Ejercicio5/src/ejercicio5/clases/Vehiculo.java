/**
 * 
 */
package ejercicio5.clases;

/**
 * Veh�culos estacionables en un estacionamiento
 */
public abstract class Vehiculo {

	/**
	 * Patente del veh�culo
	 */
	private String patente;
	/**
	 * Hora de ingreso al estacionamiento
	 */
	private Hora horaIngreso;

	/**
	 * Constructor del veh�culo
	 * 
	 * @param patente       Patente
	 * @param horaIngreso   Hora del horario de ingreso
	 * @param minutoIngreso minutos del horario de ingreso
	 */
	public Vehiculo(String patente, Hora horaIngreso) {
		this.setPatente(patente);
		this.setHoraIngreso(horaIngreso);
	}

	/**
	 * Valida que los minutos sean v�lidos (de 0 a 23 inclusive) debe lanzar una
	 * excepci�n {@link EstacionamientoException} si no es v�lido
	 * 
	 * @param horaIngreso
	 * @throws EstacionamientoException Si el horario es erroneo
	 */
	private void setHoraIngreso(Hora horaIngreso) throws EstacionamientoException {
		if (!horaIngreso.esValida()) {
			throw new EstacionamientoException("Hora de ingreso inv�lida");
		}
		this.horaIngreso = horaIngreso;

	}

	/**
	 * Setter de patente, que debe ser validada segun cada tipo de veh�culo
	 * 
	 * @param patente
	 */
	private void setPatente(String patente) {
		this.validarPatente(patente);
		this.patente = patente;
	}

	/**
	 * Valida la patente en forma especifica para cada tipo de veh�culo.
	 * 
	 * @param patente
	 * @throws EstacionamientoException si la patente es inv�lida
	 */
	protected abstract void validarPatente(String patente) throws EstacionamientoException;

	/**
	 * Calcula el importe que debe abonar el veh�culo en base a su tipo, el horario
	 * de ingreso que posee y el horario de egreso indicado Cada veh�culo debe
	 * poseer su algoritmo de calculo en base al fraccionamiento de minutos
	 * 
	 * @param horaEgreso
	 * @return
	 * @throws EstacionamientoException si existe algun problema al calcular el
	 *                                  importe.
	 */
	protected abstract float calcularImporte(Hora horaEgreso) throws EstacionamientoException;

	/**
	 * @param horasEgreso
	 * @param minutosEgreso
	 */
	public void validarHoraEgreso(Hora hora) throws EstacionamientoException {

		if (!hora.esValida()) {
			throw new EstacionamientoException("Horario de egreso inv�lido");
		}
		if (!horaIngreso.esAnterior(hora)) {
			throw new EstacionamientoException("Horario de egreso anterior al de ingreso");
		}

	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", horaIngreso=" + horaIngreso + "]";
	}

	public Hora calcularTiempoEstadia(Hora horaEgreso) {
		return horaIngreso.calcularDiferenciaTiempo(horaEgreso);
	}

	public boolean coincidePatente(String patente) {
		return this.patente.equals(patente);
	}

}
