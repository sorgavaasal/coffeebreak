package chap.eight.simple.pracs;

import java.util.Iterator;

/***
 * Simple interface for the structure of 
 * a Tree class
 * @author srividhya
 *
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
	 
	Position<E> getRoot();
	
	Position<E> getParent(Position<E> p) throws IllegalArgumentException;
	
	Iterable<Position<E>> getChildren(Position<E> p) throws IllegalArgumentException;
	
	int numChildren(Position<E> p) throws IllegalArgumentException;
	
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
	
	int getSize();
	
	boolean isEmpty();
	
	Iterator<E> iterator();
	
	Iterable<Position<E>> getPositions(); 
	
}
