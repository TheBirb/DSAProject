package Exceptions;

@SuppressWarnings("serial")
public class NotEnoughPeopleException extends Exception{

	/**
	 * 
	 */
	public NotEnoughPeopleException() {
		super();
	
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NotEnoughPeopleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotEnoughPeopleException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public NotEnoughPeopleException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public NotEnoughPeopleException(Throwable cause) {
		super(cause);
		
	}

}
