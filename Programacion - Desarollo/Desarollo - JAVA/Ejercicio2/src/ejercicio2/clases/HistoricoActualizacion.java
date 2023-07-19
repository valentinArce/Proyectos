package ejercicio2.clases;

public class HistoricoActualizacion {

	private String tipoActualizacion;
	private double valorAnterior;
	private double valorActualizacion;
	private double precioActualizado;

	public HistoricoActualizacion(Actualizacion actualizacion, double precioAnterior, double nuevoPrecio) {
		this.tipoActualizacion = actualizacion.getTipo();
		this.valorAnterior = precioAnterior;
		this.valorActualizacion = actualizacion.getValor();
		this.precioActualizado = nuevoPrecio;
	}

	@Override
	public String toString() {
		return "HistoricoActualizacion [tipoActualizacion=" + tipoActualizacion + ", valorAnterior=" + valorAnterior + ", valorActualizacion="
				+ valorActualizacion + ", precioActualizado=" + precioActualizado + "]";
	}

	public double getPrecio() {
		return precioActualizado;
	}

}
