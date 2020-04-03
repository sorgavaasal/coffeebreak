package chap.three.simple.pracs;

import java.util.Arrays;

public class RemoveFromArray {
	
	/**
	 * removes all the element from an array 
	 * @param inputArr
	 */
	private static void emptyTheArray (String[] inputArr) {
		
		String[] outputArr = new String[inputArr.length];
		//System.arraycopy(inputArr, 2, outputArr, 0, inputArr.length-2);
		//Arrays.asList(outputArr).forEach(System.out::println);
		//*TODO removing an element from an array the below syntax is not working 
		//System.arraycopy(inputArr, 2, inputArr, 0, inputArr.length - 2);
		System.arraycopy(inputArr, 2+1, outputArr, 2, inputArr.length - 1 - 2);
		Arrays.asList(outputArr).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		 System.out.println(Math.random());
	     emptyTheArray(new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"});
	}

}
