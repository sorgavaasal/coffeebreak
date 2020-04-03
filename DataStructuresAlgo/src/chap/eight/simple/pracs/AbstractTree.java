package chap.eight.simple.pracs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
	
	private List<Position<E>> lazySnapShot = null;
	protected int size;

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		return p == getRoot();
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	/**
	 * gets the depth of the position in the query recursively 
	 * @param p
	 * @return
	 */
	public int depth(Position<E> p) {
		if (isRoot(p)) {
			return 0;
		} else {
			return 1 + depth(getParent(p));
		}
	}

	/**
	 * gets the height of the tree from the position queried 
	 * This method is implemented recursively 
	 * @param p
	 * @return
	 */
	public int height(Position<E> p) {
		int h = 0;
		
		for (Position<E> pc : getChildren(p)) 
			h = Math.max(h, 1 + height(pc));
		
		return h;
	}

	@Override
	public Iterable<Position<E>> getPositions() {
		//return preOrder();
		return postOrder();
	}
	
	public Iterable<Position<E>> preOrder() {
		List<Position<E>> snapShot = new ArrayList<>();
		
		if (!isEmpty()) {
			preOrderSubTree(getRoot(), snapShot);
		}
		return snapShot;
	
	}
	
	/***
	 * 
	 * @param rootNode
	 * @param snapShot
	 */
	private void preOrderSubTree(Position<E> rootNode, List<Position<E>> snapShot) {
		snapShot.add(rootNode);
		for (Position<E> p : getChildren(rootNode)) {
			preOrderSubTree(p, snapShot);
		}

	}
	
	public Iterable<Position<E>> postOrder() {
		List<Position<E>> snapShot = new ArrayList<>();

		if (!isEmpty()) {
			postOrderSubTree(getRoot(), snapShot);
		}
		
		return snapShot;
	}
	/***
	 * 
	 * @param rootNode
	 * @param snapShot
	 */
	private void postOrderSubTree(Position<E> rootNode, List<Position<E>> snapShot) {
		for (Position<E> p: getChildren(rootNode)) {
			postOrderSubTree(p, snapShot);
		}
		
		snapShot.add(rootNode);
	}
	
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	
	private class ElementIterator implements Iterator<E> {
		
		Iterator<Position<E>> postIterator = getPositions().iterator();

		@Override
		public boolean hasNext() {
			return postIterator.hasNext();
		}

		@Override
		public E next() {
			return postIterator.next().getElement();
		}
		
		public void remove() {
			postIterator.remove();
		}
		
	}
	
	public List<Position<E>> getLazyList() {
		return this.lazySnapShot;
	}

	private Position<E> lazyLoading() {

		Position<E> currentLocation = null;

		if (lazySnapShot == null) {
			lazySnapShot = new ArrayList<>();
			lazySnapShot.add(getRoot());
			return getRoot();
		} else if (lazySnapShot.size() == this.size) {
			return lazySnapShot.get(0);
		}  

		currentLocation = lazySnapShot.get(0);
		//*TODO
		//* almost there, this logic has to be fixed 
		Position<E> nextLocation = ((List<Position<E>>) getChildren(currentLocation)).get(0);
		lazySnapShot.add(nextLocation);
		return nextLocation;
	}	
	
	public Position<E> getNextLazy() {
		return lazyLoading();
	}
	
}
