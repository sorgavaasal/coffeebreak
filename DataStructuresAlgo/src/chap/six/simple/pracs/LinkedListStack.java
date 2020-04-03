package chap.six.simple.pracs;

import chap.three.simple.pracs.SingleLinkedList;

public class LinkedListStack<E> {
	
	private SingleLinkedList<E> linkedList;
	
	public LinkedListStack () {
		linkedList = new SingleLinkedList<>();
	}
	
	public boolean push(E element) {
		linkedList.addFirst(element);
		return true;
	}
	
	/***
	 * empties the content of the stack,
	 * non recursively 
	 * @return
	 */
	public boolean emptyStack() {
		if (this.getSize() == 0) 
			return false;
		while (this.getSize() != 0) {
			pop();
		}
		
		return true;
 	}
	
	/***
	 * 
	 * @return
	 */
	public E top() {
		return linkedList.getFirst(); 
	}
	
	/***
	 * 
	 * @return
	 */
	public E pop() {
		return linkedList.removeFirst();
	}
	
	public int getSize() {
		return linkedList.getSize();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
}
