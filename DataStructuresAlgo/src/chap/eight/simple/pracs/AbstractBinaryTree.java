package chap.eight.simple.pracs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public Iterable<Position<E>> getChildren(Position<E> p) throws IllegalArgumentException {
		List<Position<E>> snapShot = new ArrayList<>(2); //since the max capacity of the child of a binary tree will only be 2
		if (left(p) != null ) {
			snapShot.add(left(p));
		} 
		
		if (right(p) != null ) {
			snapShot.add(right(p));
		}
		
		return snapShot;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0;
		if (left(p) != null) {
			++count;
		}
		if (right(p) != null) {
			++count;
		}
		return count;
	}

	@Override
	public Position<E> getSibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = getParent(p);
		if (parent == p) {
			return null;
		}
		if (p == left(parent)) {
			return right(p);
		} else {
			return left(p);
		}
	}
	
	public Iterable<Position<E>> getInOrderPositions() {
		return inorder();
	}

	public Iterable<Position<E>> inorder() {
		List<Position<E>> snapShot = new ArrayList<>();
		
		if (!isEmpty()) {
			inorderSubTree(getRoot(), snapShot);
		}
		
		return snapShot;
	}
	
	public void inorderSubTree(Position<E> p, List<Position<E>> snapShot) {
		if (left(p) != null) {
			inorderSubTree(left(p), snapShot);
		}
		snapShot.add(p);
		
		if (right(p) != null) {
			inorderSubTree(right(p), snapShot);
		}
	}
	  
}
