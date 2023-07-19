package ejercicio4.Clases;

import ejercicio4.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaDiagnosticoPorSeveridad extends ListaOrdenadaNodos<Severidad, Diagnostico>{

	@Override
	public int compare(Diagnostico d1, Diagnostico d2) {
		// TODO Auto-generated method stub
		return d2.getSeveridad().ordinal() - d1.getSeveridad().ordinal();
	}

	@Override
	public int compareByKey(Severidad clave, Diagnostico d) {
		// TODO Auto-generated method stub
		return d.getSeveridad().ordinal() - d.getSeveridad().ordinal();
	}

	
	

}
