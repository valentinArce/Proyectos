/**
 * 
 */
package ejercicio5.clases;

/**
 *
 */
public class EstacionamientoException extends RuntimeException {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EstacionamientoException() {
		super("Error generico de estacionamiento");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public EstacionamientoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EstacionamientoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public EstacionamientoException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public EstacionamientoException(Throwable arg0) {
		super(arg0);
	}

}
