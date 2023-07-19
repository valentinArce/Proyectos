package ejercicio2;

import ejercicio2.clases.ActualizacionDirecta;
import ejercicio2.clases.ActualizacionPorMonto;
import ejercicio2.clases.ActualizacionPorcentual;
import ejercicio2.clases.Expendedora;
import ejercicio2.clases.Producto;

public class ejercicio2 {

	public static void main(String[] args) {
		try {
			Expendedora maquina = new Expendedora("Super Hiper Vendedora");
			
			System.out.println("--- Agregado de productos... ---");
			agregarProductos(maquina);

			System.out.println("--- Aplicando actualizaciones de precio... ---");
			actualizarPrecio(maquina);

			System.out.println("--- Listados ---");
			maquina.mostrarHistoricoActualizaciones();
			maquina.mostrarErrores();
			maquina.listarProductosPorNombre();
			maquina.listarProductosPorId();
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	private static void agregarProductos(Expendedora maquina) {
		// TODO - Agregar los siguientes productos usando el metodo agregar que
		// figura al final de la clase
		// ID Producto, precio inicial, nombre
		// 1, 100.0, "Bidu-Cola"
		// 2, 200.0, "Dos Gambas Light"));
		// 3, 500.0, "Milki 1Kg"));
		// 3, 500.0, "Miko-Moko"
		agregar(maquina, new Producto(1, 100.0, "Bidu-Cola"));
		agregar(maquina, new Producto(2, 200.0, "Dos Gambas Light"));
		agregar(maquina, new Producto(3, 500.0, "Milki 1Kg"));
		agregar(maquina, new Producto(3, 500.0, "Miko-Moko"));
	}

	private static void actualizarPrecio(Expendedora maquina) {
		// TODO - Aplicar las siguientes actualizaiones de precio
		// ID Producto, Tipo de Actualizacion, valor
		// 1, null
		// 1, Porcentual, 10
		// 2, Por Monto, 20
		// 2, Por Monto, -2500
		// 1, Directa, -1;

		maquina.ajustarPrecio(1, null);
		maquina.ajustarPrecio(1, new ActualizacionPorcentual(10));
		maquina.ajustarPrecio(2, new ActualizacionPorMonto(20));
		maquina.ajustarPrecio(2, new ActualizacionPorMonto(-2500));
		maquina.ajustarPrecio(1, new ActualizacionDirecta(-1));
	}

	private static void agregar(Expendedora maquina, Producto producto) {
		// TODO Completar try-catch por los alumnos
		try {
			maquina.agregarProductoPorID(producto);
		} catch (RuntimeException e) {
			System.out.println("Error agregando un producto: " + e.getMessage());
		}
	}

}
