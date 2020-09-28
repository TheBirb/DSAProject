package Social;

@SuppressWarnings("serial")
public class NotEnoughPeopleException extends Exception{

	/**
	 * 
	 */
	public NotEnoughPeopleException() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotEnoughPeopleException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NotEnoughPeopleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NotEnoughPeopleException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
