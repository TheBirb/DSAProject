package dependencies;

import exceptions.EmptyCollectionException;
import person.Person;

public class LinkedPersonList extends LinkedList<Person> {
	
	public LinkedPersonList() {
		super();
	}
		public void setFriendShip(String uId1, String uId2) {
		
			LinearNode<Person> actual=front;
		
			boolean done=false;
			while(!done && actual!=null) {
				if(actual.getElement().getId()==uId1) {
					actual.getElement().addFriend(uId2);
					done=true;
				}
				actual=actual.getNext();
			}
			actual=front;
			done=false;
			while(!done && actual!=null) {
				if(actual.getElement().getId()==uId2) {
					actual.getElement().addFriend(uId1);
					done=true;
				}
				actual=actual.getNext();
			}
		
		}
		
		public void add(Person elem) {
			LinearNode<Person> newNode= new LinearNode<>(elem);
			if(isEmpty()) {
				front=newNode;
				rear=newNode;
			}else {
				rear.setNext(newNode);
				rear=newNode;
			}
		}
		
		public boolean isId(String id) throws EmptyCollectionException{
			if(isEmpty()) {
				throw new EmptyCollectionException("List");
			}else {
				LinearNode<Person> actual=front;
				boolean found=false;
				while(actual.getNext()!=null && !found) {
					if(actual.getElement().getId()==id) {
						found=true;
					}else {
						actual=actual.getNext();
					}
				}
				return found;
			}
		}
}
