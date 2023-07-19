package ejercicio2.clases;

/**
 * Aplica un seteo de precio directo sobre un producto, ignorando el precio
 * anterior (lo reemplaza con el valor de la actualizacion).
 *
 */
public class ActualizacionDirecta extends Actualizacion {

	public ActualizacionDirecta(double precioAAplicar) {
		super(precioAAplicar);
	}

	public double obtenerValorCalculado() {
		return getValor();
	}

}
