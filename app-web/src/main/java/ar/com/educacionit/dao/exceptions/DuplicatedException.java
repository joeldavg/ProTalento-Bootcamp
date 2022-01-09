package ar.com.educacionit.dao.exceptions;

/**
 * Un achecked exception
 * @author Joel Guzman
 *
 */

public class DuplicatedException extends Exception {

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
