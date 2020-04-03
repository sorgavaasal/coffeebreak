package chap.three.simple.pracs;

public class DoubleEndedQueue<E> {
	
	private DoubleLinkedList<E> queue;
	
	public DoubleEndedQueue() {
		queue = new DoubleLinkedList<>();
	}
	
	public boolean addFirst(E e) {
		queue.addFirst(e);
		return true;
	}
	
	public boolean addLast(E e) {
		queue.addLast(e);
		return true;
	}
	
	public E removeFirst() {
		return queue.removeFirst();
	}
	
	public E removeLast() {
		return queue.removeLast();
	}
	
	public E getFirst() {
		return queue.getFirst();
	}
	
	public E getLast() {
		return queue.getLast();
	}
	
	public boolean isEmpty() {
		return queue.getSize() == 0;
	}
	
	public int getSize() {
		return queue.getSize();
	}
 }
