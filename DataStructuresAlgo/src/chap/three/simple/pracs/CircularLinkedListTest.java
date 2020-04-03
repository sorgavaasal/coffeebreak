package chap.three.simple.pracs;

import java.util.Arrays;

/**
 * Unit test code to test the circular linked list
 * @author srividhya
 *
 */
public class CircularLinkedListTest {
	
	public static void testCircularLinkedList() {
		CircularLinkedList<String> circleLink = new CircularLinkedList<>();
		String[] names = {"Tom Brady", "Aron Rodges", "Ben R", 
				          "Dak P", "Case Keenum", "Kirk Cousins",
				          "Andy Dolton", "Peyton Manning", "Drew Brees"};
		
		//*non lambda way of iterating an array 
/*		for (String name : names) {
			circleLink.addLast(name);
		}
*/		
		//* Java 8 way of iterating an array 
		Arrays.asList(names).forEach((name) -> circleLink.addLast(name));
		
		System.out.println(circleLink.getFirst());
		System.out.println(circleLink.getLast());
		System.out.println(circleLink.getSize());
				
		for (int i=0; i<circleLink.getSize(); ++i) {
			circleLink.rotate();
			System.out.println(circleLink.getFirst());
		}
			
	}

	public static void main(String[] args) {
		testCircularLinkedList();
	}

}
