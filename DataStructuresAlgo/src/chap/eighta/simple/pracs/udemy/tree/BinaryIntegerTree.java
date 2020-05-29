package chap.eighta.simple.pracs.udemy.tree;

import java.util.List;

public class BinaryIntegerTree {
	
	private BinaryNode<Integer> root; 
	private int size;
	
	public BinaryNode<Integer> getRoot() {
		return this.root;
	}

	/**
	 * insert elements to the node
	 * @param node
	 * @return
	 */
	public BinaryNode<Integer> insertNode(BinaryNode<Integer> node) {
		if (root == null) {
			this.root = node;
			++size;
			return node;
		}
		
	 	return addNode(node, root);
		
	}
	
	public Integer getSize() {
		return this.size;
	}
	
	/**
	 * search the element that needs to be looked up  
	 * @param node
	 * @return
	 */
	public BinaryNode<Integer> lookUp(BinaryNode<Integer> node) {
		if (root.getElement() == node.getElement()) {
			return root;
		}
		return recurssiveLookup(node, root);
	}
	
	private BinaryNode<Integer> recurssiveLookup(BinaryNode<Integer> node, BinaryNode<Integer> binRoot) {
		
		if (binRoot == null) {
			return null;
		}

		if (binRoot.getElement() == node.getElement()) {
			return binRoot;
		}

		if (binRoot.getElement() <= node.getElement()) {
			return recurssiveLookup(node, binRoot.getRightNode());
		} else {
			return recurssiveLookup(node, binRoot.getLeftNode());
		}
	}
	
	/**
	 * recursive call for adding elements to the Binarytree 
	 * @param node
	 * @return
	 */
	private BinaryNode<Integer> addNode(BinaryNode<Integer> node, BinaryNode<Integer> binRoot) {
		
		if (binRoot.getLeftNode() == null && binRoot.getRightNode() == null) {
			if (binRoot.getElement() <= node.getElement()) {
				binRoot.setRightNode(node);
			} else {
				binRoot.setLeftNode(node);
			}
			
			++size;
			return node;
		}

		if (binRoot.getElement() <= node.getElement()) {
			addNode(node, binRoot.getRightNode());
		} else {
			addNode(node, binRoot.getLeftNode());
		}
		return node;
	}
	
	/**
	 * please pass an empty Binary node to hold the result value and iteration
	 * 
	 * @param min
	 */
	// TODO to be revisited later point of time 
	// after finishing regular iteration logic are complete 
	public void getMinimumNode(BinaryNode<Integer> min, BinaryNode<Integer> root) {
		if (min == null) {
			min = root;
			if (root.getLeftNode() == null && root.getRightNode() == null) {
				return;
			}
			getMinimumNode(min, root);
		}
	}
	
	/**
	 * Simple logic to print the content of the tree 
	 * in a Pre Order fashion 
	 * @param root
	 */
	public static void iterateTreePreOrder(BinaryNode<Integer> root) {
		if (root == null) {
			return;
		}
		printNodeContent(root);
		iterateTreePreOrder(root.getLeftNode());
		iterateTreePreOrder(root.getRightNode());
	}
	
	/**
	 * Simple logic to print the content of the tree 
	 * in an InOrder fashion 
	 * @param root
	 */
	public static void iterateTreeInOrder(BinaryNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		iterateTreePreOrder(root.getLeftNode());
		printNodeContent(root);
		iterateTreePreOrder(root.getRightNode());
	}
	
	public static void iterateTreePostOrder(BinaryNode<Integer> root) {
		if (root == null) {
			return;
		}
		
		iterateTreePostOrder(root.getLeftNode());
		iterateTreePostOrder(root.getRightNode());
		printNodeContent(root);
	}
	
	public static void printNodeContent(BinaryNode<Integer> node) {
		if (node == null) {
			System.out.println ("content of the node are null");
			return;
		}
		
		System.out.print(" Element value ===> " + node.getElement());
		System.out.println(" ==== ");
	}
	
	/**
	 * load a lists into the tree structure 
	 * @param numList
	 * @return
	 */
	//* TODO load the tree with one time value from 
	public boolean loadListToTree(List<Integer> numList) {
		if (this.root != null) {
			return false;
		}
		
		this.root = setElementToNode(numList.get(0));
		Integer prev = numList.get(0);
		Integer curr = 0;
		BinaryNode<Integer> lastNode = this.root;

		for (int i = 1; i < numList.size() - 1; ++i) {
			curr = numList.get(i);
			if (prev <= curr) {				
				lastNode.setLeftNode(setElementToNode(curr));
			} else {
				lastNode.setRightNode(setElementToNode(curr));
			}
		}
		
		return true;
	}
	
	private BinaryNode<Integer> setElementToNode(Integer element) {
		BinaryNode<Integer> node = new BinaryNode<>(element);
		return node;
	}
	

}
