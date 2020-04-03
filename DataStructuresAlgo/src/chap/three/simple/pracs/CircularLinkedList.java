package chap.three.simple.pracs;

public class CircularLinkedList<E> {
	
	public CircularLinkedList() {
		
	}
	
	private Node<E> tail = null;
	private int size = 0;
	
	//*TODO remove the below lines of overview comments 
	//*TODO after the linkedList is completely Coded 
	/**
	 * methods 
	 * addFirst(E e) return void
	 * addLast(E e) return void 
	 * rotate() return void 
	 * removeFirst() return the current first element 
	 * getFirst() return E return the first element in the linkedList
	 * getLast() return E return the Last element in the linkedList
	 */
	
	public int getSize() {
		return size;
	}

	/**
	 * checks if the circular linkedList is empty or not 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		if (tail == null) {
			tail = new Node<>(e, null);
			tail.setNext(null);
		} else {
			Node<E> newest = new Node<>(e, null);
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e) {		
		if (tail == null) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, null);
			newest.setNext(tail.getNext());
			tail.setNext(newest);
			tail = newest;
		}
		size++;
	}
	
	/**
	 * set the tail to the next element of the 
	 * current tail 
	 */
	public void rotate() {
		if (tail != null) {
			tail = tail.getNext();
		}
	}
	
	/**
	 * get the first element in the linkedList
	 * @return
	 */
	public E getFirst() {
		if (tail != null) {
			return tail.getNext().getElement();
		} else {
			return null;
		}
	}
	
	/**
	 * gets the current tail in the linkedList 
	 * @return
	 */
	public E getLast() {
		if (tail != null) {
			return tail.getElement();
		} else {
			return null;
		}
	}
	
	/**
	 * sets the 2nd element in the linkedList as 
	 * the tails next, leaving the current 
	 * head to get garbage collected 
	 * @return
	 */
	public E removeFirst() {
		if (isEmpty()) return null;
		Node<E> head = tail.getNext();
		if (head == tail) {
			tail = null;
			return head.getElement();
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}
}
