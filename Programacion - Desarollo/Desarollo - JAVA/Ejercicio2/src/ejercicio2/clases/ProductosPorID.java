package ejercicio2.clases;

import ejercicio2.tdas.implementaciones.ListaOrdenadaNodos;

public class ProductosPorID extends ListaOrdenadaNodos<Integer, Producto> implements Listable {

	@Override
	public int compare(Producto dato1, Producto dato2) {
		return dato1.getId() - dato2.getId();
	}

	@Override
	public int compareByKey(Integer clave, Producto elemento) {
		return clave - elemento.getId();
	}

	@Override
	public void listar() {
		System.out.println("\nProductos por ID");
		for (Producto producto : this) {
			System.out.println(producto);
		}		
	}

}
