package ejercicio1.modelo;

import ejercicio1.tdas.implementaciones.ListaOrdenadaNodos;

public class AlumnosPorDni extends ListaOrdenadaNodos<Integer, Alumno> {

	@Override
	public int compare(Alumno dato1, Alumno dato2) {
		return dato1.getDni() - dato2.getDni();
	}

	@Override
	public int compareByKey(Integer clave, Alumno elemento) {
		return clave - elemento.getDni();
	}

}
