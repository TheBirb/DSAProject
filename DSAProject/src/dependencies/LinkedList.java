package dependencies;
import exceptions.*;
import java.util.Iterator;

public class LinkedList<T> implements ListADT<T>, Iterable<T> {
	private LinearNode<T> front;
	private LinearNode<T> rear;
	private int count;
	
	public LinkedList() {
		this.front=null;
		this.rear=null;
		this.count=0;
	}
	//Removes the first element in this list and returns a reference to the element
	@Override
	public T removeFirst() throws EmptyCollectionException {
		
		if(isEmpty()) {
			throw new EmptyCollectionException("List");
		}else {
			LinearNode<T> result=front;
			front=front.getNext();
			if(front==null) {
				rear=null;
				
			}
			count--;
			return result.getElement();
		}
		
	}
	
	@Override
	public T removeLast() throws EmptyCollectionException {
		
		LinearNode<T> previous=null;
		LinearNode<T> actual=front;
		if(isEmpty()) {
			throw new EmptyCollectionException("List");
		}else {
			while(actual.getNext()!=null) {
				previous=actual;
				actual=actual.getNext();
			}
			LinearNode<T> result=rear;
			rear=previous;
			if(rear==null) {
				front=null;
				
			}else {
				rear.setNext(null);
				
			}
			count--;
			return result.getElement();
		}
		
		
	}
	
	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
		if(isEmpty()) {
			throw new EmptyCollectionException("List");
		}else {
			boolean found=false;
			LinearNode<T> previous=null;
			LinearNode<T> actual=front;
			while(actual.getNext()!=null && !found) {
				if(actual.getElement()==element) {
					found=true;
				}else {
					previous=actual;
					actual=actual.getNext();
				}
			}
			LinearNode<T> result= new LinearNode<>();
			if(!found) {
				throw new ElementNotFoundException("List");
			}else {
				if(size()==1) {//the list has only one element
					result=front;
					front=null;
					rear=null;
				}else if(actual.equals(front)) {//the element is the first one
					result=front;
					front=actual.getNext();
					
				}else if(actual.equals(rear)) {//the element is the last one
					result=rear;
					rear=previous;
					previous.setNext(null);
				}else {
					result=actual;
					previous.setNext(actual.getNext());
				}
				count--;
			}
			return result.getElement();
		}
		
	}
	//Returns the first element in the list
	@Override
	public T first() {
		return front.getElement();
	}
	//Returns the last element in the list
	@Override
	public T last() {
		return rear.getElement();
	}
	//Returns true if the specified element is found in the list
	@Override
	public boolean contains(T target) throws EmptyCollectionException{
		if(isEmpty()) {
			throw new EmptyCollectionException("List");
		}else {
			LinearNode<T> actual=front;
			boolean found=false;
			while(actual.getNext()!=null && !found) {
				if(actual.getElement().equals(target)) {
					found=true;
				}else {
					actual=actual.getNext();
				}
			}
			return found;
		}
	}
	//Returns true if the list is empty
	@Override
	public boolean isEmpty() {
		return this.count==0;
	}
	//Returns the size of the list
	@Override
	public int size() {
		return this.count;
	}
	//Returns 
	@Override
	public Iterator<T> iterator() {
		return new LinkedIterator<T>(front,count);
	}
	
	public void add(T elem) {
		LinearNode<T> newNode= new LinearNode<>(elem);
		if(isEmpty()) {
			front=newNode;
			rear=newNode;
		}else {
			rear.setNext(newNode);
			rear=newNode;
		}
	}
	
	
	
}
