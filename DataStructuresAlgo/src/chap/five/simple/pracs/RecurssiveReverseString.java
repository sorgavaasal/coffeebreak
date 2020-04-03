package chap.five.simple.pracs;

/***
 * Write a short recursive Java method that takes a character strings and output sits
reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'
5.17 Michael GoodRich 
 * @author srividhya
 *
 */
public class RecurssiveReverseString {
	
	public static void reverseString(char[] input, int low, int high) {
		if (low > high) {
			return;
		} 
		
		char temp = input[low];
		input[low] = input[high];
		input[high] = temp;
		reverseString(input, low+1, high-1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputString = "pots&pans";
		char[] inputArr = inputString.toCharArray();
 		reverseString(inputArr, 0, inputArr.length-1);
		System.out.println(new String(inputArr));
	}

}
