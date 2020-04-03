package chap.three.simple.pracs;

/**
 * Node class created for LinkedList
 * @author Sridhar Raman
 *
 */
public class Node<E> {
	
	private E element;
	private Node<E> next;
	
	public Node (E e, Node<E> next) {
		this.element = e;
		this.next = next;
	}
	
	public E getElement() {
		return element;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public Node<E> getNext() {
		return this.next;
	}

}
