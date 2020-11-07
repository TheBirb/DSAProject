package structures;

import java.util.Iterator;

import Exceptions.ElementNotFoundException;
import Social.Person;
/**
 * Binary search tree for the class person ordered by id's
 * @author ikerb
 *
 */
public class BinarySearchID extends LinkedBinarySearchTree<Person> implements Iterable<Person>{
	/**
	 * Basic constructor of the class that calls the constructor of the superclass
	 */
	public BinarySearchID() {
		super();
	}
	/**
	 * ordered adder for the class
	 * @param p-The person
	 */
	public void add(Person p) {
		this.addElement(p);
	}
	/**
	 * removes a person and returns that same person
	 * @param p-The person to return
	 * @return the removed person
	 * @throws ElementNotFoundException
	 */
	public Person remove(Person p) throws ElementNotFoundException {
		return this.removeElement(p);
	}
	@Override
	/**
	 * Returns an iterator for the BinarySearchTree
	 */
	public Iterator<Person> iterator() {
		
		return this.iteratorInOrder();
	}
	/**
	 * converts the tree into a list
	 * @return
	 */
	public LinkedList<Person> toList(){
		LinkedList<Person> ret=new LinkedList<Person>();
		inorder(root,ret);
		/*Iterator<Person> it=this.iterator();
		while(it.hasNext()) {
			ret.addToTail(it.next());
		}*/
		return ret;
	}
	/**
	 * converts the tree into a tree ordered by fame
	 * @return
	 */
	public LinkedList<Person> toFameList(){
		LinkedList<Person> ret=new LinkedList<Person>();
		Iterator<Person> it=this.iterator();
		BinarySearchFriends bin=new BinarySearchFriends();
		while(it.hasNext()) {
			bin.add(it.next());
		}
		it=bin.iterator();
		while(it.hasNext()) {
			ret.addToHead(it.next());
		}
		return ret;
	}
}
