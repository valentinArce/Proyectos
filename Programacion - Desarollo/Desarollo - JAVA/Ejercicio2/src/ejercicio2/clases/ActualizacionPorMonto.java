package ejercicio2.clases;

/**
 * Actualiza el precio de un producto sumandole el valor de actualizacion
 * (que puede ser negativo) pero nunca permitir un valor final
 * menor que cero.
 *
 */
public class ActualizacionPorMonto extends ActualizacionExtendida {

	public ActualizacionPorMonto(double valorActualizacion) {
		super(valorActualizacion);
	}

	@Override
	public double obtenerValorCalculado(double precio) {
		return precio + getValor();
	}

}
