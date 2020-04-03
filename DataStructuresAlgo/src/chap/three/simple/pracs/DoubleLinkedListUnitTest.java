package chap.three.simple.pracs;

public class DoubleLinkedListUnitTest {
	
	public static void main(String[] args) {
		DoubleLinkedList<String> dLinked = new DoubleLinkedList<>();
		dLinked.addFirst("AA");
		dLinked.addFirst("AB");
		dLinked.addFirst("AC");
		dLinked.addFirst("AD");
		dLinked.addFirst("AE");
		dLinked.addFirst("AF");
		dLinked.addFirst("AG");
		dLinked.addFirst("AH");
		dLinked.addFirst("AI");
		dLinked.addFirst("AJ");
/*		System.out.println(dLinked.getSize());
		System.out.println(dLinked.getFirst());
		System.out.println(dLinked.getLast());
		
		//* removed the first node
		System.out.println(dLinked.removeFirst());
		
		System.out.println(dLinked.getSize());
		System.out.println(dLinked.getFirst());
		System.out.println(dLinked.getLast());

		//*Removed the last node
		System.out.println(dLinked.removeLast());
		
		System.out.println(dLinked.getSize());
		System.out.println(dLinked.getFirst());
		System.out.println(dLinked.getLast());
		
		INode<String> thirdNode = dLinked.getNext(dLinked.getHead()).getNext().getNext();
		
		String removedELement = dLinked.remove(thirdNode);
		
		System.out.println(dLinked.getSize());
		System.out.println(dLinked.getFirst());
		System.out.println(dLinked.getLast());
		
		System.out.println(removedELement);*/
		
		
		INode<String> nextNode = dLinked.getHead().getNext();
		
		while (nextNode.getNext() != null) {
			System.out.println(nextNode.getElement());
			nextNode = nextNode.getNext();
		}
		
		//Reverse Iteration
		System.out.println();
		
		INode<String> prevNode = dLinked.getTail().getPrev();
		
		while (prevNode.getPrev() != null) {
			System.out.println(prevNode.getElement());
			prevNode = prevNode.getPrev();
		}
		
	}

}
