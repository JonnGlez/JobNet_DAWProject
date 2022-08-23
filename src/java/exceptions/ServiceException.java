package exceptions;

/**
 * Clase excepcion para la capa Servicios
 * 
 * @author Angel
 * 
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception {

	/** Excepcion con mensaje */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/** Excepcion con mensaje y causa */
	public ServiceException(String message) {
		super(message);
	}
}
