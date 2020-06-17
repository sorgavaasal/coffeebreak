package chap.eighta.simple.pracs.udemy.tree;

import java.util.List;

public class BinaryIntegerTree {
	
	private BinaryNode<Integer> root; 
	private int size;
	
	public BinaryNode<Integer> getRoot() {
		return this.root;
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
	
	/**
	 * recursive call for adding elements to the Binarytree 
	 * @param node
	 * @return
	 */
	private BinaryNode<Integer> addNode(BinaryNode<Integer> node, BinaryNode<Integer> binRoot) {
		
		if (binRoot.getElement() <= node.getElement()) {
			if (binRoot.getRightNode() == null) {
				++size;
				binRoot.setRightNode(node);
			} else {
				addNode(node, binRoot.getRightNode());
			}
		} else {
			if (binRoot.getLeftNode() == null) {
				++size;
				binRoot.setLeftNode(node);	
			} else {
				addNode(node, binRoot.getLeftNode());
			}
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
	public static BinaryNode<Integer> getMinimumNode(BinaryNode<Integer> root) {
		
		if (root == null) {
			return root;
		}
		
		if (root.getLeftNode() == null) {
			return root;
		}
		
		return getMinimumNode(root.getLeftNode());
	}
	
	/**
	 * Find maximum value of the tree in a recurssive fashion
	 * @param root
	 * @return
	 */
	public static int getMaximumDepthOfTree(BinaryNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		if (root.getLeftNode() == null && root.getRightNode() == null) {
			return 0;
		}
		
		int leftMaxNode = 1 + getMaximumDepthOfTree(root.getLeftNode());
		int rightMaxNode = 1 + getMaximumDepthOfTree(root.getRightNode());
		
		return Math.max(leftMaxNode, rightMaxNode);
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
	public boolean loadListToTree(List<Integer> numList) {
		if (this.root != null) {
			return false;
		}
		
		for (Integer number : numList) {
			this.insertNode(setElementToNode(number));
		}
		
		return true;
	}
	
	/**
	 * prints the nodes which are with in the range of low and high value
	 * 
	 * @param lowValue
	 * @param highValue
	 */
	public static void printNodesInRange(BinaryNode<Integer> root, int lowValue, int highValue) {
		if (root == null) {
			return;
		}
		
		if (root.getElement() >= lowValue && root.getElement() <= highValue) 
			printNodeContent(root);
		
		printNodesInRange(root.getLeftNode(), lowValue, highValue);
		printNodesInRange(root.getRightNode(), lowValue, highValue);
	}
	
	/**
	 * checks if the given tree is a Binary search tree or not 
	 * @param root
	 */
	public static boolean isGivenTreeBinary(BinaryNode<Integer> root) {
		
		if (root != null && (root.getLeftNode().getElement() > root.getElement() || 
				root.getRightNode().getElement() < root.getElement())) {
			return false;
		} 
		
		return isGivenTreeBinary(root.getLeftNode()) && isGivenTreeBinary(root.getRightNode());
	}
	
	private BinaryNode<Integer> setElementToNode(Integer element) {
		BinaryNode<Integer> node = new BinaryNode<>(element);
		return node;
	}
}
