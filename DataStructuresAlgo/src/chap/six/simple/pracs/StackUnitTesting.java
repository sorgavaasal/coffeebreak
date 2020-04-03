package chap.six.simple.pracs;

public class StackUnitTesting {

	public static LinkedListStack<String> getStaticStack() {

		LinkedListStack<String> simpleImpl = new LinkedListStack<>();
		simpleImpl.push("A");
		simpleImpl.push("B");
		simpleImpl.push("C");
		simpleImpl.push("D");
		simpleImpl.push("E");
		simpleImpl.push("F");
		simpleImpl.push("G");
		simpleImpl.push("H");
		simpleImpl.push("I");
		simpleImpl.push("J");
		return simpleImpl;

	}
	
	public static void emptyStackRecur(LinkedListStack<String> input) {
		
		if (input.getSize() != 0) {
			System.out.println(input.pop());
			emptyStackRecur(input);
		}
	}

	public static void main(String[] args) {
		LinkedListStack<String> simpleImpl = new LinkedListStack<>();
		simpleImpl.push("A");
		simpleImpl.push("B");
		simpleImpl.push("C");
		simpleImpl.push("D");
		simpleImpl.push("E");
		simpleImpl.push("F");
		simpleImpl.push("G");
		simpleImpl.push("H");
		simpleImpl.push("I");
		simpleImpl.push("J");

		System.out.println(simpleImpl.getSize());

//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
//		System.out.println(simpleImpl.pop());
		
		//simpleImpl.emptyStack();
		emptyStackRecur(simpleImpl);
		
		System.out.println(simpleImpl.getSize());
		
		
	}

}
