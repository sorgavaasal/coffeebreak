package chap.six.simple.pracs;

public class StackWithRandomNumbers {
	
	private static void loadIntStack(LinkedListStack<Integer> intStack) {
		System.out.println(Math.random());
		int randomInt = (int) (Math.random() * 10);
		intStack.push(randomInt);
	    intStack.push(randomInt);
	    intStack.push(randomInt);
	}
	
	public static void main(String[] args) {
		LinkedListStack<Integer> st = new LinkedListStack<>();
		loadIntStack(st);
		int x = 0;
		
	}

}
