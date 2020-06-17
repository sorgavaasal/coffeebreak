package chap.eighta.simple.pracs.udemy.tree;

public class BinaryNode<E> {
	
	private E element;
	private BinaryNode<E> leftNode;
	private BinaryNode<E> rightNode;
	
	public BinaryNode() {
	}
	
	public BinaryNode(E element) {
		this.element = element;
	}
	
	public BinaryNode(E element, BinaryNode<E> leftNode) {
		this.element = element;
		this.leftNode = leftNode;
	}
	
	public BinaryNode(E element, BinaryNode<E> leftNode, BinaryNode<E> rightNode) {
		this.element = element;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public E getElement() {
		return element; 
	}
	
	public void setElement(E element) {
		this.element = element;
	}
	
	public void setLeftNode(BinaryNode<E> left) {
		this.leftNode = left;
	}
	
	public BinaryNode<E> getLeftNode() {
		return this.leftNode;
	}
	
	public void setRightNode(BinaryNode<E> right) {
		this.rightNode = right;
	}
	
	public BinaryNode<E> getRightNode() {
		return this.rightNode;
	}
	

}
