package chap.eighta.simple.pracs.udemy.tree;

public class BInaryIntegerTreeRunner {
	
	public static void main(String[] args) {
		BinaryIntegerTree binTree = new BinaryIntegerTree();
		BinaryNode<Integer> firstNode = new BinaryNode<>(1);
		BinaryNode<Integer> secondNode = new BinaryNode<>(2);
		BinaryNode<Integer> thirdNode = new BinaryNode<>(3);
		BinaryNode<Integer> fourthNode = new BinaryNode<>(4);
		BinaryNode<Integer> fifthNode = new BinaryNode<>(5);
		BinaryNode<Integer> sixthNode = new BinaryNode<>(6);
		BinaryNode<Integer> seventhNode = new BinaryNode<>(7);
		BinaryNode<Integer> eighdthNode = new BinaryNode<>(8);
		BinaryNode<Integer> nineth = new BinaryNode<>(9);
		
		System.out.println("recurrsive addition of binary tree");
		binTree.insertNode(firstNode);
		binTree.insertNode(secondNode);
		binTree.insertNode(thirdNode);
		binTree.insertNode(fourthNode);
		binTree.insertNode(fifthNode);
		binTree.insertNode(sixthNode);
		binTree.insertNode(seventhNode);
		binTree.insertNode(eighdthNode);
		binTree.insertNode(nineth);
		
		System.out.println("recurrsive lookup of binary tree");
		
		BinaryNode<Integer> resultNode = binTree.lookUp(fourthNode);
		
		if (resultNode != null) {
			System.out.println("validate the result " + resultNode.getElement().equals(fourthNode.getElement()));
		} else {
			System.out.println("Node not found");
		}
		
		System.out.println("size of the binary tree " +binTree.getSize());

		System.out.println("pre-order-iteration");
		
		BinaryIntegerTree.iterateTreePreOrder(binTree.getRoot());
		
		System.out.println();
		System.out.println("In-order iteration");
		BinaryIntegerTree.iterateTreeInOrder(binTree.getRoot());
		
		System.out.println();
		System.out.println("Post-order iteration");
		BinaryIntegerTree.iterateTreePostOrder(binTree.getRoot());
		
	}

}
