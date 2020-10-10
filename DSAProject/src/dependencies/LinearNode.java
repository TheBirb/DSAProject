package dependencies;

public class LinearNode<E>{
	private LinearNode<E> next;
	private E elem;
	
	 public LinearNode() {
		 this.elem=null;
		 this.next=null;
	 }
	 public LinearNode(E elem) {
		 this.next=null;
		 this.elem=elem;
	 }
	
	
	public void setElement(E element) {
		this.elem=element;
	}
	public E getElement() {
		return this.elem;
	}
	
	public void setNext(LinearNode<E> nextNode) {
		
		this.next=nextNode;
	}
	public LinearNode<E> getNext() {
		return this.next;
	}
	 
	
}
