package chap.five.simple.pracs;

public class ReverseLinkedList<E> {
	
	
	public void reverseSingleLinkedList(SingleLinkedList<E> list, Node<E> prev, Node<E> next, int i) {
		
		if (next == null && prev == null) {
			next = list.getFirst().getNext();
			prev = list.getFirst(); //N1
			list.getFirst().setNext(null);
		} else {
		     
			 Node<E> nextTemp = null;
		     if (next.getNext() != null) {
				nextTemp = next.getNext();
			 } else {
				nextTemp = prev; 
			 }
			  
			 next.setNext(prev);
			 prev = next;
			 next = nextTemp;
		}
		
		++i;
		if (i < list.getSize()) {
			reverseSingleLinkedList(list, prev, next, i);
		}
	}
	
	public static void main(String[] args) {
		SingleLinkedList<String> originalList = SingleLinkedListTester.buildTestLinkedList();
		SingleLinkedListTester.simpleLinkedListTester(originalList);
		//ReverseLinkedList<String> reverMe = new ReverseLinkedList<>();
		originalList.reverseSingleLinkedListRecur(originalList, null, null, 0);
		//reverMe.reverseSingleLinkedList(originalList, null, null, 0);
		SingleLinkedListTester.simpleLinkedListTester(originalList);
	}

}
