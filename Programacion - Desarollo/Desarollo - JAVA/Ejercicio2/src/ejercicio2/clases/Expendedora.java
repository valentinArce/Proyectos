package ejercicio2.clases;

import ejercicio2.tdas.implementaciones.ColaNodos;
import ejercicio2.tdas.interfaces.Cola;

public class Expendedora {

	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private final static String MSJ_ID_INVALIDO = "ID de producto Invalido";
	private static final String MSJ_ACTUALIZACION_NULA = "La actualizacion no puede ser nula";
	private static final String MSJ_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_PRODUCTO_REPETIDO = "ID de producto ya existente";
	private ProductosPorNombre productosPorNombre;
	private ProductosPorID productosPorID;
	private Cola<String> erroresDeActualizacion;
	private String nombre;

	public Expendedora(String nombre) {
		this.productosPorNombre = new ProductosPorNombre();
		this.productosPorID = new ProductosPorID();
		this.erroresDeActualizacion = new ColaNodos<>();
		setNombre(nombre);
	}

	// TODO A completar por los alumnos
	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	// Para los que le toca el tema de ProductosPorId
	// Este nombre es para diferenciar los temas, en realidad es agregarProducto
	public void agregarProductoPorID(Producto p) {
		if (p == null) {
			throw new RuntimeException(MSJ_PRODUCTO_NULO);
		}
		Producto aux = productosPorID.search(p.getId());
		if (aux != null) {
			throw new RuntimeException(MSJ_PRODUCTO_REPETIDO);
		}
		productosPorID.add(p);
		productosPorNombre.add(p);
	}

	// Este nombre es para diferenciar los temas, en realidad es agregarProducto
	public void agregarProductoPorNombre(Producto p) {
		if (p == null) {
			throw new RuntimeException(MSJ_PRODUCTO_NULO);
		}
		// Para los que le toca el tema de ProductosPorNombre
		Producto aux = buscarProductoPorId(p.getId());
		if (aux != null) {
			throw new RuntimeException(MSJ_PRODUCTO_REPETIDO);
		}
		productosPorID.add(p);
		productosPorNombre.add(p);
	}

	// Metodo necesario para resolver correctamente la inserción al agregar Producto.
	private Producto buscarProductoPorId(Integer id) {
		Producto producto = null;
		int pos = 0;
		while(pos < productosPorNombre.size() && !productosPorNombre.get(pos).mismoId(id)) {
			pos++;
		}
		if (pos < productosPorNombre.size()) {
			producto = productosPorNombre.get(pos);
		}
		return producto;
	}

	public void ajustarPrecio(int idProducto, Actualizacion actualizacion) {
		Producto producto = productosPorID.search(idProducto);
		if (producto == null) {
			agregarError(MSJ_ID_INVALIDO, idProducto, actualizacion);
		} else if (actualizacion == null) {
			agregarError(MSJ_ACTUALIZACION_NULA, idProducto, actualizacion);
		} else {
			try {
				producto.aplicarActualizacion(actualizacion);
			} catch (RuntimeException re) {
				agregarError(re.getMessage(), idProducto, actualizacion);
			}
		}
	}

	private void agregarError(String mensaje, int idProducto, Actualizacion actualizacion) {
		erroresDeActualizacion.add(String.format("%s - %s - %s", mensaje, idProducto, actualizacion));
	}

	public void mostrarHistoricoActualizaciones() {
		System.out.println();
		System.out.println("Resumen actualizacion de precio de la maquina: " + this.nombre);
		System.out.println("Se muestra cada producto.");
		for (Producto producto : productosPorNombre) {
			producto.listarActualizacionesDePrecio();
			System.out.println("---------");
		}
	}

	public void mostrarErrores() {
		System.out.println();
		System.out.println("Errores de actualizacion de precio de la maquina: " + this.nombre);
		erroresDeActualizacion.add("");
		String mensajeError = erroresDeActualizacion.remove();
		while (!mensajeError.isEmpty()) {
			System.out.println(mensajeError);
			mensajeError = erroresDeActualizacion.remove();
		}
	}

	public void listarProductosPorNombre() {
		productosPorNombre.listar();
	}

	public void listarProductosPorId() {
		productosPorID.listar();
	}

}
