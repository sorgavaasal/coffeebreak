package chap.eight.simple.pracs;

public class BinaryNode<E> implements Position<E> {

	private E element;
	private BinaryNode<E> parent;
	private BinaryNode<E> left;
	private BinaryNode<E> right;
	
	public BinaryNode (E element, BinaryNode<E> parent, BinaryNode<E> left, BinaryNode<E> right) {
		this.element = element;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public E getElement() throws IllegalStateException {
		return element;
	}
	
	public void setElement(E element) {
		this.element = element;
	}

	public BinaryNode<E> getParent() {
		return parent;
	}

	public void setParent(BinaryNode<E> parent) {
		this.parent = parent;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<E> leftChild) {
		this.left = leftChild;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	public void setRight(BinaryNode<E> rightChild) {
		this.right = rightChild;
	}

}
