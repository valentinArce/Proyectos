package ejercicio2.clases;

import ejercicio2.tdas.implementaciones.ListaOrdenadaNodos;

public class ProductosPorNombre extends ListaOrdenadaNodos<String, Producto> implements Listable {

	@Override
	public int compare(Producto dato1, Producto dato2) {
		return dato1.getNombre().compareTo(dato2.getNombre());
	}

	@Override
	public int compareByKey(String clave, Producto elemento) {
		return clave.compareTo(elemento.getNombre());
	}

	@Override
	public void listar() {
		System.out.println("\nProductos por Nombre");
		for (Producto producto : this) {
			System.out.println(producto);
		}	
	}

}