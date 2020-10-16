package structures;

import Exceptions.AlreadyAddedFriend;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Social.Person;
/**
 * Class for a Person class object type that has the people ordered by fame
 * @author Jon Moriñigo
 *
 */
public class LinkedOrderedFameList extends LinkedList<Person>{
	/**
	 * Constructor of the class
	 */
	public LinkedOrderedFameList() {
		super();
	}
	
	/**
	 * adds a person ordered by the number of friends, we should only use
	 * this method out of the structure to add people
	 * @param p-The person
	 */
	public void add(Person p) {
		int num= p.getNumFriends();
		int i=0;
		if(isEmpty()) {
			
			super.addToHead(p);
		}else {
			if(size()==1) {
				
				if(head.getElement().getNumFriends()>=num) {
					super.addToTail(p);
				}else {
				 super.addToHead(p);
				}
				
					
				
			}else {
				
				LinearNode<Person> actual=head;
				//LinearNode<Person> previous=null;
				while(actual.getElement().getNumFriends()>num&&actual.getNext()!=null) {
					//previous=actual;
					actual=actual.getNext();
					i++;
				}
				if(actual.getNext()==null) {
					if(actual.getElement().getNumFriends()>num) {
						super.addToTail(p);
					}else {
						super.add(p, i);
					}
				}else {
					super.add(p, i);
				}
			}
		}
	}
	/**
	 * Adds a relation and reorders the list
	 * @param p: person one of the relation
	 * @param target: person two of the relation
	 * @throws ElementNotFoundException when the elements are not on the list.
	 */
	public void AddOrderedFriend(Person p,Person target) throws ElementNotFoundException{
		if(this.contains(p)&&this.contains(target)) {
			p=this.get(this.getIndex(p));//making sure that the introduced element is from the list and not an equivalent
			p=this.get(this.getIndex(p));//making sure that the introduced element is from the list and not an equivalent
			try {
				p.addFriend(target);
			} catch (AlreadyAddedFriend e) {
				System.out.println("\n \u001B[31m"+"Already added friend"+"\u001B[0m \n");
			}
			update(p);
			update(target);
			
		}else throw new ElementNotFoundException();
	}
	/**
	 * updates the position of a Person
	 * @param p:the person to update
	 */
	public void update(Person p) {
		
		try {
			this.remove(p);
		} catch (EmptyCollectionException e) {
			System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
	
		} catch (ElementNotFoundException e) {
			System.out.println("\n \u001B[31m"+"Element not found"+"\u001B[0m \n");
		}
		add(p);
	
	}
	
}
