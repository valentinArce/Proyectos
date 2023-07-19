package ejercicio2.clases;

import ejercicio2.tdas.implementaciones.ColaNodos;
import ejercicio2.tdas.interfaces.Cola;
import ejercicio2.tdas.interfaces.ListaOrdenada;

public class TiendaDeJuegos implements Mostrable {

	private static final String MSG_JUEGO_NULO = "No se pudo fabricar Juego o Cupon nulo.";
	private static final String MSG_TIPO_DE_JUEGO = "Error de parametros incorporando tipos de juegos";
	private static final String MSG_TOTALES = "La venta total fue: $%8.2f\n";
	public static final String MENSAJE_FABRICA_POR_TIPO = "Se han fabricado: %d RPG, %d Aventura, %d Plataformas y %d Carreras\n";
	private String nombre;

	private int[][] cuponesPorTipoDeJuego;

	private int[] cantidadPorTipoDeJuego;

	private ListaOrdenada<Float, Juego> listaDeJuegosPorPrecio;

	private Cola<String> pedidosConError;

	private float ventasTotales;


	public TiendaDeJuegos(String nombre) {
		setNombre(nombre);
		this.listaDeJuegosPorPrecio = new ListaOrdenadasDeJuegosPorPrecio();
		this.cuponesPorTipoDeJuego = new int[Cupon.values().length][TipoDeJuego.values().length];
		this.pedidosConError = new ColaNodos<>();
		this.cantidadPorTipoDeJuego = new int[TipoDeJuego.values().length];
		this.ventasTotales = 0;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("Nombre de Juego Invalido");
		}
		this.nombre = nombre;
	}

	// TODO A completar
	public void ingresarJuego(TipoDeJuego tipoDeJuego, Cupon cupon, int cantidad) {
		if (cupon == null || tipoDeJuego == null || cantidad < 1) {
			throw new RuntimeException(MSG_TIPO_DE_JUEGO);
		}

		this.cuponesPorTipoDeJuego[cupon.ordinal()][tipoDeJuego.ordinal()] += cantidad;
	}

	public void ingresarPedido(Juego juego, Cupon cupon) {
		if (juego == null || cupon == null) {
			this.pedidosConError.add(MSG_JUEGO_NULO);
			throw new RuntimeException(MSG_JUEGO_NULO);
		}

		if (!veritificarStockDeCupones(cupon, juego.getTipo())) {
			String mensaje = "No se pudo ingresar " +  juego.getClass().getSimpleName() + " por falta de cupon " + cupon.getNombre();
			this.pedidosConError.add(mensaje);
			throw new RuntimeException(mensaje);
		}

		juego.agregarCupon(cupon);

		this.cuponesPorTipoDeJuego[cupon.ordinal()][juego.getTipo().ordinal()]--;
		this.listaDeJuegosPorPrecio.add(juego);
		this.ventasTotales += juego.getPrecioDeVenta();
		this.cantidadPorTipoDeJuego[juego.getTipo().ordinal()]++;


		/*
		if (juego.getTipo().equals(TipoDeJuego.CARRERAS)) {
			cantidadCarreras++;
		}
		 */

	}

	public int cantidadDeJuegosEntrePrecios(float precioMinimo, float precioMaximo) {
		int cantidad = 0;
		int idx = 0;
		Juego juego;
		while (idx < listaDeJuegosPorPrecio.size()
				&& listaDeJuegosPorPrecio.get(idx).getPrecioDeVenta() <= precioMaximo) {
			juego = listaDeJuegosPorPrecio.get(idx);

			if (juego.getPrecioDeVenta() >= precioMinimo) {
				cantidad++;
			}
			idx++;
		}

		return cantidad;
	}

	public boolean veritificarStockDeCupones(Cupon cupon, TipoDeJuego tipoDeJuego) {
		return this.cuponesPorTipoDeJuego[cupon.ordinal()][tipoDeJuego.ordinal()] > 0;
	}

	public void mostrarCantidadDeJuegosPorTipo() {
		// Completar
		System.out.printf(MENSAJE_FABRICA_POR_TIPO,
			this.cantidadPorTipoDeJuego[TipoDeJuego.RPG.ordinal()],
			this.cantidadPorTipoDeJuego[TipoDeJuego.AVENTURA.ordinal()],
			this.cantidadPorTipoDeJuego[TipoDeJuego.PLATAFORMAS.ordinal()],
			this.cantidadPorTipoDeJuego[TipoDeJuego.CARRERAS.ordinal()]
		);

		/*
		int cantidadRectangular = 0;
		for (Juego juego: listaDeJuegosPorPrecio) {
			if (juego instanceof JuegoMultijugador) {

			if (juego.getTipo().equals(TipoDeJuego.CARRERAS)) {
				cantidadCarreras++;
			}
		}*/

	}

	public void calcularImporteTotalYMostrar() {
		// Completar

		/* Otra opcion
		float precio = 0;

		for (Juego juego: listaDeJuegosPorPrecio) {
			precio += juego.getPrecioDeVenta();
		}

		*/


		System.out.printf(MSG_TOTALES, this.ventasTotales);
	}

	@Override
	public void mostrar() {
		System.out.println("TiendaDeJuegos: " + this.nombre);
		this.mostrarCantidadDeJuegosPorTipo();
		this.calcularImporteTotalYMostrar();
		this.listarJuegosPorPrecio();
		this.listarErroresOcurridos();
	}

	private void listarJuegosPorPrecio() {
		System.out.println("--------------------------------------");

		for (Juego juego : listaDeJuegosPorPrecio) {
			juego.mostrar();
		}
	}

	private void listarErroresOcurridos() {
		System.out.println("--------------------------------------");
		System.out.println("Pedidos con error");
		String centinela = null;

		pedidosConError.add(centinela);
		String aux = this.pedidosConError.remove();

		while (aux != centinela) {
			System.out.println(aux);
			this.pedidosConError.add(aux);
			aux = this.pedidosConError.remove();
		}
	}
}
