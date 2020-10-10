package dependencies;


import person.Person;

public class LinkedOrderedFameList extends LinkedPersonList{
	
	public LinkedOrderedFameList() {
		super();
	}
	
	//TODO hay que hacer que meta a la gente de forma ordenada
	public void add(Person p) {
		int num= p.numberOfFriends();
		LinearNode<Person> newNode= new LinearNode<>(p);
		
		if(isEmpty()) {
			
			front=newNode;
			rear=newNode;
		}else {
			if(size()==1) {
				
				if(front.getElement().numberOfFriends()>=num) {
					front.setNext(newNode);
					rear=newNode;
				}else {
				 newNode.setNext(front);
				 front=newNode;
				}
				
					
				
			}else {
				
				LinearNode<Person> actual=front;
				LinearNode<Person> previous=null;
				while(actual.getElement().numberOfFriends()>num&&actual.getNext()!=null) {
					previous=actual;
					actual=actual.getNext();
				}
				if(actual.getNext()==null) {
					if(actual.getElement().numberOfFriends()>num) {
						actual.setNext(newNode);
						rear=newNode;
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
	public void famousThree() {
		if(size()<3) {
			System.out.println("Not enough people in the network");
		}else {
			LinearNode<Person> actual=front;
			for(int i=0; i<3; i++) {
				System.out.println(i+1+":"+actual.getElement().getId());
				actual=actual.getNext();
				
			}
		}
	}


	public String toString() {
		System.out.println();
		LinearNode<Person> actual=front;
		String result="";
		while(actual.getNext()!=null) {
			result=result+"s:  "+actual.getElement().numberOfFriends()+" ";
			
			actual=actual.getNext();
		}
		result=result+"s:  "+actual.getElement().numberOfFriends()+" ";
		return result;
	}
}
