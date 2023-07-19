package ejercicio1.tdas.interfaces;

public interface Cola<T> extends Tda {

	void add(T element);

	T remove();

	T get();

}