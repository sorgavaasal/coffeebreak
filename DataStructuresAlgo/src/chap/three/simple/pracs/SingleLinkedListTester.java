package chap.three.simple.pracs;

public class SingleLinkedListTester {
	public static void main(String[] args) {
		String[] songsArray = {"KshiraSaagara", "Virboni", "Vaatapi", "RaraVenu", "mOkshamu galadhaa"};
		SingleLinkedList<String> firstLinkedList = new SingleLinkedList<>();
		
		System.out.println(" =============== after  Initial instantiation ================");
		System.out.println(firstLinkedList.getSize() 
				+ " " + 
				firstLinkedList.getFirst() 
				+ " " + 
				firstLinkedList.getNext(firstLinkedList.getHead()) 
				+ " " +
				firstLinkedList.getTail());
		
		firstLinkedList.addFirst(songsArray[0]);		
		System.out.println(" =============== first  Iteration ================");		
		System.out.println(firstLinkedList.getSize() 
				+ " " + 
				firstLinkedList.getFirst() 
				+ " " + 
				firstLinkedList.getTail());
		
		firstLinkedList.addFirst(songsArray[1]);
		System.out.println(" ===============  second Iteration ================");
		System.out.println(firstLinkedList.getSize() 
				+ " " + 
				firstLinkedList.getFirst() 
				+ " " + 
				firstLinkedList.getTail());
		
		firstLinkedList.addFirst(songsArray[2]);
		System.out.println(" ===============  third Iteration ================");
		System.out.println(firstLinkedList.getSize() 
				+ " " + 
				firstLinkedList.getFirst() 
				+ " " + 
				firstLinkedList.getTail());
		
		firstLinkedList.addFirst(songsArray[3]);
		System.out.println(" ===============  fourth Iteration ================");
		System.out.println(firstLinkedList.getSize() + " " + firstLinkedList.getFirst() + " " + firstLinkedList.getTail());
		
		firstLinkedList.addFirst(songsArray[4]);
		System.out.println(" ===============  fifth Iteration ================");
		System.out.println(firstLinkedList.getSize() + " " + firstLinkedList.getFirst() + " " + firstLinkedList.getTail());

		System.out.println(" Iteration implementation ");		
		Node<String> currEle = firstLinkedList.getHead();
		int j = 0;
		while (currEle != null) {
			++j;
			System.out.println(currEle.getElement() + " " +j);
			currEle = currEle.getNext();			
		}
	}
}
