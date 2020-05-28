package chap.eighta.simple.pracs.udemy.tree;

public class BinaryIntegerTree {
	
	private BinaryNode<Integer> root; 
	private int size;

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
			return recurssiveLookup(node, binRoot.getLeftNode());
		} else {
			return recurssiveLookup(node, binRoot.getRightNode());
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
				binRoot.setLeftNode(node);
			} else {
				binRoot.setRightNode(node);
			}
			
			++size;
			return node;
		}

		if (binRoot.getElement() <= node.getElement()) {
			addNode(node, binRoot.getLeftNode());
		} else {
			addNode(node, binRoot.getRightNode());
		}
		return node;
	}

}
