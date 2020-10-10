package exceptions;


@SuppressWarnings("serial")
public class EmptyCollectionException extends Exception{
	
	public EmptyCollectionException(String s) {
		super("The collection"+s+"is empty.");
	}
}
