package ejercicio5.tdas.interfaces;

public interface Pila<T> extends Tda {

	void push(T element);

	T pop();

	T peek();

}