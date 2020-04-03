package chap.six.simple.pracs;

import chap.three.simple.pracs.Node;

public abstract class StackAdt<I> implements Stack<I> {
	
	private int size;
	
	private Node<I> head;
	
	public StackAdt(Node<I> element) {
		++size;
		this.head = element;
	}
	
	public StackAdt() {
		this.head = null;
	}
	
	public Node<I> peek() {
		if (this.head == null) 
			return null;
		
		return this.head;
	}
	
	public void push(Node<I> element) {
		++size;
		if (this.head == null) {
			this.head = element;
			this.head.setNext(null);
			return;
		}
		
		element.setNext(this.head);
		this.head = element;
	}
	
	public Node<I> pop() {
		Node<I> data = this.head;
		this.head = this.head.getNext();
		this.size--;
		return data;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Boolean isEmpty() {
		return getSize() == 0;
	}
	
	public Node<I> getHead() {
		return this.head;
	}

}
