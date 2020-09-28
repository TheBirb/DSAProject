package Social;

@SuppressWarnings("serial")
public class AlreadyAddedFriend extends Exception{

	/**
	 * 
	 */
	public AlreadyAddedFriend() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AlreadyAddedFriend(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlreadyAddedFriend(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AlreadyAddedFriend(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AlreadyAddedFriend(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
