package chap.eight.simple.pracs;

import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTreePlayer {
	
	private static final String input = "EXAMFUN";
	
	public static void main(String[] args) {
		LinkedBinaryTree<String> binTree = new LinkedBinaryTree<>();
		
		binTree.addRoot("E");
		
		binTree.addLeft(binTree.getRoot(), "X");
		binTree.addRight(binTree.getRoot(), "A");
		
		binTree.addLeft(binTree.left(binTree.getRoot()), "M");
		binTree.addRight(binTree.left(binTree.getRoot()), "F");
		binTree.addLeft(binTree.right(binTree.getRoot()), "U");
		binTree.addRight(binTree.right(binTree.getRoot()), "N");

		System.out.println("height of the tree " +binTree.height(binTree.getRoot()));
		System.out.println("size of the tree " +binTree.getSize());
		Iterable<Position<String>> positionList = binTree.getPositions();
		Position<String> queryPosition = null;
		
		for (Position<String> node : positionList) {
			if ("X".equals(node.getElement())) {
				queryPosition = node;
			}
			System.out.println(" Node values After Iteration " +node.getElement());
		}
		
		Position<String> next2QueryPosition = preorderNext(queryPosition, binTree);
		System.out.println("Next2QueryPosition===> " +next2QueryPosition.getElement());

		System.out.println("This is Root===>" +binTree.getRoot().getElement());
		
//  Display of positions from the InOrder Position lists 
//		Iterable<Position<String>> binPositionList = binTree.getInOrderPositions();
//		System.out.println("<===InOrderIterationList_recurssive_way===>");
//		for (Position<String> node : binPositionList) {
//			System.out.println(node.getElement());
//		}

		
//		Iterable<Position<String>> binPosiIterList = binTree.getInorderNext();
//		System.out.println("<===InOrder_Iteration_way===>");
//		for (Position<String> node : binPosiIterList) {
//			System.out.println(node.getElement());
//		}
//		int numberOfLeftChildren = binTree.getNumberOfLeftChilds();
//		System.out.println("number of left Children " +numberOfLeftChildren);
		
		List<Position<String>> positionListList = binTree.getPreOrderNext(); 
		
		System.out.println("<===Pre Order ListIteration===>");
		for (Position<String> position : positionListList) {
			System.out.println(position.getElement());
		}
		
		//* post order Iteration of the List 
		positionListList = binTree.getPostOrderList();
		
		System.out.println("<===Post order ListIteration===>");
		for (Position<String> position : positionListList) {
			System.out.println(position.getElement());
		}
		
		
		
	}
	
	public static Position<String> preorderNext(Position<String> query, LinkedBinaryTree<String> binTree) {
		Position<String> returnPosition = null;
		Iterator<Position<String>> preorderList = binTree.getPositions().iterator();
		
		while (preorderList.hasNext()) {
			if (preorderList.next() == query) {
				returnPosition = preorderList.next();
				return returnPosition;
			}
		}

		return returnPosition;
	}
	
	
 
}
