package chap.six.simple.pracs;

import chap.three.simple.pracs.Node;

public class SingleLinkedListLeaky<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private int maxCapacity;
	private static final int STACK_LIMIT = 5;
	
	public SingleLinkedListLeaky() {
	
		
	}
	
	public SingleLinkedListLeaky(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public void addFirst(E e) {
		
		int stackSize = this.getSize();
		if (this.maxCapacity != 0 && ++stackSize > this.maxCapacity) {
		    //rollback logic
            E removedElement = this.removeLast(); 
            System.out.println("RemoveElement " +removedElement);
		}
		
		head = new Node<E>(e, head);

		if (this.size == 0) {
			tail = head;
		}
		
		++size;
	}	

	public int getSize() {
		return this.size;
	}
	
	public E getHead() {
		return this.head.getElement();
	}
	
	public E getTail() {
		return this.tail.getElement();
	}
	
	public void addLast(E e) {
		if (this.maxCapacity != 0 && this.getSize() >= this.maxCapacity) {
			System.out.println("StackCapacityReached!!!!");
			return;
		}
		Node<E> newest = new Node<E>(e, null);
		if (this.getSize() == 0) {
			addFirst(e);
			return;
		} else {
			tail.setNext(newest);
			tail = newest;
		}
		++size;
	}
	
	public boolean isEmpty() {
		if (this.size == 0) 
			return true;
		return false;
	}
	
	public E removeFirst() {
		if (this.size == 0) 
			return null;
		E e = head.getElement();
		head = head.getNext();
		this.size--;
		return e;
	}
	
	/***
	 * loop to remove the last node from the single LinkedList 
	 * @return
	 */
	public E removeLast() {
		if (this.maxCapacity == 0) {
			System.out.println("incorrect Operation ");
			System.out.println("bottom less Stack");
			return null;
		} 
		
		if (this.size > 0) {
			Node<E> nextNode = head.getNext();
			Node<E> prevNode = null;
			while (nextNode != null) {
				if (nextNode.getNext() == null) {
					Node<E> lastNode = nextNode;
					this.tail = prevNode;
					this.tail.setNext(null);
					this.size--;
					return lastNode.getElement();
				}
				prevNode = nextNode;
				nextNode = nextNode.getNext();
			}
		} 
			
		return null;
	}
	
}
