package chap.eighta.simple.pracs.udemy.tree;

public interface IBinaryTree<E> {
	
	public BinaryNode<E> insertNode(BinaryNode<E> node);
	
	public BinaryNode<E> lookUp(BinaryNode<E> node);

}
