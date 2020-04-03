package chap.six.simple.pracs;

public class CopyStackContent {
	
	
	public static void reverseStack(LinkedListStack<String> s, LinkedListStack<String> t) {
		while (s.top() != null) {
			t.push(s.pop());
		}
		
		System.out.println("After transfer size");
		System.out.println(s.getSize());
		System.out.println(t.getSize());
	}
	
	public static void main(String[] args) {
		LinkedListStack<String> stackList = StackUnitTesting.getStaticStack();
		stackList.push("K");
		stackList.push("L");
		stackList.push("M");
		stackList.push("N");
		stackList.push("O");
		stackList.push("P");
		stackList.push("Q");
		stackList.push("R");
		stackList.push("S");
		LinkedListStack<String> reverseStack = new LinkedListStack<String>();
		reverseStack(stackList, reverseStack);
		//*
		System.out.println(reverseStack.getSize());
				
		while (reverseStack.getSize() != 0) {
			System.out.println(reverseStack.pop());
		}
		
		System.out.println(reverseStack.getSize());
		
	}

}
