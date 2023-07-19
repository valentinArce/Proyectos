package ejercicio2.clases;

public interface Identificable<T> {
	T getId();
	boolean mismoId(T otroId);
}
