package chap.eight.simple.pracs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chap.six.simple.pracs.LinkedListStack;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	protected BinaryNode<E> root = null;
	protected E element;
	
	
	protected BinaryNode<E> createNode(E e, BinaryNode<E> parent, BinaryNode<E> left, BinaryNode<E> right) {
		return new BinaryNode<E>(e, parent, left, right);
	}
	
	protected BinaryNode<E> validate (Position<E> p) throws IllegalArgumentException{
		
		if (!(p instanceof BinaryNode)) {
			throw new IllegalArgumentException("parameter not an instance of BinaryNode");
		}
		
		BinaryNode<E> node = (BinaryNode<E>) p;
		if (node.getParent() == node ) {
			throw new IllegalArgumentException("Node is not part of the tree anymore");
		}
		
		return node;
	}

	/**
	 * returns the left child of the node
	 */
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		BinaryNode<E> node= validate(p);
		return node.getLeft();
	}

	/**
	 * returns the right child of the node
	 */
	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		return node.getRight();
	}

	/***
	 * returns the root node from the LinkedBinary Tree
	 */
	@Override
	public Position<E> getRoot() {
		return this.root;
	}

	@Override
	public Position<E> getParent(Position<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		return node.getParent();
	}

	/***
	 * returns the current size of the Binary Tree
	 */
	@Override
	public int getSize() {
		return this.size;
	}
	 
	public Position<E> addRoot(E e) throws IllegalArgumentException {
		
		if (!(isEmpty())) {
			throw new IllegalArgumentException("LinkedBinary Tree is not empty");
		}
		
		root = createNode(e, null, null, null);
		++size;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) {
		BinaryNode<E> parent = validate(p);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("left already present for the node");
		}
		
		BinaryNode<E> leftChild = createNode(e, parent, null, null);
		parent.setLeft(leftChild);
		++size;
		return leftChild;
	}
	
	public Position<E> addRight(Position<E> p, E e) {
		BinaryNode<E> parent = validate(p);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("right already present for the node");
		}
		
		BinaryNode<E> rightChild = createNode(e, parent, null, null);
		parent.setRight(rightChild);
		++size;
		return rightChild;
	}
	
	public E setElement(Position<E> p, E e) {
		BinaryNode<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	public void attach(BinaryNode<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
		BinaryNode<E> node = validate(p);

		if (isInternal(p)) {
			throw new IllegalArgumentException("The position is internal, cannot add leaves ");
		}

		if (!t1.isEmpty()) {
			((BinaryNode<E>) t1.getRoot()).setParent(p);
			node.setLeft((BinaryNode<E>) t1.getRoot());
			t1.root = null;
			t1.size = 0;
		}

		if (!t2.isEmpty()) {
			((BinaryNode<E>) t2.getRoot()).setParent(p);
			node.setLeft((BinaryNode<E>) t2.getRoot());
			t1.root = null;
			t1.size = 0;
		}
		
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException {
		BinaryNode<E> node = validate(p);
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("Node internal with two childs cannot remove");
		}
		
		BinaryNode<E> childNode = node.getLeft() != null ? node.getLeft() : node.getRight();
	
		if (childNode != null) {
			childNode.setParent(node.getParent());
		}
		
		if (node == root) {
			root = childNode;
		} else {
			BinaryNode<E> parent = node.getParent();
			
			if (parent.getLeft() == node) {
				parent.setLeft(childNode);
			} else {
				parent.setRight(childNode);
			}
		}
		
		this.size--;
		E element = node.getElement();
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		node.setElement(null);
		return element;
	}
	
	/***
	 * Post order iteration process 
	 * @return
	 */
	public List<Position<E>> getPostOrderList() {
		List<Position<E>> postOrderList = new ArrayList<>();
		
		Position<E> prev = null;
		Position<E> curr = null;
		LinkedListStack<Position<E>> stack = new LinkedListStack<>();
		
		curr = getRoot();
		stack.push(curr);
		while (!stack.isEmpty()) {
			// this is an implementation of peek in the queue type 
			curr = stack.top();
			if (prev == null || left(prev) == curr || right(prev) == curr) {
				if (left(curr) != null) {
					stack.push(left(curr));
				} else if (right(curr) != null) {
					stack.push(right(curr));
				}
			} else if (left(curr) == prev) {
			    	if (right(curr) != null) {
			    		stack.push(right(curr));
			    	}
			} else {
				postOrderList.add(curr);
				curr = stack.pop();
			}
			prev = curr;
		}

		return postOrderList;
	}
	
	public List<Position<E>> getPreOrderNext() {
		
		List<Position<E>> preOrderList = new ArrayList<>();
		if (isEmpty()) 
			return preOrderList;
		Position<E> p = getRoot();
		LinkedListStack<Position<E>> stack = new LinkedListStack<>();
		stack.push(p);

		while (!stack.isEmpty()) {
			Position<E> pos = stack.pop();
			preOrderList.add(pos);
			if (right(pos) != null) 
				stack.push(right(pos));
			if (left(pos) != null) 
				stack.push(left(pos));
		}
		//E, A, X, M, F
		//E  X  M  F  A  U  N 
		return preOrderList;
	}
	
	@Deprecated
	//This method is originally coded in the Abstract Binary Tree 
	//class with getInOrderPositions
	public List<Position<E>> inOrderRecurssive() {
		List<Position<E>> snapShot = new ArrayList<>();
		inOrderSubTree(getRoot(), snapShot);
		return snapShot;
	}
	
	/***
	 * 
	 * @param rootNode
	 */
	@Deprecated
	private void inOrderSubTree(Position<E> node, List<Position<E>> snapShot) {
		if (left(node) != null) {
			inOrderSubTree(left(node), snapShot);
		}
		
		snapShot.add(node);
		
		if (right(node) != null) {
			inOrderSubTree(right(node), snapShot);
		}
	}
	
	public List<Position<E>> getInorderNext() {
		List<Position<E>> inorderList = new ArrayList<>();
		
		LinkedListStack<Position<E>> stack = new LinkedListStack<>();
		//stack.push(getRoot());
		Position<E> curr = getRoot();
		stack.push(curr);
		
		//* while logic to load the list with the tree nodes in 
		//* inOrderIteration order 
		while (!stack.isEmpty()) {
			
			if (curr != null) {
				curr = left(curr);
				if (curr != null) 
					stack.push(curr); 
				//This logic will load 1, 2, 4 which are in the root, lefts of the current tree route, when curr is 
				//null the logic will fall into the else logic 
			} else {
				//The motive is to load the last left most node into the inorderList
				//next load the root for the 
				Position<E> last = stack.pop();
				inorderList.add(last);
				//This will load the right node in the order into the stack
				if (right(last) != null) {
					stack.push(right(last));
					curr = right(last);
				}
			}
		}
		
		return inorderList;
	}
 	
	public int getNumberOfLeftChilds() {
		int numberOfLeftChildren = 0;
		int iteration = 0;
		
		Position<E> p = getRoot();
		while (iteration < size && p != null) {
			if (left(p) != null) 
				++numberOfLeftChildren;
			p = left(p);
			++iteration;
		}
		
		
		return numberOfLeftChildren;
	}
	
}
