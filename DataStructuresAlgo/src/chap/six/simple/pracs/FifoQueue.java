package chap.six.simple.pracs;

import chap.three.simple.pracs.SingleLinkedList;

public class FifoQueue<E> {

	private SingleLinkedList<E> queue;
	
	public FifoQueue() {
		queue = new SingleLinkedList<>();
	}
	
	public void enqueue(E e) {
		queue.addLast(e);
	}
	
    public E dequeue() {
    	E element = queue.removeFirst();
    	return element;
    }
    
    public boolean isEmpty() {
    	return queue.isEmpty();
    }
    
    public int getSize() {
    	return queue.getSize();
    }

}
