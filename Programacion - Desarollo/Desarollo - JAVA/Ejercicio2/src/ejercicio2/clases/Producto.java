package ejercicio2.clases;

import ejercicio2.tdas.implementaciones.PilaNodos;
import ejercicio2.tdas.interfaces.Pila;

public class Producto implements Apreciable, Identificable<Integer> {

	private static final String MSJ_AJUSTE_INVALIDO = "Actualizacion Invalido";
	private final static String MSJ_PRECIO_INVALIDO = "Precio Invalido";
	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private static final String MSJ_ID_INVALIDO = "ID Invalido";

	private Integer id;
	private String nombre;

	private Pila<HistoricoActualizacion> historicoActualizaciones;

	public Producto(Integer id, double precioInicial, String nombre) {
		setId(id);
		setNombre(nombre);
		this.historicoActualizaciones = new PilaNodos<>();
		setPrecio(precioInicial);
	}

	// TODO A completar por los alumnos
	private void setPrecio(double precio) {
		aplicarActualizacion(new ActualizacionDirecta(precio));
	}

	// TODO A completar por los alumnos
	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	// TODO A completar por los alumnos
	private void setId(int id) {
		if (id < 1) {
			throw new RuntimeException(MSJ_ID_INVALIDO);
		}
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public boolean mismoId(Integer otroId) {
		return otroId.equals(id);
	}
	
	public String getNombre() {
		return nombre;
	}

	public double obtenerPrecio() {
		double ultimoPrecio = 0;
		if (!historicoActualizaciones.isEmpty()) {
			ultimoPrecio = historicoActualizaciones.peek().getPrecio();
		}
		return ultimoPrecio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", precio=" + obtenerPrecio() + ", nombre=" + nombre + "]";
	}

	// TODO A completar por los alumnos
	@Override
	public void aplicarActualizacion(Actualizacion actualizacion) throws RuntimeException {
		if (actualizacion == null) {
			throw new RuntimeException(MSJ_AJUSTE_INVALIDO);
		}
		double precio = obtenerPrecio();
		double nuevoPrecio = 0;
		if (actualizacion instanceof ActualizacionDirecta){
			nuevoPrecio = ((ActualizacionDirecta) actualizacion).obtenerValorCalculado();
		} else {
			nuevoPrecio = ((ActualizacionExtendida) actualizacion).obtenerValorCalculado(precio);
		}
		if (nuevoPrecio < 0) {
			throw new RuntimeException(MSJ_PRECIO_INVALIDO);
		}
		this.historicoActualizaciones.push(new HistoricoActualizacion(actualizacion, precio, nuevoPrecio));
	}

	public void listarActualizacionesDePrecio() {
		// TODO A completar por los alumnos
		System.out.println("Mostrando actualizaciones de: " + this);
		Pila<HistoricoActualizacion> aux = new PilaNodos<>();
		while (!this.historicoActualizaciones.isEmpty()) {
			aux.push(this.historicoActualizaciones.pop());
		}
		while (!aux.isEmpty()) {
			HistoricoActualizacion ha = aux.pop();
			System.out.println(ha);
			historicoActualizaciones.push(ha);
		}
	}
}