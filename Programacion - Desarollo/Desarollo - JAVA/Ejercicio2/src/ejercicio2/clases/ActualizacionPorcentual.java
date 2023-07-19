package ejercicio2.clases;

public class ActualizacionPorcentual extends ActualizacionExtendida {

	public ActualizacionPorcentual(double valorAAjustar) {
		super(valorAAjustar);
	}

	@Override
	public double obtenerValorCalculado(double precioBase) {
		return precioBase * (100.0 + getValor()) / 100.0;
	}

}
