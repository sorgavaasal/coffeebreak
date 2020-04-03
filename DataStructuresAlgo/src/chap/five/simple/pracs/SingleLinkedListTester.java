package chap.five.simple.pracs;

public class SingleLinkedListTester {
	
	public static SingleLinkedList<String> buildTestLinkedList() {
		SingleLinkedList<String> testObj = new SingleLinkedList<>();
		
		Node<String> input1 = new Node<> ("Ram", null);
		testObj.addFirst(input1);
		
		Node<String> input2 = new Node<> ("Shyam", null);
		testObj.addFirst(input2);

		Node<String> input3 = new Node<> ("Shiv", null);
		testObj.addFirst(input3);

		Node<String> input4 = new Node<> ("Somu", null);
		testObj.addFirst(input4);
		
		Node<String> input5 = new Node<> ("Ramu", null);
		testObj.addFirst(input5);
		
		Node<String> input6 = new Node<> ("Kamu", null);
		testObj.addFirst(input6);
		
		return testObj;
		
	}
	
	public static void simpleLinkedListTester(SingleLinkedList<String> testObj) {
		System.out.println("Prints First and last");
		System.out.println(testObj.getFirst().getElement());
		System.out.println(testObj.getTail().getElement());
		
		System.out.println("element in the First Node");
		Node<String> firstNode = testObj.getFirst();
		System.out.println(firstNode.getElement());
		Node<String> secondNode = firstNode.getNext();
		
		System.out.println("element in the second Node");
		System.out.println(secondNode.getElement());
		Node<String> thirdNode = secondNode.getNext();
		
		System.out.println("element in the third Node");
		System.out.println(thirdNode.getElement());
		Node<String> fourNode = thirdNode.getNext();
		
		System.out.println("element in the fourth Node");
		System.out.println(fourNode.getElement());
		Node<String> fifthNode = fourNode.getNext();
		
		System.out.println("element in the fifth Node");
		System.out.println(fifthNode.getElement());
		Node<String> sixthNode = fifthNode.getNext();
		
		System.out.println("element in the sixth Node");
		System.out.println(sixthNode.getElement());
		System.out.println(sixthNode.getNext());
		
	}
	
	public static void main(String[] args) {
		SingleLinkedList<String> testObj = buildTestLinkedList();
		simpleLinkedListTester(testObj);
		testObj.reverseSingleLinkedListRecur(testObj, null, null, 0);
		simpleLinkedListTester(testObj);
		
	} 

}
