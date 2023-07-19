package ejercicio2.clases;

/**
 * Define una regla de actualizacion de precio para uno o mas productos.
 * Para cada uno requiere el precio actual del producto, lo devuelve
 * actualizado.
 * 
 **/
public abstract class Actualizacion {
	private double valor;

	public Actualizacion(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getTipo() {
		return this.getClass().getSimpleName();
	}
	
	@Override
	public String toString() {
		return getTipo() + " [valor=" + valor + "]";
	}

}