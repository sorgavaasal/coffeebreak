package chap.six.simple.pracs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import chap.three.simple.pracs.Node;

public class BracesCheck {

	private static Map<String, String> openCloseMap = new HashMap<>();

	private static Set<String> valueSet = new HashSet<>();
	
	public BracesCheck() {
		openCloseMap.put("}", "{");
		openCloseMap.put("]", "[");
		openCloseMap.put(")", "(");
		valueSet.addAll(openCloseMap.values());
	}
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	public boolean checkExpSyntax(String expression) {
		//Sample expression to be split 
		// "{(abc)(123)} [(def)(ghi)] (
		Stack<String> braceContent = new StackImpl<>();
		if (expression.length() <= 0)
			return false;
		
		for (int i=0; i < expression.length(); ++i) {
			
			//char charVar = expression.charAt(i);
			String charVar = String.valueOf(expression.charAt(i));
			if (valueSet.contains(String.valueOf(charVar))) {
				braceContent.push(new Node<String>(charVar, null));
			}
			
			if (openCloseMap.get(charVar) != null) {
				String closeBraceValue = openCloseMap.get(charVar);
				String stackElement = braceContent.pop().getElement();
				System.out.println("OpenBraceValue===>" +closeBraceValue);
				System.out.println("stackElement===>" +stackElement);
				System.out.println("charValue===>" +charVar);
				if (stackElement != null && stackElement.length() > 0 && closeBraceValue.equals(stackElement)) {
					continue;
				} else {
					return false;
				}
			}
		}
		
		if (braceContent.getSize() > 0) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		BracesCheck check = new BracesCheck();
		//{(abc)(123)} [(def)(ghi)] ===> valid syntax
		//{(abc)(123)} [def)(ghi)]  ===> invalid syntax
		if (check.checkExpSyntax("{(abc)(123)} [(def)(ghi)]")) {
			System.out.println("its a valid syntax");
		} else {
			System.out.println("its having an invalid syntax");
		}
		
		int i = 1;
		int j = 8;
		System.out.println(i%j);
	}
}
