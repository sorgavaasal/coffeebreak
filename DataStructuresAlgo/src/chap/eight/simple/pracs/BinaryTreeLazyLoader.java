package chap.eight.simple.pracs;

import java.util.ArrayList;
import java.util.List;

import chap.six.simple.pracs.LinkedListStack;

public class BinaryTreeLazyLoader<E> extends LinkedBinaryTree<E> {
	
	private Position<E> curr;
	private Position<E> prev;
	private LinkedListStack<Position<E>> stack = new LinkedListStack<>();
	private List<Position<E>> accumlator;
	
	public BinaryTreeLazyLoader() {
		curr = getRoot();
		stack.push(curr);
		accumlator = new ArrayList<Position<E>>();
	}

	public Position<E> getPreOrderLazynext() {
		
		if (accumlator.size() == size) {
			return null;
		} else if (accumlator.size() == 0) {
			
		}

		Position<E> currPop = stack.pop();
		accumlator.add(currPop);
		
		if (left(currPop) != null) {
			stack.push(left(currPop));
		}
		
		if (right(currPop) != null) {
			stack.push(right(currPop));
		}
		
		curr = currPop;
		return currPop;
	}
	
	public Position<E> getPostOrderLazynext()  {
		
		if (accumlator.size() == this.size) {
			return null;
		}

		Position<E> currPop = stack.top();
		
		while (true) {
			if (prev == null || left(prev) == curr || right(prev) == curr) {
				if (left(currPop) != null) {
					stack.push(left(currPop));
				} else if (right(currPop) != null) {
					stack.push(right(currPop));
				}
			} else if (prev == left(curr)) {
				if (right(curr) != null) {
					stack.push(right(curr));
				}
			} else {
				currPop = stack.pop();
				accumlator.add(currPop);
				prev = currPop;
				break;
			}
			prev = currPop;
		}
		
		return currPop;
	}
	
    public Position<E> getInOrderLazyList() {
    	
    	return null;
    }
	
	public List<Position<E>> getAccumlator() {
		return this.accumlator;
	}

}
