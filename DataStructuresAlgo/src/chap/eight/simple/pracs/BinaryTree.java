package chap.eight.simple.pracs;

public interface BinaryTree<E> extends Tree<E> {
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException;
	 
	public Position<E> right(Position<E> p) throws IllegalArgumentException; 
	
	public Position<E> getSibling(Position<E> p) throws IllegalArgumentException; 

}
