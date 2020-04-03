package chap.six.simple.pracs;

import chap.three.simple.pracs.Node;

public interface Stack<I> {
	
	public void push(Node<I> entry);
	
	public Node<I> pop();
	
	public Boolean isEmpty();
	
	public Node<I>[] toArray();
	
	public int getSize();

}
