package structures;
import Social.Person;

public class LinkedOrderedFameList extends LinkedList<Person>{
	public LinkedOrderedFameList() {
		super();
	}
	
	@Override
	public void add(Person p,int inde) {
		System.out.println("You cannot choose the index in this list");
		add(p);
	}
	
	@Override
	public void addToTail(Person p) {
		System.out.println("In this data structure you cant chose this");
		add(p);
	}
	@Override
	public void addToHead(Person p) {
		System.out.println("In this data structure you cant chose this");
		add(p);
		
	}
	
	
	public void add(Person p) {
		int num= p.getNumFriends();
		LinearNode<Person> newNode= new LinearNode<>(p);
		
		if(isEmpty()) {
			
			head=newNode;
			tail=newNode;
		}else {
			if(size()==1) {
				
				if(head.getElement().getNumFriends()>=num) {
					head.setNext(newNode);
					tail=newNode;
				}else {
				 newNode.setNext(head);
				 head=newNode;
				}
				
					
				
			}else {
				
				LinearNode<Person> actual=head;
				LinearNode<Person> previous=null;
				while(actual.getElement().getNumFriends()>num&&actual.getNext()!=null) {
					previous=actual;
					actual=actual.getNext();
				}
				if(actual.getNext()==null) {
					if(actual.getElement().getNumFriends()>num) {
						actual.setNext(newNode);
						tail=newNode;
					}else {
						newNode.setNext(actual);
						previous.setNext(newNode);
					}
				}else {
					newNode.setNext(actual);
					previous.setNext(newNode);
				}
			}
			}
		count++;
	}
	
	public String toString() {
		System.out.println();
		LinearNode<Person> actual=head;
		String result="";
		while(actual.getNext()!=null) {
			result=result+"s:  "+actual.getElement().getNumFriends()+" ";
			
			actual=actual.getNext();
		}
		result=result+"s:  "+actual.getElement().getNumFriends()+" ";
		return result;
	}
}
