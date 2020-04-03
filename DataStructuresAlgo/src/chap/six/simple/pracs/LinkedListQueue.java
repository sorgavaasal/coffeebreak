package chap.six.simple.pracs;

import chap.three.simple.pracs.SingleLinkedList;

public class LinkedListQueue<E> {
	
	private SingleLinkedList<E> queue;
	
	public LinkedListQueue() {
		queue = new SingleLinkedList<>();
	}
	
	public boolean enqueue(E element) {
		queue.addLast(element);
		return true;
	}
	
	public E dequeue() {
		E element = queue.getFirst();
		queue.removeFirst();
		return element;
	}
	
	public E first() {
		return queue.getFirst();
	}
	
	public boolean isEmpty() {
		return queue.getSize() == 0;
	}
	
	public int getSize() {
		return queue.getSize();
	}

}
