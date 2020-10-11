package Exceptions;

@SuppressWarnings("serial")
public class PersonNotFoundException extends Exception{
	public PersonNotFoundException() {
		super();
	}

	public PersonNotFoundException(String string) {
		super(string);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PersonNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PersonNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param cause
	 */
	public PersonNotFoundException(Throwable cause) {
		super(cause);
		
	}
}
