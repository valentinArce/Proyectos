package ejercicio2.clases;

/**
 * Define una regla de actualizacion de precio para uno o mas productos.
 * Para cada uno requiere el precio actual del producto, lo devuelve
 * actualizado.
 * 
 **/
public abstract class ActualizacionExtendida extends Actualizacion {
	
	public ActualizacionExtendida(double valor) {
		super(valor);
	}

	public abstract double obtenerValorCalculado(double precioBase); 

}