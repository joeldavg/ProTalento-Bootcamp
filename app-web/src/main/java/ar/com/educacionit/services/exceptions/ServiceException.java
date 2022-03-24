package ar.com.educacionit.services.exceptions;

public class ServiceException extends Exception {
											/*GenericException
											  DuplicatedException*/
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
	
	// otro constructor que reciba la GenericException
	
}
