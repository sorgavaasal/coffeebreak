package chap.five.simple.pracs;

public class SingleLinkedList<E> {
	
	public SingleLinkedList () {
		
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public Node<E> getFirst() {
		if (this.getSize() == 0) 
			return null;
		return this.head;
	}
	
	public Node<E> getTail() {
		if (this.getSize() == 0) 
			return null;
		return this.tail;
	}
	
	public int getSize() {
		return this.size;
	}

	public void addFirst(Node<E> input) {
		if (size == 0) {
			this.head = input;
			this.tail = input;
		} else {
			input.setNext(this.head);
			this.head = input;
		}
			this.size++;
	}
	
	public void addLast(Node<E> input) {
		if (size == 0) {
			this.tail = input;
			this.head = input;
		} else {
			input.setNext(this.tail);
			this.tail = input;
		}
		
		this.size++;
	}
	
	public Node<E> removeFirst() {
		if (this.getSize() == 0) {
			return null;
		} else {
			Node<E> headNode = this.getFirst();
			this.head = headNode.getNext();
			this.size--;
			return headNode;
		}
	}
	
	public void reverseSingleLinkedListRecur(SingleLinkedList<E> list, Node<E> prev, Node<E> next, int i) {
		
		if (next == null && prev == null) {
			next = list.getFirst().getNext();
			prev = list.getFirst(); //N1
			list.getFirst().setNext(null);
			this.tail = prev;
		} else {
		     
			 Node<E> nextTemp = null;
		     if (next.getNext() != null) {
				nextTemp = next.getNext();
			 } else {
				nextTemp = prev;
				this.head = next;
			 }
			  
			 next.setNext(prev);
			 prev = next;
			 next = nextTemp;

		}
		
		++i;
		if (i < list.getSize()) {
			reverseSingleLinkedListRecur(list, prev, next, i);
		}
	}

}
