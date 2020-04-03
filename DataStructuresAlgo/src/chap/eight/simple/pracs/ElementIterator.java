package chap.eight.simple.pracs;

import java.util.Iterator;

public class ElementIterator<E> implements Iterator<E> {
	
	public Iterator<E> iterator() {
 		return new ElementIterator<E>();
	}
	
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

}
