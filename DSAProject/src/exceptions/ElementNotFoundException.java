package exceptions;

@SuppressWarnings("serial")
public class ElementNotFoundException extends Exception {
	
	public ElementNotFoundException(String e) {
		super("There is no such element in" + e);
	}
}
