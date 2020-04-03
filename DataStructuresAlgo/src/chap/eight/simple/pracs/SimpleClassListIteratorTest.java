package chap.eight.simple.pracs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleClassListIteratorTest {
	
	public static void main(String[] args) {
		List<String> myStrings = new ArrayList<>();
		myStrings.add("A");
		Iterator<String> myStringsIterator = myStrings.iterator();
		System.out.println("hasNext()===>1:" +myStringsIterator.hasNext());
		System.out.println("next()===>1:" +myStringsIterator.next());
		myStrings.add("B");
		System.out.println("haxNext()===>2:" +myStringsIterator.hasNext());
		System.out.println("next()===>2:" +myStringsIterator.next());
	}

}
