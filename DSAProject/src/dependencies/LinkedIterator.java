package dependencies;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
	
	public int count;
	private LinearNode<T> current;
	
	public LinkedIterator(LinearNode<T> collection, int size) {
		current=collection;
		count=size;
	}
	@Override
	public boolean hasNext() {
		return current!=null;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}else {
			T result=current.getElement();
			current=current.getNext();
			return result;
		}
	}
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
}
