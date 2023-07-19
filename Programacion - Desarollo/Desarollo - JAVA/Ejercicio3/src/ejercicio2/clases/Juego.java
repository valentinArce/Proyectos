package ejercicio2.clases;

public abstract class Juego implements Mostrable {

	private static final String MSG_GANANCIA_INVALIDA = "Ganancia invalida";
	private static final String MSG_PRECIO_INVALIDO = "Costo invalido";
	private static final String MSG_NOMBRE_INVALIDO = "Nombre invalido";
	private static final String MSG_TIPO_INVALIDO = "Tipo invalido";

	private static final String MSG_CUPON_INVALIDO = "Cupon invalido";



	private String nombre;

	private float precioBase;

	private float porcentajeGanancia;

	private TipoDeJuego tipoDeJuego;

	private Cupon cupon;

	public Juego(String nombre, float precioBase, float porcentajeGanancia, TipoDeJuego tipoDeJuego) {
		this.setNombre(nombre);
		this.setPrecioBase(precioBase);
		this.setPorcentajeGanancia(porcentajeGanancia);
		this.setTipoDeJuego(tipoDeJuego);

	}

	public void agregarCupon(Cupon cupon) {
		if (cupon == null) {
			throw new IllegalArgumentException(MSG_CUPON_INVALIDO);
		}

		this.cupon = cupon;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(MSG_NOMBRE_INVALIDO);
		}

		this.nombre = nombre;
	}

	public void setTipoDeJuego(TipoDeJuego tipoDeJuego) {
		if (tipoDeJuego == null) {
			throw new IllegalArgumentException(MSG_TIPO_INVALIDO);
		}

		this.tipoDeJuego = tipoDeJuego;
	}

	private void setPrecioBase(float precioBase) {
		if (precioBase <= 0) {
			throw new IllegalArgumentException(MSG_PRECIO_INVALIDO);
		}
		this.precioBase = precioBase;
	}

	private void setPorcentajeGanancia(float porcentajeGanancia) {
		if (porcentajeGanancia < 0) {
			throw new IllegalArgumentException(MSG_GANANCIA_INVALIDA);
		}

		this.porcentajeGanancia = porcentajeGanancia;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public float getPrecioDeVenta() {
		float costo = this.getPrecioDeCosto();
		float venta = costo + (this.getPorcentajeGanancia() * costo / 100);
		return venta + (this.cupon.getPorcentaje() * venta / 100);
	}

	public abstract float getPrecioDeCosto();

	public TipoDeJuego getTipo() {
		return this.tipoDeJuego;
	}
}
