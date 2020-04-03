package chap.three.simple.pracs;

public class SingleLinkedList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SingleLinkedList() {

	}

	public int getSize() {
		return this.size;
	}

	public E getFirst() {
		if (isEmpty()) {
			return null;
		}

		return head.getElement();
	}

	/**
	 * return tail element from the linked list
	 * 
	 * @return
	 */
	public E getTail() {
		if (isEmpty()) {
			return null;
		}

		return tail.getElement();
	}
	
	/**
	 * returns the head node
	 * @return
	 */
	public Node<E> getHead() {
		return head;
	}
	
	/**
	 * returns the next node to the current node 
	 * @param current
	 * @return
	 */
	public Node<E> getNext(Node<E> current) {
		return current.getNext();
	}

	/**
	 * add the first element to the node
	 * 
	 * @param e
	 * @return
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head); // current head becomes next to the new head

		if (size == 0) {
			tail = head; // since the size is 0, head and tail point to the same
							// Node.
		}
		this.size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			addFirst(e);
		} else {
			tail.setNext(newest);
			size++;
			tail = newest;
		}
	}

	/**
	 * remove the first element from the 
	 * SingleLikedList
	 * @return
	 */
	public E removeFirst() {
		if (isEmpty())
			return null;
		E currFirst = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return currFirst;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

}
