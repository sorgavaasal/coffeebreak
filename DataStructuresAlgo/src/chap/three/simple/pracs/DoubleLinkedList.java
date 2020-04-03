package chap.three.simple.pracs;

public class DoubleLinkedList<E> {
	
	private INode<E> head = null;
	private INode<E> tail = null;
	private int size;
	
	public DoubleLinkedList() {
		head = new INode<>(null, null, null);
		tail = new INode<>(null, null, head);
		head.setNext(tail);
	}
	
	public int getSize() {
		return this.size;
	}
	
	/***
	 * @param element
	 */
	public void addFirst(E element) {
		this.addBetween(element, head.getNext(), head);
		++size;
	}
	
	public void addBetween(E element, INode<E> next, INode<E> prev) {
		INode<E> curr = new INode<E>(element, next, prev);
		prev.setNext(curr);
		next.setPrev(curr);
	}
	
	/***
	 * @param element
	 */
	public void addLast(E element) {
		this.addBetween(element, this.tail, this.tail.getPrev());
		++size;
	}
	
	public E removeFirst() {
		if (this.size == 0) return null;
		INode<E> returnNode = this.head.getNext();
		INode<E> secondNode = returnNode.getNext();
		this.head.setNext(secondNode);
		this.head.setPrev(this.head);
		--size;
		return returnNode.getElement();
	}
	
	public E removeLast() {
		if (this.getSize() == 0) return null;
		INode<E> returnNode = this.tail.getPrev();
		INode<E> secondLNode = returnNode.getPrev();
		this.tail.setPrev(secondLNode);
		--size;
 		return returnNode.getElement();
	}
	
	public E remove(INode<E> node) {
		INode<E> predecessor = node.getPrev();
		INode<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		--size;
		return node.getElement();
	}
	
	public INode<E> getNext(INode<E> input) {
		return input.getNext();
	}
	
	public INode<E> getPrev(INode<E> input) {
		return input.getPrev();
	}
	
	public INode<E> getHead() {
		return this.head;
	}
	
	public INode<E> getTail() {
		return this.tail;
	}
    	
	public E getFirst() {
		if (this.getSize() == 0) return null;
		return this.head.getNext().getElement();
	}
	
	public E getLast() {
		if (this.getSize() == 0) return null;
		return this.tail.getPrev().getElement();
	}
	
	public boolean isEmpty() {
		if (this.getSize() == 0)
			return true;
		return false;
	}

}
