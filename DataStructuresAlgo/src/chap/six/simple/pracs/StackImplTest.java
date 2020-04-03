package chap.six.simple.pracs;

import java.util.ArrayList;
import java.util.List;

import chap.three.simple.pracs.Node;

public class StackImplTest {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Node<String> element = new Node<String>("Aniruddh", null);
		Stack<String> simple = new StackImpl<>(element);
		simple.push(new Node<String>("Anand", null));
		simple.push(new Node<String>("Ananth", null));
		simple.push(new Node<String>("Adam", null));
		simple.push(new Node<String>("Ashok", null));
		System.out.println("size of the stack " + simple.getSize());
		Node<String>[] stackArray = simple.toArray();
		System.out.println("arrayLength " + stackArray.length);
		for (Node<String> indexContent : stackArray) {
			System.out.println("arrayValues ===>" + indexContent.getElement());
		}

//		Node<String> first = simple.pop();
//		System.out.println("1st " + first.getElement() + "===stack size===" + simple.getSize());
//		Node<String> second = simple.pop();
//		System.out.println("2nd " + second.getElement() + "===stack size===" + simple.getSize());
//		Node<String> third = simple.pop();
//		System.out.println("3rd " + third.getElement() + "===stack size===" + simple.getSize());
//		Node<String> fourth = simple.pop();
//		System.out.println("4th " + fourth.getElement() + "===stack size===" + simple.getSize());
//		Node<String> fifth = simple.pop();
//		System.out.println("5th " + fifth.getElement() + "===stack size===" + simple.getSize());
		
		List<Node<String>> removedElements = new ArrayList<>();
		((StackImpl) simple).removeAllRecurssive(removedElements);
		
		removedElements.forEach(System.out::println);
		
		
	}

}
