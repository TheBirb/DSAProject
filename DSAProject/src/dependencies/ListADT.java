package dependencies;

import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
public interface ListADT<T> extends Iterable<T> {
	
	
	//Removes and returns the first element from the list
	public T removeFirst() throws EmptyCollectionException;
	
	//Removes and returns the last element from this list
	public T removeLast() throws EmptyCollectionException;
	
	//Removes and returns the specified element from this list
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;
	
	//Returns a reference to the first element in this list
	public T first();
	
	//Returns a reference to the last element in this list
	public T last();
	
	//Returns true if this list contains the specified target element
	public boolean contains(T target) throws EmptyCollectionException;
	
	//Returns true if this list contains no elements.
	public boolean isEmpty();
	
	//Returns the number of elements in this list
	public int size();
	
	//Returns an iterator for the elements in this list
	public Iterator<T> iterator();
	
	//Returns a string representation of this list
	public String toString();
	
	
	
}
