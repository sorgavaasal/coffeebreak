package chap.five.simple.pracs;

/***
 * Write a short recursive Java method that determines if a strings is a palindrome, 
that is, 
it is equal to its reverse. 
Examples of palindromes include 'racecar' and 'gohangasalamiimalasagnahog'.
 * @author srividhya
 *
 */
public class RecurssivePanlindromCheck {
	
	private static String reverseString(String inputStr) {
		char[] input = inputStr.toCharArray();
		reverseInputArr(input, 0, input.length-1);
		return new String(input);
	}
	
	private static void reverseInputArr(char[] input, int low, int high) {
		if (low > high) {
			return;
		} else {
			char temp = input[low];
			input[low] = input[high];
			input[high] = temp;
			reverseInputArr(input, low+1, high-1);
		}
	}
	
	public static void main(String[] args) {
		//racecar ---> racecar
		//malayalam ---> malayalam
		//gohangasalamiimalasagnahog
		String input = "gohangasalamiimalasagnahog";
		String output = reverseString(input);
		System.out.println(input.equals(output) + " input ===> " + input + " output===> " + output);
	}

}
