package exceptions;

/**
 * Clase de excepcion para la capa de acceso a persistencia (base de datos)
 * 
 * @author Angel
 *
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {

	/** Excepcion con mensaje */
	public DAOException(String message) {
		super(message);
	}

	/** Excepcion con mensaje y causa */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
